package dao;

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

    public List<SanPham> danhSachSanPham (){
        List<SanPham> list = new ArrayList<>();
        String query = "select * from sanpham";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int Masp = rs.getInt("Masp");
                String Tensp = rs.getString("Tensp");
                double Giatien = rs.getDouble("Giatien");
                int Soluong = rs.getInt("Soluong");
                String Mota = rs.getString("Mota");
                int Thesim = rs.getInt("Thesim");
                int Bonhotrong = rs.getInt("Bonhotrong");
                int Ram = rs.getInt("Ram");
                String Anhbia = rs.getString("Anhbia");
                int Mahang = rs.getInt("Mahang");
                int Mahdh = rs.getInt("Mahdh");
                list.add(new SanPham(Masp, Tensp, Giatien, Soluong, Mota, Thesim, Bonhotrong, Ram, Anhbia, Mahang, Mahdh));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    public List<SanPham> danhSachSanPhamTheoMaHang (String Mahang1){
        List<SanPham> list = new ArrayList<>();
        String query = "select * from sanpham where Mahang = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, Mahang1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int Masp = rs.getInt("Masp");
                String Tensp = rs.getString("Tensp");
                double Giatien = rs.getDouble("Giatien");
                int Soluong = rs.getInt("Soluong");
                String Mota = rs.getString("Mota");
                int Thesim = rs.getInt("Thesim");
                int Bonhotrong = rs.getInt("Bonhotrong");
                int Ram = rs.getInt("Ram");
                String Anhbia = rs.getString("Anhbia");
                int Mahang = rs.getInt("Mahang");
                int Mahdh = rs.getInt("Mahdh");
                list.add(new SanPham(Masp, Tensp, Giatien, Soluong, Mota, Thesim, Bonhotrong, Ram, Anhbia, Mahang, Mahdh));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    public List<SanPham> danhSachSanPhamTheoMasp (String Masp1){
        List<SanPham> list = new ArrayList<>();
        String query = "select * from sanpham where Masp = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, Masp1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int Masp = rs.getInt("Masp");
                String Tensp = rs.getString("Tensp");
                double Giatien = rs.getDouble("Giatien");
                int Soluong = rs.getInt("Soluong");
                String Mota = rs.getString("Mota");
                int Thesim = rs.getInt("Thesim");
                int Bonhotrong = rs.getInt("Bonhotrong");
                int Ram = rs.getInt("Ram");
                String Anhbia = rs.getString("Anhbia");
                int Mahang = rs.getInt("Mahang");
                int Mahdh = rs.getInt("Mahdh");
                list.add(new SanPham(Masp, Tensp, Giatien, Soluong, Mota, Thesim, Bonhotrong, Ram, Anhbia, Mahang, Mahdh));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }


}
