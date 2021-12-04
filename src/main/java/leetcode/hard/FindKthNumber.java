package leetcode.hard;

/**
 * @Author long
 * @Date 2021/11/16 16:40
 * @Title
 * @Description //TODO
 **/

public class FindKthNumber {


    public int findKthNumber(int n, int k) {
        long prefix = 1;
        while (k > 1) {
            long cnt = count(prefix, n);
            if (k <= cnt) {
                prefix *= 10;
                k--;
            } else {
                prefix++;
                k -= cnt;
            }
        }
        return (int) prefix;
    }

    public long count(long prefix, int n) {
        long cnt = 0;
        long nextPrefix = prefix + 1;
        while (prefix <= n) {
            cnt += Math.min(n - prefix + 1, nextPrefix - prefix);
            prefix *= 10;
            nextPrefix *= 10;
        }
        return cnt;
    }

    int min = 0;
    int k;

    public int findKthNumber1(int n, int k) {
        this.k = k;
        for (int i = 1; i < 10; i++) {
            dfs(i, n);
        }
        return min;
    }

    public void dfs(int num, int n) {
        if (num > n) return;
        if (k <= 0) return;
        k--;
        if (k == 0) {
            min = num;
            return;
        }
        for (int i = 0; i < 10; i++) {
            dfs(num * 10 + i, n);
        }
    }
}
