package javaCore.multithread;

/**
 * @Author long
 * @Date 2020/3/15 20:59
 * @Title
 * @Description //TODO
 **/

public class ProductTest {
    public static void main(String[] args) throws InterruptedException {
        Storage storage = new Storage();
        Thread consumer1 = new Thread(new Consumer(storage));
        consumer1.setName("消费者1");
        Thread consumer2 = new Thread(new Consumer(storage));
        consumer2.setName("消费者2");
        Thread producer1 = new Thread(new Producer(storage));
        producer1.setName("生产者1");
        Thread producer2 = new Thread(new Producer(storage));
        producer2.setName("生产者2");

        producer1.start();
        producer2.start();
        Thread.sleep(1000);
        consumer1.start();
        consumer2.start();

    }
}
