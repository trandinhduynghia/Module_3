package dao;

import model.NguoiDung;
import model.SanPham;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/qldienthoai?useSSL=false";
    private String jdbcUsername="root";
    private String jdbcPassword = "Nghia_2001";

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

    public List<SanPham> danhSachSanPham (String q){
        List<SanPham> list = new ArrayList<>();
        String query = "select * from sanpham where Tensp like ?";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, '%'+ q + '%');
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int Masp = rs.getInt("Masp");
                String Tensp = rs.getString("Tensp");
                double Giatien = rs.getDouble("Gia");
                int Soluong = rs.getInt("Soluong");
                String Mota = rs.getString("Mota");
                String Thesim = rs.getString("Thesim");
                String Bonho = rs.getString("Bonho");
                String Ram = rs.getString("Ram");
                String Anhbia = rs.getString("Anhbia");
                int Madanhmuc = rs.getInt("Madanhmuc");
                int Manguoidung = rs.getInt("Manguoidung");
                list.add(new SanPham(Masp, Tensp, Giatien, Soluong, Mota, Thesim, Bonho, Ram, Anhbia, Madanhmuc, Manguoidung));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    public List<SanPham> danhSachSanPhamTheoMaDanhMuc (String Madanhmuc1){
        List<SanPham> list = new ArrayList<>();
        String query = "select * from sanpham where Madanhmuc = ?";
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Madanhmuc1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int Masp = rs.getInt("Masp");
                String Tensp = rs.getString("Tensp");
                double Giatien = rs.getDouble("Gia");
                int Soluong = rs.getInt("Soluong");
                String Mota = rs.getString("Mota");
                String Thesim = rs.getString("Thesim");
                String Bonho = rs.getString("Bonho");
                String Ram = rs.getString("Ram");
                String Anhbia = rs.getString("Anhbia");
                int Madanhmuc = rs.getInt("Madanhmuc");
                int Manguoidung = rs.getInt("Manguoidung");
                list.add(new SanPham(Masp, Tensp, Giatien, Soluong, Mota, Thesim, Bonho, Ram, Anhbia, Madanhmuc, Manguoidung));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    public List<SanPham> danhSachSanPhamTheoMaNguoiDung (String Manguoidung1){
        List<SanPham> list = new ArrayList<>();
        String query = "select * from sanpham where Manguoidung = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, Manguoidung1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int Masp = rs.getInt("Masp");
                String Tensp = rs.getString("Tensp");
                double Giatien = rs.getDouble("Gia");
                int Soluong = rs.getInt("Soluong");
                String Mota = rs.getString("Mota");
                String Thesim = rs.getString("Thesim");
                String Bonho = rs.getString("Bonho");
                String Ram = rs.getString("Ram");
                String Anhbia = rs.getString("Anhbia");
                int Madanhmuc = rs.getInt("Madanhmuc");
                int Manguoidung = rs.getInt("Manguoidung");
                list.add(new SanPham(Masp, Tensp, Giatien, Soluong, Mota, Thesim, Bonho, Ram, Anhbia, Madanhmuc, Manguoidung));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    public SanPham sanPhamTheoMasp (String Masp1){
        SanPham sanPham = null;
        String query = "select * from sanpham where Masp = ?";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Masp1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int Masp = rs.getInt("Masp");
                String Tensp = rs.getString("Tensp");
                double Giatien = rs.getDouble("Gia");
                int Soluong = rs.getInt("Soluong");
                String Mota = rs.getString("Mota");
                String Thesim = rs.getString("Thesim");
                String Bonho = rs.getString("Bonho");
                String Ram = rs.getString("Ram");
                String Anhbia = rs.getString("Anhbia");
                int Madanhmuc = rs.getInt("Madanhmuc");
                int Manguoidung = rs.getInt("Manguoidung");
                sanPham = new SanPham (Masp, Tensp, Giatien, Soluong, Mota, Thesim, Bonho, Ram, Anhbia, Madanhmuc, Manguoidung);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return sanPham;
    }

    public boolean xoaSanPham(int Masp) throws SQLException {
        boolean rowDeleted;
        String query = "delete from sanpham where Masp = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, Masp);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean suaSanPham(SanPham sanPham) throws SQLException {
        boolean rowUpdated;
        String query = "update sanpham set Tensp = ?, Gia = ?, Soluong = ?, Mota = ?, Thesim = ?, Bonho = ?, Ram = ?, Anhbia = ?, Madanhmuc = ?, Manguoidung = ? where Masp = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,sanPham.getTensp());
            statement.setDouble(2,sanPham.getGiatien());
            statement.setInt(3,sanPham.getSoluong());
            statement.setString(4,sanPham.getMota());
            statement.setString(5,sanPham.getThesim());
            statement.setString(6,sanPham.getBonho());
            statement.setString(7,sanPham.getRam());
            statement.setString(8,sanPham.getAnhbia());
            statement.setInt(9,sanPham.getMadanhmuc());
            statement.setInt(10,sanPham.getManguoidung());
            statement.setInt(11,sanPham.getMasp());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated ;
    }

    public void themSanPham(SanPham sanPham){
        String query = "insert into sanpham (Tensp, Gia, Soluong, Mota, Thesim, Bonho, Ram, Anhbia, Madanhmuc, Manguoidung) values(?,?,?,?,?,?,?,?,?,?);";
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,sanPham.getTensp());
            preparedStatement.setDouble(2, sanPham.getGiatien());
            preparedStatement.setInt(3,sanPham.getSoluong());
            preparedStatement.setString(4,sanPham.getMota());
            preparedStatement.setString(5, sanPham.getThesim());
            preparedStatement.setString(6, sanPham.getBonho());
            preparedStatement.setString(7, sanPham.getRam());
            preparedStatement.setString(8, sanPham.getAnhbia());
            preparedStatement.setInt(9, sanPham.getMadanhmuc());
            preparedStatement.setInt(10, sanPham.getManguoidung());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }


}
