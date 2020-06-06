package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author long
 * @Date 2020/4/21 9:32
 * @Title 1248. 统计「优美子数组」
 * @Description //TODO
 **/

public class NumberOfSubarrays {

    public static void main(String[] args) {
        NumberOfSubarrays numberOfSubarrays = new NumberOfSubarrays();
        numberOfSubarrays.numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2);
    }

    //最佳解，真的厉害！！！
    public int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int ans = 0;
        int sum = 0;
        int[] map = new int[nums.length + 1];
        map[0] = 1;
        for (int i : nums) {
            sum += i & 1;
            map[sum]++;
            if (sum >= k) ans += map[sum - k];
        }
        return ans;
    }

    //执行用时 :18 ms, 在所有 Java 提交中击败了34.88%的用户
    public int numberOfSubarraysII(int[] nums, int k) {
        int count = 0;
        int prev = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                queue.add(i);
                if (queue.size() == k) {
                    prev = queue.peek() + 1;
                } else if (queue.size() > k) {
                    int index = queue.poll();
                    prev = queue.peek() - index;
                }
            }
            count += prev;
        }
        return count;
    }

    //超时
    public int numberOfSubarraysI(int[] nums, int k) {
        int pre = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                pre = getNumber(nums, i, k);
            }
            count += pre;
        }
        return count;
    }

    public int getNumber(int[] nums, int index, int k) {
        int count = 0;
        int odd = 0;
        for (int i = index; i >= 0; i--) {
            if (nums[i] % 2 == 1) odd++;
            if (odd == k) {
                count++;
            } else if (odd > k) break;
        }
        return count;
    }
}
