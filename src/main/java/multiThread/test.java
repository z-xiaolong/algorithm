package multiThread;

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

    public static void main(String[] args) {
        thread1.start();
        try {
            Thread.sleep(5000);
            //thread1.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
