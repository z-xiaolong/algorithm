package multiThread;

/**
 * @Author: long
 * @Date: 2020/8/9 22:02
 * @Title
 * @Description:
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        Object o = new Object();
        synchronized (Object.class) {
            object.wait();
        }
        o.notify();
        o.notifyAll();
        Thread.yield();


        Thread thread = new Thread();
        thread.setDaemon(true);


        thread.join();
        thread.interrupt();
        thread.isInterrupted();
        Thread.interrupted();
    }

}
