package leetcode.contest;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/2/23 17:17
 * @Title
 * @Description //TODO
 **/

public class Contest176 {


    /**
     * create by long on 2020/2/24
     *
     * @description 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，
     * 都以非递增顺序排列。请你统计并返回 grid 中 负数 的数目。
     */
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) {
                    sum += n - j;
                    break;
                }
            }
        }
        return sum;
    }


    /**
     * create by long on 2020/2/24
     *
     * @description 请你实现一个「数字乘积类」ProductOfNumbers，要求支持下述两种方法：
     * 1. add(int num)
     * 将数字 num 添加到当前数字列表的最后面。
     * 2. getProduct(int k)
     * 返回当前数字列表中，最后 k 个数字的乘积。
     * 你可以假设当前列表中始终 至少 包含 k 个数字。
     * 题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。
     */
    class ProductOfNumbers {

        private List<Integer> nums;
        private List<Integer> product;
        private int size = 0;
        private int index = -1;

        public ProductOfNumbers() {
            nums = new LinkedList<>();
            product = new LinkedList<>();
        }

        public void add(int num) {
            nums.add(num);
            size++;
            if (num == 0) {
                index = size - 1;
                product.clear();
            } else {
                setProduct(num);
            }
        }

        public void setProduct(int num) {
            product.add(1);
            if (num == 1) {
                return;
            }
            for (int i = 0; i < product.size(); i++) {
                int temp = product.get(i);
                product.set(i, temp * num);
            }
        }

        public int getProduct(int k) {
            if (size - k <= index) {
                return 0;
            }
            return product.get(product.size() - k);
        }
    }

    /**
     * create by long on 2020/2/24
     *
     * @description 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，
     * 表示会议 i 开始于 startDayi ，结束于 endDayi 。
     * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。
     * 注意，一天只能参加一个会议。请你返回你可以参加的 最大 会议数目。
     */
    public int maxEvents(int[][] events) {


        return 0;
    }


    /**
     * create by long on 2020/2/24
     *
     * @description 给你一个整数数组 target 。一开始，你有一个数组 A ，
     * 它的所有元素均为 1 ，你可以执行以下操作：
     * 令 x 为你数组里所有元素的和
     * 选择满足 0 <= i < target.size 的任意下标 i ，并让 A 数组里下标为 i 处的值为 x 。
     * 你可以重复该过程任意次
     * 如果能从 A 开始构造出目标数组 target ，请你返回 True ，否则返回 False 。
     */
    public boolean isPossible1(int[] target) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < target.length; i++) {
            sum += target[i];
            if (target[i] > target[max]) {
                max = i;
            }
        }
        target[max] = 2 * target[max] - sum;
        if (target[max] < 1) {
            return false;
        }
        return check(target) || isPossible1(target);
    }


    public static void main(String[] args) {
        int[] target = new int[]{1, 1, 1, 2};
        Contest176 contest176 = new Contest176();
        contest176.isPossible(target);
    }

    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }
        quickSort(target, 0, target.length - 1);
        long sum = 0;
        long max;
        for (int num : target) {
            sum += num;
        }
        while (target[0] > 1) {
            max = target[0];
            if (max <= sum - max) {
                return false;
            }
            target[0] = (int) (max % (sum - max));
            if (target[0] == 0 && (sum - max) != 1) {
                return false;
            }
            sum = sum - max + target[0];
            minHeapify(target, 0, target.length - 1);
        }
        return target[0] == 1;
    }


    public void quickSort(int[] target, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = binary(target, left, right);
        quickSort(target, left, mid - 1);
        quickSort(target, mid + 1, right);
    }

    public int binary(int[] target, int left, int right) {
        int k = target[left];
        while (left < right) {
            while (right > left && target[right] <= k) {
                right--;
            }
            target[left] = target[right];
            while (left < right && target[left] >= k) {
                left++;
            }
            target[right] = target[left];
        }
        target[left] = k;
        return left;
    }


    public void minHeapify(int[] array, int index, int size) {
        int largest;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left <= size && array[left] > array[index]) {
            largest = left;
        } else {
            largest = index;
        }
        if (right <= size && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != index) {
            array[largest] = array[largest] + array[index];
            array[index] = array[largest] - array[index];
            array[largest] = array[largest] - array[index];
            minHeapify(array, largest, size);
        }
    }

    public boolean check(int[] target) {
        for (int num : target) {
            if (num != 1) {
                return false;
            }
        }
        return true;
    }

}
