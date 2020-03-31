package myRedis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

/**
 * @Author long
 * @Date 2020/3/25 22:43
 * @Title
 * @Description //TODO
 **/

public class RedisDemo {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("114.116.92.105", 6379);
        jedis.auth("root");
        //查看服务是否运行
        System.out.println("连接成功: " + jedis.ping());
        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }
}
