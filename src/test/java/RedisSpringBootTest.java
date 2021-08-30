import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author: long
 * @Date: 2020/9/11 9:44
 * @Title
 * @Description:
 */
@SpringBootTest
public class RedisSpringBootTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        //redisTemplate.opsForList();
        redisTemplate.opsForValue().set("long","long");
        System.out.println(redisTemplate.opsForValue().get("long"));
    }
}