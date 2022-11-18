package dao;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhongTroDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/module3?useSSL=false";
    private String jdbcUsername="root";
    private String jdbcPassword = "Nghia_2001";

    public PhongTroDAO() {
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

    public List<PhongTro> hienThiPhongTro(String q, String q1, String q2) {
        List<PhongTro> phongTros = new ArrayList<>();
        String query = "select * from phongtro where MaPhongTro like ? and TenNguoiThueTro like ? and Sdt like ?";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, '%'+ q + '%');
            preparedStatement.setString(2, '%'+ q1 + '%');
            preparedStatement.setString(3, '%'+ q2 + '%');
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int MaPhongTro = rs.getInt("MaPhongTro");
                String TenNguoiThueTro = rs.getString("TenNguoiThueTro");
                String Sdt = rs.getString("Sdt");
                String NgayBatDau = rs.getString("NgayBatDau");
                int HinhThucThanhToan = rs.getInt("HinhThucThanhToan");
                String GhiChu = rs.getString("GhiChu");

                phongTros.add(new PhongTro(MaPhongTro, TenNguoiThueTro, Sdt, NgayBatDau, HinhThucThanhToan, GhiChu));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return phongTros;
    }


    public void themPhongTro(PhongTro phongTro) throws SQLException {
        String query = "INSERT INTO phongtro" + "(TenNguoiThueTro, Sdt, NgayBatDau, HinhThucThanhToan, GhiChu) VALUES" +" (?, ?, ?, ?, ?)";
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,phongTro.getTenNguoiThueTro());
            preparedStatement.setString(2,phongTro.getSdt());
            preparedStatement.setDate(3,Date.valueOf(phongTro.getNgayBatDau()));
            preparedStatement.setInt(4,phongTro.getHinhThucThanhToan());
            preparedStatement.setString(5,phongTro.getGhiChu());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    public boolean xoaPhongTro(int MaPhongTro) throws SQLException {
        boolean rowDeleted;
        String query = "delete from phongtro where MaPhongTro = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, MaPhongTro);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public List<HinhThucThanhToan> hienThiHinhThucThanhToan() {
        List<HinhThucThanhToan> hinhThucThanhToans = new ArrayList<>();
        String query = "select * from hinhthucthanhtoan";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int MaHinhThuc = rs.getInt("MaHinhThuc");
                String TenHinhThuc = rs.getString("TenHinhThuc");
                hinhThucThanhToans.add(new HinhThucThanhToan(MaHinhThuc, TenHinhThuc));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return hinhThucThanhToans;
    }

}
