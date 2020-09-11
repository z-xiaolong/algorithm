package database;

/**
 * @Author: long
 * @Date: 2020/8/13 9:58
 * @Title
 * @Description:
 */
public class Main {


    private static int num = 1000000;

    public static void main(String[] args) throws InterruptedException {
        int n = 10;
        Thread[] threads = new Thread[n];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(Main::run);
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);


    }


    public static void run() {
        DBService service = new DBService();
        for (int i = 0; i < 100000; i++) {
            User user = UserFactory.getUser();
            service.saveUser(user);
        }
    }
}
