package leetcode.hard;

/**
 * @Author long
 * @Date 2021/3/21 16:42
 * @Title
 * @Description //TODO
 **/

public class CountPairs {

    public int countPairs(int[] nums, int low, int high) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xor = nums[i] ^ nums[j];
                if (xor >= low && xor <= high) {
                    count++;
                }
            }
        }
        return count;
    }
}
