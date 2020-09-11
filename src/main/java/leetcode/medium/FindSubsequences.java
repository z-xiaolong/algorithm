package leetcode.medium;

import java.util.*;

/**
 * @Author: long
 * @Date: 2020/8/25 10:35
 * @Title
 * @Description:
 */
public class FindSubsequences {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 4, 6};
        FindSubsequences find = new FindSubsequences();
        find.findSubsequences(nums);
    }


    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }

    public List<List<Integer>> findSubsequences1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < (1 << n); i++) {
            List<Integer> temp = getTemp(nums, i);
            int hash = hash(temp);
            if (!set.contains(hash) && check(temp)) {
                res.add(temp);
                set.add(hash);
            }
        }
        return res;
    }

    public List<Integer> getTemp(int[] nums, int i) {
        List<Integer> temp = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if ((i & 1) == 1) {
                temp.add(nums[j]);
            }
            i = i >> 1;
        }
        return temp;
    }

    public boolean check(List<Integer> temp) {
        for (int i = 0; i < temp.size() - 1; i++) {
            if (temp.get(i) > temp.get(i + 1)) return false;
        }
        return temp.size() >= 2;
    }


    public int hash(List<Integer> temp) {
        int mod = (int) 1E9 + 7;
        int hash = 0;
        for (int v : temp) {
            hash = hash * 264 % mod + v + 101;
            hash %= mod;
        }
        return hash;
    }
}
