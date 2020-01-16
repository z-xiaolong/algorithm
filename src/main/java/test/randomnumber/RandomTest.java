package test.randomnumber;

import java.util.Random;

/**
 * @Author long
 * @Date 2019/12/19 19:30
 * @Title
 * @Description //TODO
 **/

public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[50];
        for (int i = 0; i < 100000000; i++) {
            int number = random.nextInt(50);
            array[number]++;
        }

        for (int i : array) {
            System.out.print(i + " ");
        }
    }


    private double rate = 0.0045;

    private int geometric() {
        int times = 0;
        Random random = new Random();
        double randomNumber = random.nextDouble();
        double counter = 1.0;
        while (counter > randomNumber) {
            times++;
            counter = counter * (1 - rate);
            randomNumber = random.nextDouble();
        }
        return times;
    }

    private int rand(double lambda) {
        Random random = new Random();
        double u = random.nextDouble();
        int x = 0;
        double cdf = 0;
        while (u >= cdf) {
            x++;
            cdf = 1 - Math.exp(-1.0 * lambda * x);
        }
        return x;
    }

    public static void test() {
        RandomTest demoTest = new RandomTest();
        double lambda = 0.008;
        int[] arr = new int[500];
        for (int i = 0; i < 100000; i++) {
            int rand = demoTest.rand(lambda);
            if (rand < 500) {
                arr[rand]++;
            }
        }
        for (int i = 1; i < 500; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
