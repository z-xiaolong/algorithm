package test;

/**
 * @Author long
 * @Date 2021/6/1 9:42
 * @Title
 * @Description //TODO
 **/

public class ThreadDemo {

    public static void main(String[] args) {

        Thread t = Thread.currentThread();
        t.setName("Admin Thread");
        // set thread priority to 1
        t.setPriority(1);

        // prints the current thread
        System.out.println("Thread = " + t);
        //线程1
        Thread threadA = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //线程2
        Thread threadB = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //给线程命名
        threadA.setName("Thread A");
        threadB.setName("Thread B");
        //启动线程
        threadA.start();
        threadB.start();

        int count = Thread.activeCount();
        System.out.println("currently active threads = " + count);

        Thread[] threads = new Thread[count];
        // returns the number of threads put into the array
        Thread.enumerate(threads);

        // prints active threads
        for (int i = 0; i < count; i++) {
            System.out.println(i + ": " + threads[i]);
        }
    }
}
