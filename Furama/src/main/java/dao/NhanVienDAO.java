package dao;
import model.NhanVien;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class NhanVienDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama?useSSL=false";
    private String jdbcUsername="root";
    private String jdbcPassword = "Nghia_2001";

    private static final String INSERT_NHANVIEN_SQL = "INSERT INTO nhanvien" + "(HoTen, NgaySinh, SoCMND, Luong, SoDT, Email, DiaChi, MaViTri, MaTrinhDo, MaBoPhan) VALUES" +" (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select * from nhanvien where MaNV =?";
    private static final String SELECT_ALL_NHANVIEN = "select * from nhanvien where HoTen like ?";
    private static final String DELETE_USERS_SQL = "delete from nhanvien where MaNV = ?;";
    private static final String UPDATE_USERS_SQL = "update nhanvien set HoTen = ?, NgaySinh = ?, SoCMND = ?, Luong = ?, SoDT = ?, Email = ?, DiaChi = ?, MaViTri = ?, MaTrinhDo = ?, MaBoPhan = ? where MaNV = ?";

    public NhanVienDAO(){

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

    public void insertNhanVien(NhanVien nhanVien) throws SQLException {
        System.out.println(INSERT_NHANVIEN_SQL);
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NHANVIEN_SQL)){
            preparedStatement.setString(1,nhanVien.getHoTen());
            //ps.setDate(2, Date.valueOf(student.getBirthday()));
            preparedStatement.setString(2,nhanVien.getNgaySinh());
            preparedStatement.setString(3,nhanVien.getSoCMND());
            preparedStatement.setDouble(4, nhanVien.getLuong());
            preparedStatement.setString(5,nhanVien.getSoDT());
            preparedStatement.setString(6,nhanVien.getEmail());
            preparedStatement.setString(7,nhanVien.getDiaChi());
            preparedStatement.setInt(8, nhanVien.getMaViTri());
            preparedStatement.setInt(9, nhanVien.getMaTrinhDo());
            preparedStatement.setInt(10, nhanVien.getMaBoPhan());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);

        }

    }

    public NhanVien selectNhanVien(int MaNV) {
        NhanVien nhanVien = null;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)){
            preparedStatement.setInt(1,MaNV);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String HoTen = rs.getString("HoTen");
                String NgaySinh = rs.getString("NgaySinh");
                String SoCMND = rs.getString("SoCMND");
                Double Luong = rs.getDouble("Luong");
                String SoDT = rs.getString("SoDT");
                String Email = rs.getString("Email");
                String DiaChi = rs.getString("DiaChi");
                Integer MaViTri = rs.getInt("MaViTri");
                Integer MaTrinhDo = rs.getInt("MaTrinhDo");
                Integer MaBoPhan = rs.getInt("MaBoPhan");
                nhanVien = new NhanVien(MaNV, HoTen, NgaySinh, SoCMND, Luong, SoDT, Email, DiaChi, MaViTri, MaTrinhDo, MaBoPhan);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return nhanVien;
    }

    public List<NhanVien> selectAllNhanVien(String q) {
        List<model.NhanVien> nhanViens = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NHANVIEN)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.setString(1, '%'+ q + '%');
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int MaNV = rs.getInt("MaNV");
                String HoTen = rs.getString("HoTen");
                String NgaySinh = rs.getString("NgaySinh");
                String SoCMND = rs.getString("SoCMND");
                double Luong = rs.getDouble("Luong");
                String SoDT = rs.getString("SoDT");
                String Email = rs.getString("Email");
                String DiaChi = rs.getString("DiaChi");
                int MaViTri = rs.getInt("MaViTri");
                int MaTrinhDo = rs.getInt("MaTrinhDo");
                int MaBoPhan = rs.getInt("MaBoPhan");
                nhanViens.add(new NhanVien(MaNV, HoTen, NgaySinh, SoCMND, Luong, SoDT, Email, DiaChi, MaViTri, MaTrinhDo, MaBoPhan));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return nhanViens;
    }

    public boolean deleteNhanVien(int MaNV) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, MaNV);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(NhanVien nhanVien) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, nhanVien.getHoTen());
            statement.setString(2, nhanVien.getNgaySinh());
            statement.setString(3,nhanVien.getSoCMND());
            statement.setDouble(4, nhanVien.getLuong());
            statement.setString(5,nhanVien.getSoDT());
            statement.setString(6,nhanVien.getEmail());
            statement.setString(7,nhanVien.getDiaChi());
            statement.setInt(8, nhanVien.getMaViTri());
            statement.setInt(9, nhanVien.getMaTrinhDo());
            statement.setInt(10, nhanVien.getMaBoPhan());
            statement.setInt(11,nhanVien.getMaNV() );

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
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
