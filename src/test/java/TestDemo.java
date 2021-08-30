import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author long
 * @Date 2020/2/8 17:28
 * @Title
 * @Description //TODO
 **/
@SpringBootTest
public class TestDemo {
    public static void main(String[] args) throws InterruptedException {
        String s = "";
        long sBeginTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            s+="s";
        }
        s.wait();
        long sEndTime = System.currentTimeMillis();
        System.out.println("s拼接100000遍s耗时: " + (sEndTime - sBeginTime) + "ms");

        StringBuffer s1 = new StringBuffer();
        long s1BeginTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            s1.append("s");
        }
        long s1EndTime = System.currentTimeMillis();
        System.out.println("s1拼接100000遍s耗时: " + (s1EndTime - s1BeginTime) + "ms");

        StringBuilder s2 = new StringBuilder();
        long s2BeginTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            s2.append("s");
        }
        long s2EndTime = System.currentTimeMillis();
        System.out.println("s2拼接100000遍s耗时: " + (s2EndTime - s2BeginTime) + "ms");
    }
    @Test
    public void test(){
        String s = "abcd";
        s = s.concat("ef");
    }
}
