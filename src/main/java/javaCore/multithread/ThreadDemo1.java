package javaCore.multithread;

/**
 * @Author long
 * @Date 2020/3/15 20:33
 * @Title 多线程
 * @Description //TODO
 **/

public class ThreadDemo1 {

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.setDaemon(true);//设置成守护线程，守护线程不能访问资源
        threadDemo.start();
        Thread.sleep(2000);
        System.out.println("主线程结束！");
    }

    static class ThreadDemo extends Thread {


        @Override
        public void run() {
            while (true) {
                System.out.println("线程运行中...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
