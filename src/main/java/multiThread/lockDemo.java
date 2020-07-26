package multiThread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author long
 * @Date 2020/7/16 22:18
 * @Title
 * @Description //TODO
 **/

public class lockDemo {

    public static void main(String[] args) {
        System.out.println("begin park");
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("end park");
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
    }
}
