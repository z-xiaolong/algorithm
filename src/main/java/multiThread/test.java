package multiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author long
 * @Date 2020/1/2 11:22
 * @Title
 * @Description //TODO
 **/

public class test {
    static Thread thread1 = new Thread(){
        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("interrupt");
                e.printStackTrace();
            }
        });
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }
}
