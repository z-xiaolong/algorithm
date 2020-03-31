package leetcode.easy;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author long
 * @Date 2020/3/6 9:19
 * @Title 面试题57 - II. 和为s的连续正数序列
 * @Description 输入一个正整数 target ，输出所有和为 target 的连续正整数序列
 * （至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 **/

public class FindContinuousSequence {
    public static void main(String[] args) {
        FindContinuousSequence sequence = new FindContinuousSequence();
        sequence.findContinuousSequence(15);
    }

    //别人的解法
    public int[][] findContinuousSequence(int N) {
        //m项 首项为x 差为1 等差数列和为N, (x + x + m - 1)*m/2 = N
        //移项 (2x + m - 1)*m = 2*N
        //整理 x = (2 * N + m * (1 - m))/(2 * m) > 0, x为正整数
        List<int[]> res = new ArrayList<>();
        for (int m = 1; 2 * N - m * m + m > 0; m++) {
            int remainder = (2 * N - m * m + m) % (2 * m);
            if (remainder == 0 && m != 1) {//we r not adding the single N
                int[] arr = new int[m];
                arr[0] = (2 * N + m * (1 - m)) / (2 * m);//递推填充
                for (int i = 1; i < m; i++) arr[i] = arr[i - 1] + 1;
                res.add(0, arr);//头插逆序
            }
        }
        return res.toArray(new int[0][]);
    }

    //双指针
    public int[][] findContinuousSequenceII(int target) {
        LinkedList<int[]> lists = new LinkedList<>();
        int mid = (target / 2) + 1;
        int start = 1;
        int end = 1;
        while (start <= mid && end <= mid) {
            int temp = (start + end) * (end - start + 1) / 2;
            if (temp == target) {
                int[] nums = new int[end - start + 1];
                int value = start;
                for (int i = 0; i <= nums.length; i++) {
                    nums[i] = value;
                    value++;
                }
                lists.addLast(nums);
                end++;
            } else if (temp > target) {
                start++;
            } else {
                end++;
            }
        }
        int[][] res = new int[lists.size()][];
        return lists.toArray(res);
    }

    //数学法: 7 ms, 在所有 Java 提交中击败了52.48%的用户
    public int[][] findContinuousSequenceI(int target) {
        int mid = (target / 2) + 1;
        int[] nums = new int[mid + 1];
        int count = 0;
        for (int i = 1; i <= mid; i++) {
            int length = compute(i, target);
            if (length != 0) {
                count++;
            }
            nums[i] = length;
        }
        return convertToArray(nums, count);
    }

    public int compute(int index, int target) {
        long temp = 2 * index - 1;
        long delta = temp * temp + 8 * target;
        long x = (long) Math.sqrt(delta);
        if (x * x != delta) {
            return 0;
        }
        if ((x - temp) % 2 == 0) {
            return (int) (x - temp) / 2;
        }
        return 0;
    }

    public int[][] convertToArray(int[] nums, int count) {
        int[][] result = new int[count][];
        for (int k = 1, i = 0; k < nums.length && i < count; k++) {
            int length = nums[k];
            if (length > 0) {
                result[i] = getArray(k, length);
                i++;
            }
        }
        return result;
    }

    public int[] getArray(int start, int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = start;
            start++;
        }
        return array;
    }
}
