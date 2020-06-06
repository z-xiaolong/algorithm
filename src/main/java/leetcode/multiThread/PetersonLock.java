package leetcode.multiThread;

/**
 * @Author long
 * @Date 2020/6/3 11:18
 * @Title
 * @Description //TODO
 **/

public class PetersonLock {

    private volatile int victim;
    private boolean[] flag = new boolean[2];

    public void lock() {
        int id = (int) Thread.currentThread().getId();
        flag[id] = true;
        victim = id;
        while (flag[1 - id] && victim == id) {
        }
    }

    public void unlock() {
        int id = (int) Thread.currentThread().getId();
        flag[id] = false;
    }
}
