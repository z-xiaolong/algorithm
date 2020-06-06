package multiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author long
 * @Date 2020/4/12 21:20
 * @Title 可重入锁
 * @Description //TODO
 **/

public class ReentrantLockDemo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(3);
        new Thread(calculator, "thread1").start();
        new Thread(calculator, "thread2").start();
    }
}

class Calculator implements Runnable {
    private Lock lock = new ReentrantLock();
    public int i;

    public Calculator(int i) {
        this.i = i;
    }

    public int calculate(int i) {
        lock.lock();
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "：计算" + i + "的阶乘");
        if (i == 1) {
            lock.unlock();
            lock.unlock();
            return 1;
        }
        int result = i * calculate(i - 1);
        lock.unlock();
        lock.unlock();
        return result;
    }

    @Override
    public void run() {
        int res = calculate(i);
        System.out.println(i + "！= " + res);
    }
}

