package dao;

import model.DanhMuc;
import model.NguoiDung;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DanhMucDAO {
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

    public List<DanhMuc> listDanhMuc (){
        List<DanhMuc> list = new ArrayList<>();
        String query = "select * from danhmuc";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int Madanhmuc = rs.getInt("Madanhmuc");
                String Tendanhmuc = rs.getString("Tendanhmuc");
                list.add(new DanhMuc(Madanhmuc, Tendanhmuc));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    public DanhMuc timDanhMuc (int Madanhmuc1){
        DanhMuc danhMuc = null;
        String query = "select * from danhmuc where Madanhmuc = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, Madanhmuc1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int Madanhmuc = rs.getInt("Madanhmuc");
                String Tendanhmuc = rs.getString("Tendanhmuc");
                danhMuc = new DanhMuc(Madanhmuc, Tendanhmuc);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return danhMuc;
    }

    public void themDanhmuc(DanhMuc danhMuc){
        String query = "insert into danhmuc (Tendanhmuc) values(?);";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, danhMuc.getTendanhmuc());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    public boolean xoaDanhMuc(int Madanhmuc) throws SQLException {
        boolean rowDeleted;
        String query = "delete from danhmuc where Madanhmuc = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, Madanhmuc);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean suaDanhMuc(DanhMuc danhMuc) throws SQLException {
        boolean rowUpdated;
        String query = "update danhmuc set Tendanhmuc = ? where Madanhmuc = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, danhMuc.getTendanhmuc());
            statement.setInt(2, danhMuc.getMadanhmuc());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated ;
    }
}
