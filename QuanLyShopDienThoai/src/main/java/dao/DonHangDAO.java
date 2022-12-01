package dao;

import model.*;
import model.ChiTietDonHang;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DonHangDAO {
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

    public void themDonHang(NguoiDung nguoiDung, GioHang gioHang){
        LocalDate localDate = java.time.LocalDate.now();
        String Ngaydat = localDate.toString();
        int manguoiban =  gioHang.getMatHangs().get(0).getSanpham().getManguoidung();
        String query = "insert into donhang (Ngaydat, Manguoidung, Manguoiban) values(?,?,?)";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,Ngaydat);
            preparedStatement.setInt(2,nguoiDung.getManguoidung());
            preparedStatement.setInt(3, manguoiban);
            preparedStatement.executeUpdate();
            String query1 = "select Madon from donhang order by Madon desc limit 1";
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            ResultSet rs = preparedStatement1.executeQuery();
            if(rs.next()){
                // lay madon tu ban donhang
                int Madon = rs.getInt("Madon");
                for(MatHang i : gioHang.getMatHangs()){
                    String query2 = "insert into chitietdonhang (Madon, Masp, Soluong, Dongia) values(?,?,?,?)";
                    PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
                    preparedStatement2.setInt(1,Madon);
                    preparedStatement2.setInt(2,i.getSanpham().getMasp());
                    preparedStatement2.setInt(3,i.getSoluong());
                    preparedStatement2.setDouble(4,i.getDongia());
                    preparedStatement2.executeUpdate();
                }
            }
        }catch (SQLException e){
            printSQLException(e);
        }

    }

    public List<DonHang> donHangTheoMaNguoiDung(int Manguoidung1){
        List<DonHang> list = new ArrayList<>();
        String query = "select * from donhang where Manguoidung like ?";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Manguoidung1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int Madon = rs.getInt("Madon");
                String Ngaydat = rs.getString("Ngaydat");
                String Tinhtrang = rs.getString("Tinhtrang");
                int Manguoidung = rs.getInt("Manguoidung");
                int Manguoiban = rs.getInt("Manguoiban");
                list.add(new DonHang(Madon, Ngaydat, Tinhtrang, Manguoidung, Manguoiban));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<DonHang> donHangTheoMaNguoiBan(int Manguoiban1){
        List<DonHang> list = new ArrayList<>();
        String query = "select * from donhang where Manguoiban like ?";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Manguoiban1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int Madon = rs.getInt("Madon");
                String Ngaydat = rs.getString("Ngaydat");
                String Tinhtrang = rs.getString("Tinhtrang");
                int Manguoidung = rs.getInt("Manguoidung");
                int Manguoiban = rs.getInt("Manguoiban");
                list.add(new DonHang(Madon, Ngaydat, Tinhtrang, Manguoidung, Manguoiban));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



}
