package dao;

import model.Account;
import model.User;

import java.sql.*;

public class AccountDAO {
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


    public Account login(String user, String pass){
        Account account= null;
        String query = "select * from account where username = ? and password = ?";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,pass);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int idadmin = rs.getInt("idadmin");
                account = new Account(id,username, password, idadmin);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return account;
    }

    public Account checkAccountExist(String user){
        Account account= null;
        String query = "select * from account where username = ? ";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,user);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int idadmin = rs.getInt("idadmin");
                account = new Account(id,username, password, idadmin);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return account;
    }

    public void signup(String user, String pass){
        String query = "insert into account (username, password, idadmin) values(?,?,0);";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,pass);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
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


}
