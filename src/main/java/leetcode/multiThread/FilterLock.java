package leetcode.multiThread;

/**
 * @Author long
 * @Date 2020/6/3 11:31
 * @Title
 * @Description //TODO
 **/

public class FilterLock {
    int[] level;
    int[] victim;
    int n;

    public FilterLock(int n) {
        this.n = n;
        level = new int[n];
        victim = new int[n];
        for (int i = 0; i < n; i++) {
            level[i] = 0;
        }
    }

    public void lock() {
        int me = (int) Thread.currentThread().getId();
        for (int i = 0; i < n; i++) {
            level[me] = i;
            victim[i] = me;

        }
    }

    public void unlock() {
        int me = (int) Thread.currentThread().getId();
        level[me] = 0;
    }

}
