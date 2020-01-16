package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/1/6 14:53
 * @Title
 * @Description //TODO
 **/

public class DBService {

    private Connection conn = null; //打开数据库对象
    private PreparedStatement ps = null;//操作整合sql语句的对象
    private ResultSet rs = null;//查询结果的集合

    //DBService 对象
    public static DBService dbService = null;

    /**
     * 构造方法 私有化
     */

    private DBService() {

    }

    /**
     * 获取MySQL数据库单例类对象
     */

    public static DBService getDbService() {
        if (dbService == null) {
            dbService = new DBService();
        }
        return dbService;
    }


    public List<User> getUserData() {
        //结果存放集合
        List<User> list = new ArrayList<>();
        //MySQL 语句
        String sql = "select * from user";
        //获取链接数据库对象
        conn = DBUtil.getConn();
        try {
            if (conn != null && (!conn.isClosed())) {
                ps = conn.prepareStatement(sql);
                if (ps != null) {
                    rs = ps.executeQuery();
                    if (rs != null) {
                        while (rs.next()) {
                            User u = new User();
                            u.setAge(rs.getInt("age"));
                            u.setName(rs.getString("name"));
                            u.setAddress(rs.getString("address"));
                            list.add(u);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeAll(conn, ps, rs);//关闭相关操作
        return list;
    }
}
