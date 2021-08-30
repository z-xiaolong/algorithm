package leetcode.medium;

import java.util.Random;

/**
 * @Author long
 * @Date 2021/8/30 10:26
 * @Title
 * @Description //TODO
 **/

public class PickIndex {
    int total;
    int[] pre;
    Random random;

    public PickIndex(int[] w) {
        int len = w.length;
        pre = new int[len];
        pre[0] = w[0];
        for (int i = 1; i < len; i++) {
            pre[i] = pre[i-1] + w[i];
        }
        total = pre[len-1];
        random = new Random();
    }

    public int pickIndex() {
        int k = random.nextInt(total);
        return binarySearch(k);
    }

    public int binarySearch(int k) {
        int left = 0;
        int right = pre.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (pre[mid] >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
