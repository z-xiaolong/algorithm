package leetcode.medium;

import java.util.*;

/**
 * @Author: long
 * @Date: 2020/10/5 20:25
 * @Title 18. 四数之和
 * @Description:
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, list, nums, target, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int target, int index) {
        if (list.size() == 4) {
            if (target == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        int size = list.size();
        int len = nums.length;
        for (int i = index; i < len; i++) {
            if (len - i < 4 - size) {
                return;
            }
            if (i == index || nums[i] != nums[i - 1]) {
                list.add(nums[i]);
                dfs(res, list, nums, target - nums[i], index + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
