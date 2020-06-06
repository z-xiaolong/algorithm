package leetcode.easy;

/**
 * @Author long
 * @Date 2020/5/4 23:38
 * @Title 189. 旋转数组
 * @Description //TODO
 **/

public class Rotate {
    public void rotate(int[] nums, int k) {
        if (k == 0) return;
        int n = nums.length;
        for (int i = n - k - 1, j = n - 1; i >= 0; i--, j--) {
            swap(nums, i, j);
        }
        int mod = n % k;
        if (mod == 0) return;
        for (int i = mod - 1; i >= 0; i--) {
            int step = k - mod;
            while (step > 0) {
                swap(nums,i,++i);
                step--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
