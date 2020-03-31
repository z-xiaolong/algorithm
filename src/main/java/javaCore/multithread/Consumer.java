package javaCore.multithread;

/**
 * @Author long
 * @Date 2020/3/15 20:58
 * @Title
 * @Description //TODO
 **/

public class Consumer implements Runnable {
    private Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 10){
            i++;
            storage.pop();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
