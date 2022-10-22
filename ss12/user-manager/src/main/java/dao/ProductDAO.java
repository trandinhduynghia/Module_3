package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
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

    public List<Product> getAllProduct (){
        List<Product> list = new ArrayList<>();
        String query = "select * from product";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                String title = rs.getString("title");
                String description = rs.getString("description");
                list.add(new Product(id, name, image, price, title, description));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    public List<Product> getProductByCateID (String cid){
        List<Product> list = new ArrayList<>();
        String query = "select * from product where cateid = ? ";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, cid);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                String title = rs.getString("title");
                String description = rs.getString("description");
                list.add(new Product(id, name, image, price, title, description));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    public Product getProductByID (String cid){
        String query = "select * from product where id = ? ";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, cid);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                String title = rs.getString("title");
                String description = rs.getString("description");
                return new Product(id, name, image, price, title, description);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }
}
