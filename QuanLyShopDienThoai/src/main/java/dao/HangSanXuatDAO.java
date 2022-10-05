package dao;

import model.HangSanXuat;
import model.SanPham;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HangSanXuatDAO {
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

    public List<HangSanXuat> danhHangSanXuat (){
        List<HangSanXuat> list = new ArrayList<>();
        String query = "select * from hangsanxuat";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int Mahang = rs.getInt("Mahang");
                String Tenhang = rs.getString("Tenhang");
                list.add(new HangSanXuat(Mahang, Tenhang));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }
}
