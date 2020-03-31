package leetcode.hard;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/3/30 16:36
 * @Title 315. 计算右侧小于当前元素的个数
 * @Description //TODO
 **/

public class CountSmaller {

    int[] temp;
    private int[] counter;
    private int[] indexes;

    //归并排序 + 索引数组
    public List<Integer> countSmaller(int[] nums) {
        temp = new int[nums.length];
        counter = new int[nums.length];
        indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
        }
        return null;
    }

    public int mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            temp[left] = nums[left];
            return 0;
        }
        int mid = (left + right) / 2;
        int leftNum = mergeSort(nums, left, mid);
        int rightNum = mergeSort(nums, mid + 1, right);
        int mergeNum = merge(nums, left, right);
        return leftNum + rightNum + mergeNum;
    }

    public int merge(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = (left + right) / 2;
        for (int i = mid + 1; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = mid;
        int j = right;
        int k = right;
        while (i >= left && j >= left) {
            if (nums[i] > temp[j]) {
                nums[k--] = nums[i--];
            } else {
                nums[k--] = temp[j--];
            }
        }
        while (i >= left) {
            nums[k--] = nums[i--];
        }
        while (j >= left) {
            nums[k--] = nums[j--];
        }

        return 0;
    }
}
