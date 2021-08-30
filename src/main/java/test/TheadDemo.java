package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author long
 * @Date 2021/6/5 19:51
 * @Title
 * @Description //TODO
 **/

public class TheadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        double x = 1.5;
        final double[] y = {0};
        Callable<Double> callable = () -> {
            if (x > -1 && x < 7) {
                y[0] = 5.0;
            }
            System.out.println(y[0]);
            //Random random = new Random();
            //int r = random.nextInt(10);
            //Thread.sleep(1000);
            if (x >= 1 && x <= 2) {
                y[0] = 6.0;
            }
            if (x >= 8 && x >= 9) {
                y[0] = 7.0;
            }
            return y[0];
        };
        FutureTask<Double> futureTask1 = new FutureTask<>(callable);
        FutureTask<Double> futureTask2 = new FutureTask<>(callable);
        FutureTask<Double> futureTask3 = new FutureTask<>(callable);
        FutureTask<Double> futureTask4 = new FutureTask<>(callable);

        Thread thread1 = new Thread(futureTask1);
        Thread thread2 = new Thread(futureTask2);
        Thread thread3 = new Thread(futureTask3);
        Thread thread4 = new Thread(futureTask4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());
        System.out.println(futureTask3.get());
        System.out.println(futureTask4.get());
    }
}
