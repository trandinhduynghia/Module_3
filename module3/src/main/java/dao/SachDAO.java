package dao;

import model.Sach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SachDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/module3?useSSL=false";
    private String jdbcUsername="root";
    private String jdbcPassword = "Nghia_2001";

    public SachDAO() {
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

    public List<Sach> hienThiSach() {
        List<Sach> sachs = new ArrayList<>();
        String query = "select * from sach";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int MaSach = rs.getInt("MaSach");
                String TenSach = rs.getString("TenSach");
                String TacGia = rs.getString("TacGia");
                String MoTa = rs.getString("MoTa");
                int SoLuong = rs.getInt("SoLuong");
                sachs.add(new Sach(MaSach, TenSach, TacGia, MoTa, SoLuong));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return sachs;
    }
}
