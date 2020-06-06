package leetcode.contest;

import org.omg.PortableInterceptor.INACTIVE;

import javax.crypto.spec.PSource;
import java.util.*;

/**
 * @Author long
 * @Date 2020/5/3 10:24
 * @Title
 * @Description //TODO
 **/

public class Contest187 {


    //5400. 旅行终点站
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : paths) {
            map.put(list.get(0), list.get(1));
        }
        String start = paths.get(0).get(0);
        while (map.containsKey(start)) {
            start = map.get(start);
        }
        return start;
    }


    //5401. 是否所有 1 都至少相隔 k 个元素
    public boolean kLengthApart(int[] nums, int k) {
        int length = nums.length;
        int left = -1;
        int right = 0;
        while (right < length) {
            if (nums[right] == 1) {
                if (left == -1) left = right;
                else if (right - left - 1 < k) {
                    return false;
                } else {
                    left = right;
                }
            }
            right++;
        }
        return true;
    }


    //5402. 绝对差不超过限制的最长连续子数组
    public int longestSubarray(int[] nums, int limit) {
        int length = nums.length;
        int res = 0;
        int left = 0, right = 0;
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        int max, min;
        while (right < length) {
            if (maxDeque.isEmpty()) maxDeque.addLast(nums[right]);
            else {
                while (!maxDeque.isEmpty() && maxDeque.peekLast() <= nums[right]) {
                    maxDeque.pollLast();
                }
                maxDeque.addLast(nums[right]);
            }
            if (minDeque.isEmpty()) minDeque.addLast(nums[right]);
            else {
                while (!minDeque.isEmpty() && minDeque.peekLast() >= nums[right]) {
                    minDeque.pollLast();
                }
                minDeque.addLast(nums[right]);
            }
            max = maxDeque.peekFirst();
            min = minDeque.peekFirst();
            while (left < right && max - min > limit) {
                if (nums[left] == max && !maxDeque.isEmpty()) {
                    maxDeque.pollFirst();
                    max = maxDeque.peekFirst();
                }
                if (nums[left] == min && !minDeque.isEmpty()) {
                    minDeque.pollFirst();
                    min = minDeque.peekFirst();
                }
                left++;
            }
            right++;
            res = Math.max(res, right - left);
        }
        return res;
    }


    //5403. 有序矩阵中的第 k 个最小数组和
    public int kthSmallest(int[][] mat, int k) {
        int left = 0;
        int right = 0;
        for (int[] num : mat) {
            right += num[num.length - 1];
            left += num[0];
        }
        int base = left;
        while (left < right) {
            int mid = (left + right) >> 1;
            count = 1;
            dfs(mat, 0, base, mid, k);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    int count = 0;

    public void dfs(int[][] mat, int index, int sum, int mid, int k) {
        if (index == mat.length || sum > mid || count > k) return;
        dfs(mat, index + 1, sum, mid, k);
        for (int i = 1; i < mat[index].length; i++) {
            int temp = sum + mat[index][i] - mat[index][0];
            if (temp > mid) break;
            count++;
            dfs(mat, index + 1, temp, mid, k);
        }
    }


    public static void main(String[] args) {
        Contest187 contest187 = new Contest187();
        int[][] nums = new int[][]{{1, 3, 11}, {2, 4, 6}};
        contest187.kthSmallest(nums, 5);
    }
}