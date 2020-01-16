package leetcode.medium;

/**
 * @Author long
 * @Date 2019/12/29 19:10
 * @Title
 * @Description //TODO
 **/

public class SortColors {

    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        for (int num : nums) {
            colors[num]++;
        }
        for (int i = 0; i < nums.length; i++) {
            colors[nums[i]]++;
            nums[i] = 0;
        }
        for (int i = 0; i < colors[0]; i++) {
            nums[i] = 0;
        }
        for (int i = colors[0]; i < colors[0] + colors[1]; i++) {
            nums[i] = 1;
        }
        for (int i = colors[0] + colors[1]; i < nums.length; i++) {
            nums[i] = 2;
        }
    }

    class Solution {
        /*
        荷兰三色旗问题解
        */
        public void sortColors(int[] nums) {
            // 对于所有 idx < i : nums[idx < i] = 0
            // j是当前考虑元素的下标
            int p0 = 0, curr = 0;
            // 对于所有 idx > k : nums[idx > k] = 2
            int p2 = nums.length - 1;

            int tmp;
            while (curr <= p2) {
                if (nums[curr] == 0) {
                    // 交换第 p0个和第curr个元素
                    // i++，j++
                    tmp = nums[p0];
                    nums[p0++] = nums[curr];
                    nums[curr++] = tmp;
                }
                else if (nums[curr] == 2) {
                    // 交换第k个和第curr个元素
                    // p2--
                    tmp = nums[curr];
                    nums[curr] = nums[p2];
                    nums[p2--] = tmp;
                }
                else {
                    curr++;
                }
            }
        }
    }


}
