package leetcode.swordOffer.easy;


import java.util.*;

/**
 * @Author long
 * @Date 2020/3/16 10:26
 * @Title 面试题62. 圆圈中最后剩下的数字
 * @Description //TODO
 **/

public class LastRemaining {

    public static void main(String[] args) {
        lastRemaining(5, 3);
    }

    //数学
    public static int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    //list: 超时
    public static int lastRemainingII(int n, int m) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }
        int startIndex = 0;
        while (linkedList.size() > 1) {
            int size = linkedList.size();
            startIndex = (startIndex + m - 1) % size;
            linkedList.remove(startIndex);
        }
        return linkedList.getFirst();
    }

    //暴力法 超时
    public static int lastRemainingI(int n, int m) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        int count = 1;
        int remain = n;
        int index = 0;
        while (remain != 1) {
            if (count == m && nums[index % n] != -1) {
                nums[index % n] = -1;
                remain--;
                count = 1;
            } else if (nums[index % n] != -1) {
                count++;
            }
            index++;
        }
        for (int num : nums) {
            if (num != -1) {
                return num;
            }
        }
        return 0;
    }
}
