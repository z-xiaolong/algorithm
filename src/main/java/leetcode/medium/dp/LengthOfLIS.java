package leetcode.medium.dp;

import leetcode.entity.ListNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/2/21 15:11
 * @Title 300. 最长上升子序列
 * @Description 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 **/

public class LengthOfLIS {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i : list) {
            System.out.print(i);
        }
    }

    //二分法
    public int lengthOfLIS2(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        for (int num : nums) {
            addList(lists, num);
        }
        return lists.size();
    }

    public int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数初始化为0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];
            /***** 搜索左侧边界的⼆分查找*****/
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            /*********************************/
            // 没找到合适的牌堆，新建⼀堆
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是LIS ⻓度
        return piles;
    }


    public void addList(List<List<Integer>> lists, int num) {
        for (List<Integer> list : lists) {
            int last = list.get(list.size() - 1);
            if (last < num) {
                list.add(num);
                return;
            }
        }
        List<Integer> list = new LinkedList<>();
        list.add(num);
        lists.add(list);
    }

    //动态规划
    public int lengthOfLISDP(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] array = new int[nums.length];
        Arrays.fill(array, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    array[i] = Math.max(array[j] + 1, array[i]);
                }
            }
        }
        int max = 0;
        for (int n : array) {
            max = Math.max(max, n);
        }
        return max;
    }
}
