package database;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 5:41 PM , 12/17/2020
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import utils.Configs;

public class DAOManager {
    // JDBC Driver Name And Database URL
    public static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String port = "3306";
    public static String DB_URL = "jdbc:mysql://localhost:" + port + "/" + Configs.DB_NAME;

    //  Database Credentials
    public static String DB_USER = Configs.DB_USERNAME;
    public static String DB_PASS = Configs.DB_PASSWORD;

    // Database Connection
    Connection conn = null;
    Statement stmt = null;

    public DAOManager() throws Exception
    {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Created DB Connection....");
        } catch (ClassNotFoundException e) {
            // Handle errors for Class.forName
            throw e;
        } catch (Exception e) {
            // Handle errors for Exception
            throw e;
        }
    }

    public void open() throws SQLException {
        try {
            if (this.conn == null && this.stmt == null) {
//                System.out.println(DB_URL);
                this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                this.stmt = conn.createStatement();
            }
        } catch (SQLException e) {
            // Handle errors for JDBC
            e.printStackTrace();
            throw e;
        }
    }

    public void close() throws SQLException
    {
        try {
            if (this.conn != null)
                this.conn.close();
        } catch(SQLException e) {
            // Handle errors for JDBC
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String args[]){
        try{
        DAOManager daoMngr = new DAOManager();
        daoMngr.open();
        daoMngr.close();}
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
