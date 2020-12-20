package database;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 5:41 PM , 12/17/2020
 */
import java.sql.*;

import entity.The;
import utils.Configs;

/**
 * Quả lý truy cập và sửa đổi CSDL
 */
public class DAOManager {
    // JDBC Driver Name And Database URL
    public static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String port = "3306";
    public static String DB_URL = "jdbc:mysql://localhost:" + port + "/" + Configs.DB_NAME;

    //  Database Credentials
    public static String DB_USER = Configs.DB_USERNAME;
    public static String DB_PASS = Configs.DB_PASSWORD;

    // Database Connection
    public Connection connection = null;
    public Statement statement = null;

    private static DAOManager daoManager = null;

    /**
     * Singleton
     * @return 1 đối tượng DAOManager duy nhất trong mỗi phiên
     */
    public static DAOManager getInstance() {
        if (daoManager == null) {
            daoManager = new DAOManager();
        }
        return daoManager;
    }

    public DAOManager()
    {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Created DB Connection....");
            this.open();
        } catch (Exception e) {
            // Handle errors for Exception
            e.printStackTrace();
        }
    }

    /**
     * Mở kết nối nếu chưa được mở
     */
    public void open()  {
        try {
            if (this.connection == null && this.statement == null) {
//                System.out.println(DB_URL);
                this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                this.statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
            }
        } catch (SQLException e) {
            // Handle errors for JDBC
            e.printStackTrace();
        }
    }

    /**
     * Đóng kết nối
     * @throws SQLException nếu lỗi không đóng được
     */
    public void close() throws SQLException
    {
        try {
            if (this.connection != null)
                this.connection.close();
        } catch(SQLException e) {
            // Handle errors for JDBC
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Thực hiện 1 truy vấn và trả về kết quả
     * @param query truy vấn
     * @return ResultSet kết quả thực thi truy vấn
     */
    public ResultSet executeQuery(String query)
    {
        ResultSet resultSet = null;
        try {
            System.out.println(query);
            this.statement.execute(query);
            resultSet = this.statement.getResultSet();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return resultSet;
    }
}
