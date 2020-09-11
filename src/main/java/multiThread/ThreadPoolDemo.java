package multiThread;

import java.util.concurrent.*;

/**
 * @Author: long
 * @Date: 2020/8/2 11:00
 * @Title
 * @Description:
 */
public class ThreadPoolDemo {


    public static void main(String[] args) {
        Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,
                6,
                5L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                new ThreadPoolExecutor.AbortPolicy());
        try {
            for (int i = 0; i < 10; i++) {
                executor.execute(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t" + "办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println("main end");

    }
}
