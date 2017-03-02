import java.sql.*;

/**
 * Created by Dorota Marszałek on 2017-03-01.
 */
public class MySQLConnector {
    private static MySQLConnector instance;
    private final static String DBURL = "jdbc:mysql://5.135.218.27/Dorota?characterEncoding=utf8";
    private final static String DBLOGIN = "dorota";
    private final static String DBPASSWORD = "12345678";

    private Connection conn;


    private MySQLConnector(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DBURL, DBLOGIN, DBPASSWORD);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connected!");
    }

    public static MySQLConnector getINSTANCE(){
        if (instance == null){
            instance = new MySQLConnector();
        }
        return instance;
    }

    public Statement getStatement(){
        try {
            return conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PreparedStatement getPreparedStatement(String sql){
        try {
            return conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
