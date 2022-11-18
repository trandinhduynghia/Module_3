package dao;

import model.KhachHang;
import model.MaLoaiKhach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama?useSSL=false";
    private String jdbcUsername="root";
    private String jdbcPassword = "Nghia_2001";

    public KhachHangDAO() {
    }

    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public List<KhachHang> hienThiKhachHang(String q, String q1) {
        List<KhachHang> khachHangs = new ArrayList<>();
        String query = "select * from khachhang where HoTen like ? and GioiTinh like ?";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, '%'+ q + '%');
            preparedStatement.setString(2, '%'+ q1 + '%');
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int MaKH = rs.getInt("MaKH");
                int MaLoaiKhach = rs.getInt("MaLoaiKhach");
                String HoTen = rs.getString("HoTen");
                String NgaySinh = rs.getString("NgaySinh");
                String GioiTinh = rs.getString("GioiTinh");
                String SoCMND = rs.getString("SoCMND");
                String SoDT = rs.getString("SoDT");
                String Email = rs.getString("Email");
                String DiaChi = rs.getString("DiaChi");
                khachHangs.add(new KhachHang(MaKH, MaLoaiKhach, HoTen, NgaySinh, GioiTinh, SoCMND, SoDT, Email, DiaChi));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return khachHangs;
    }

    public void themKhachHang(KhachHang khachHang) throws SQLException {
        String query = "INSERT INTO khachhang" + "(MaLoaiKhach, HoTen, NgaySinh, GioiTinh, SoCMND, SoDT, Email, DiaChi) VALUES" +" (?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,khachHang.getMaLoaiKhach());
            preparedStatement.setString(2,khachHang.getHoTen());
            preparedStatement.setDate(3, Date.valueOf(khachHang.getNgaySinh()));
            preparedStatement.setString(4, khachHang.getGioiTinh());
            preparedStatement.setString(5, khachHang.getSoCMND());
            preparedStatement.setString(6, khachHang.getSoDT());
            preparedStatement.setString(7, khachHang.getEmail());
            preparedStatement.setString(8, khachHang.getDiaChi());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    public KhachHang timKhachHang(int MaKH) {
        KhachHang khachHang = null;
        String query = "select * from khachhang where MaKH =?";
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, MaKH);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int MaLoaiKhach = rs.getInt("MaLoaiKhach");
                String HoTen = rs.getString("HoTen");
                String NgaySinh = rs.getString("NgaySinh");
                String GioiTinh = rs.getString("GioiTinh");
                String SoCMND = rs.getString("SoCMND");
                String SoDT = rs.getString("SoDT");
                String Email = rs.getString("Email");
                String DiaChi = rs.getString("DiaChi");
                khachHang = new KhachHang(MaKH, MaLoaiKhach, HoTen, NgaySinh, GioiTinh, SoCMND, SoDT, Email, DiaChi);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return khachHang;
    }

    public boolean xoaKhachHang(int MaKH) throws SQLException {
        boolean rowDeleted;
        String query = "delete from khachhang where MaKH = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, MaKH);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean capNhatKhachHang(KhachHang khachHang) throws SQLException {
        boolean rowUpdated;
        String query = "update khachhang set MaLoaiKhach = ?, HoTen = ?, NgaySinh = ?, GioiTinh = ?, SoCMND = ?, SoDT = ?, Email = ?, DiaChi = ? where MaKH = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, khachHang.getMaLoaiKhach());
            statement.setString(2, khachHang.getHoTen());
            statement.setString(3, khachHang.getNgaySinh());
            statement.setString(4,khachHang.getGioiTinh());
            statement.setString(5,khachHang.getSoCMND());
            statement.setString(6,khachHang.getSoDT());
            statement.setString(7,khachHang.getEmail());
            statement.setString(8,khachHang.getDiaChi());
            statement.setInt(9,khachHang.getMaKH());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public List<MaLoaiKhach> hienThiMaLoaiKhach() {
        List<MaLoaiKhach> maLoaiKhachs = new ArrayList<>();
        String query = "select * from loaikhach ";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int MaLoaiKhach = rs.getInt("MaLoaiKhach");
                String TenLoaiKhach = rs.getString("TenLoaiKhach");
                maLoaiKhachs.add(new MaLoaiKhach(MaLoaiKhach, TenLoaiKhach));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return maLoaiKhachs;
    }
}
