package dao;

import model.ChiTietDonHang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChiTietDonHangDAO {
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

    public List<ChiTietDonHang> chiTietDonHang(int Madon1){
        List<model.ChiTietDonHang> list = new ArrayList<>();
        String query = "select * from chitietdonhang where Madon like ?";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Madon1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int Madon = rs.getInt("Madon");
                int Masp = rs.getInt("Masp");
                int Soluong = rs.getInt("Soluong");
                Double DonGia = rs.getDouble("Dongia");
                list.add(new model.ChiTietDonHang(Madon, Masp, Soluong, DonGia));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ChiTietDonHang> list(){
        List<model.ChiTietDonHang> list = new ArrayList<>();
        String query = "select * from chitietdonhang";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int Madon = rs.getInt("Madon");
                int Masp = rs.getInt("Masp");
                int Soluong = rs.getInt("Soluong");
                Double DonGia = rs.getDouble("Dongia");
                list.add(new model.ChiTietDonHang(Madon, Masp, Soluong, DonGia));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public double tongTien(int Madon){
        ChiTietDonHangDAO chiTietDonHangDAO = new ChiTietDonHangDAO();
        List<model.ChiTietDonHang> list = chiTietDonHangDAO.chiTietDonHang(Madon);
        double tongTien = 0;
        for(ChiTietDonHang i : list){
            tongTien += i.getThanhTien();
        }
        return tongTien;
    }
}
