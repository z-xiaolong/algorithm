package algorithm.chapter6;

/**
 * @Author long
 * @Date 2019/10/6 15:04
 * @Description
 */
public class QueueTest {
    public static void main(String[] args) {
        MaxPriorityQueue queue = new MaxPriorityQueue();
        for (int i = 0; i < 10; i++) {
            int random = ((int) (Math.random() * 1000000)) % 50;
            queue.add(random);
            System.out.print(random + " ");
        }
        queue.print();
        System.out.println("Size: " + queue.getSize());
        for (int i = 0; i < 10; i++) {
            int random = ((int) (Math.random() * 1000000)) % 50;
            queue.add(random);
            System.out.print(random + " ");
        }
        queue.print();
        System.out.println("Size: " + queue.getSize());
        queue.sort();
        System.out.println(Math.random());
    }
}
