package test;

/**
 * @Author long
 * @Date 2020/3/20 16:20
 * @Title
 * @Description //TODO
 **/

public class Main {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println(name + "=" + Thread.currentThread().getThreadGroup());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread1 = new Thread(runnable, "thread1");
        Thread thread2 = new Thread(runnable, "thread2");
        Thread thread3 = new Thread(runnable, "thread3");
        Thread thread4 = new Thread(() -> {
            Thread thread = new Thread(runnable, "thread5");
            thread.start();
            try {
                String name = Thread.currentThread().getName();
                System.out.println(name + "=" + Thread.currentThread().getThreadGroup());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread4");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(thread1);
        String name = Thread.currentThread().getName();
        System.out.println(name + "=" + Thread.currentThread().getThreadGroup());
        System.out.println(Thread.activeCount());
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.getParent());
        System.out.println(threadGroup.activeGroupCount());

    }


}
