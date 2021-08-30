package algorithm.chapter8;

import java.util.List;

/**
 * @Author long
 * @Date 21:31 2019/10/17
 * @Title
 * @Description 桶排序，时间复杂度：O(n)
 **/

public class BucketSort {

    public void bucketSort(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int len = nums.length;
        List[] bucket = new List[len];

    }

    public int maximumGap(int[] nums) {
        return 0;
    }
}
