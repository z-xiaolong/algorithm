package multiThread.sync;

import org.openjdk.jol.info.ClassLayout;

import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: long
 * @Date: 2020/8/5 17:25
 * @Title
 * @Description:
 */
public class SyncDemo {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        LockSupport.park();
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        Thread.sleep(5000);

        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        //AbstractQueuedSynchronizer
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        CountDownLatch latch = new CountDownLatch(10); //减法计数器
        CyclicBarrier barrier = new CyclicBarrier(10); //加法计数器
        Semaphore semaphore = new Semaphore(10);
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readWriteLock.readLock();
        latch.countDown();
        barrier.await();
        Thread thread = new Thread();
        Object object = new Object();
        object.wait();
        thread.start();
        thread.run();
        thread.join();
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
    }
}
