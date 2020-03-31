package javaCore.multithread;

import java.util.Random;

/**
 * @Author long
 * @Date 2020/3/15 20:59
 * @Title
 * @Description //TODO
 **/

public class Producer implements Runnable {
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int i = 0;
        Random random = new Random();
        while (i < 10) {
            i++;
            Product product = new Product(i, "电话" + random.nextInt());
            storage.push(product);
        }
    }
}
