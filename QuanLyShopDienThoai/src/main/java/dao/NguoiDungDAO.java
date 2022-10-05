package dao;

import model.NguoiDung;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {
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

    public NguoiDung dangNhap(String email, String matKhau){
        NguoiDung nguoiDung= null;
        String query = "select * from Nguoidung where Email = ? and Matkhau = ?";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,matKhau);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int Manguoidung = rs.getInt("Manguoidung");
                String Hoten  = rs.getString("Hoten");
                String Email = rs.getString("Email");
                String Dienthoai = rs.getString("Dienthoai");
                String Matkhau = rs.getString("Matkhau");
                int IDquyen  = rs.getInt("IDquyen");
                nguoiDung = new NguoiDung(Manguoidung, Hoten, Email, Dienthoai, Matkhau, IDquyen);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return nguoiDung;
    }

    public void dangKy(String Hoten, String Email, String Dienthoai, String Matkhau){
        String query = "insert into nguoidung (Hoten, Email, Dienthoai, Matkhau, IDquyen) values(?,?,?,?,0);";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,Hoten);
            preparedStatement.setString(2,Email);
            preparedStatement.setString(3,Dienthoai);
            preparedStatement.setString(4,Matkhau);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    public List<NguoiDung> danhSachNguoiDung(int batDau, int soLuong, String Hoten1){
        String query = "select SQL_CALC_FOUND_ROWS * from nguoidung where Hoten like ? limit " + batDau + ", " + soLuong;
        List<NguoiDung> list = new ArrayList<>();
        NguoiDung nguoiDung = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection  = getConnection();
            stmt = connection.prepareStatement(query);
            stmt.setString(1,'%'+ Hoten1 +'%');

            System.out.println(stmt);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int Manguoidung = rs.getInt("Manguoidung");
                String Hoten  = rs.getString("Hoten");
                String Email = rs.getString("Email");
                String Dienthoai = rs.getString("Dienthoai");
                String Matkhau = rs.getString("Matkhau");
                int IDquyen  = rs.getInt("IDquyen");
                list.add(new NguoiDung(Manguoidung, Hoten, Email, Dienthoai, Matkhau, IDquyen));
            }
            rs.close();
            rs = stmt.executeQuery("SELECT FOUND_ROWS()");
            if(rs.next())
                this.soLuong = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally
        {
            try {
                if(stmt != null)
                    stmt.close();
                if(connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private int soLuong;

    public int getSoLuong() {
        return soLuong;
    }

    public NguoiDung nguoiDungTheoMa(int Manguoidung1) {
        NguoiDung nguoiDung = null;
        String query = "select * from nguoidung where Manguoidung = ?";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,Manguoidung1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int Manguoidung = rs.getInt("Manguoidung");
                String Hoten  = rs.getString("Hoten");
                String Email = rs.getString("Email");
                String Dienthoai = rs.getString("Dienthoai");
                String Matkhau = rs.getString("Matkhau");
                int IDquyen  = rs.getInt("IDquyen");
                nguoiDung = new NguoiDung(Manguoidung, Hoten, Email, Dienthoai, Matkhau, IDquyen);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return nguoiDung;
    }

    public boolean xoaNguoiDung(int Manguoidung) throws SQLException {
        boolean rowDeleted;
        String query = "delete from nguoidung where Manguoidung = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, Manguoidung);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean suaNguoiDung(NguoiDung nguoiDung) throws SQLException {
        boolean rowUpdated;
        String query = "update nguoidung set Hoten = ?, Email= ?, Dienthoai = ?, Matkhau = ?, IDquyen = ? where Manguoidung = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,nguoiDung.getHoten());
            statement.setString(2,nguoiDung.getEmail());
            statement.setString(3,nguoiDung.getDienthoai());
            statement.setString(4,nguoiDung.getMatkhau());
            statement.setInt(5,nguoiDung.getIDquyen());
            statement.setInt(6,nguoiDung.getManguoidung());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

}
