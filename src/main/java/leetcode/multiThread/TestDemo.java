package leetcode.multiThread;


import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Author long
 * @Date 2020/7/8 11:28
 * @Title
 * @Description //TODO
 **/

public class TestDemo {

    @Test
    public void ThreadLocalDemo(){
        ThreadLocal<String> local = new ThreadLocal<>();
        Thread thread = new Thread();
        local.set("");
    }

    @Test
    public void arrayTest() {
        int row = 10240;
        int column = 10240;

        long[][] array = new long[row][column];
        long start = System.currentTimeMillis();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                array[i][j] = i * 2 + j;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("顺序访问耗时：" + (end - start) + "ms");
        start = System.currentTimeMillis();
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                array[j][i] = i * 2 + j;
            }
        }
        end = System.currentTimeMillis();
        System.out.println("非顺序访问耗时：" + (end - start) + "ms");
    }

    @Test
    public void RandomTest() {
        Random random = new Random(10);
        int a = random.nextInt(5);
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        for (int i = 0; i < 5; i++) {
            System.out.println(localRandom.nextInt(5));
        }
    }

    @Test
    public void AtomicDemo(){
        AtomicLong atomicLong = new AtomicLong(100);
        atomicLong.getAndIncrement();
        LongAdder longAdder = new LongAdder();
    }

}
