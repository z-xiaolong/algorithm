package multiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: long
 * @Date: 2020/8/9 22:02
 * @Title
 * @Description:
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Callable<String> callable = () -> "result";
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println(futureTask.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
