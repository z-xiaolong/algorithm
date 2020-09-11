package database;

import java.sql.*;
import java.util.List;

public class DBUtil {

    private static final String DRIVER = "com.mysql.jdbc.Driver";//MySQL 驱动
    private static final String URL = "jdbc:mysql://localhost:3306/my_db?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8";//MYSQL数据库连接Url
    private static final String USER = "root";//用户名
    //private static final String PASSWORD = "Zxl5201314@";//密码
    private static final String PASSWORD = "root";//密码

    /**
     * 连接数据库
     */
    public static void main(String[] args) {
        DBService dbService = DBService.getDbService();
        List<User> users = dbService.getUserData();
        for (User u : users) {
            System.out.println(u);
        }
    }

    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);//获取MYSQL驱动
            conn = DriverManager.getConnection(URL, USER, PASSWORD);//获取连接
            System.out.println("数据库连接成功");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeAll(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭数据库
     */
    public static void closeAll(Connection conn, PreparedStatement ps) {
        closeAll(conn);
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭数据库
     */

    public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
        closeAll(conn, ps);
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
