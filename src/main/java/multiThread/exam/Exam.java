package multiThread.exam;

/**
 * @Author long
 * @Date 2020/11/23 17:13
 * @Title
 * @Description //TODO
 **/

public class Exam {
    public static void main(String[] args) {
        String[] arr = new String[]{"1","2","3","4"};
        String[] brr= new String[]{"a","b","c"};
        MyThread myThread1 = new MyThread(arr, 0);
        MyThread myThread2 = new MyThread(brr, 1);
        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);
        thread1.start();
        thread2.start();
    }
}

class MyThread implements Runnable {
    private final String[] arr;
    public final static Object obj = new Object();
    public int index;
    private static int cur = 0;
    private final int flag;

    public static int cnt = 0;
    public MyThread(String[] arr, int flag){
        this.arr = arr;
        this.index = 0;
        this.flag = flag;
        cnt++;
    }

    @Override
    public void run(){
        while (cur < arr.length * 2){
            synchronized (obj){
                if (cur % 2 == flag) {
                    System.out.print(arr[index]);
                    index++;
                    cur++;
                    obj.notifyAll();
                } else {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
