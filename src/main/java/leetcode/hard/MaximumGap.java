package leetcode.hard;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2021/3/13 15:58
 * @Title
 * @Description //TODO
 **/

public class MaximumGap {

    public static void main(String[] args) {
        int[] nums = new int[]{3,6,9,1};
        MaximumGap maximumGap = new MaximumGap();
        maximumGap.maximumGap(nums);
    }

    //桶排序
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int bucketNum = (max - min) / bucketSize + 1;

        int[][] bucket = new int[bucketNum][2];
        for (int[] b : bucket) {
            Arrays.fill(b, -1);
        }
        for (int num : nums) {
            int index = (num - min) / bucketSize;
            if (bucket[index][0] == -1) {
                bucket[index][0] = num;
                bucket[index][1] = num;
            } else {
                bucket[index][0] = Math.min(bucket[index][0], num);
                bucket[index][1] = Math.max(bucket[index][1], num);
            }
        }
        int gap = 0;
        int pre = -1;
        for (int i = 0; i < bucketNum; i++) {
            if (bucket[i][0] == -1) {
                continue;
            }
            if (pre != -1) {
                gap = Math.max(gap, bucket[i][0] - bucket[pre][1]);
            }
            pre = i;
        }
        return gap;
    }
}
