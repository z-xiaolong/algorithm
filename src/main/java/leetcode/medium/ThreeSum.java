package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 21:02 2019/11/2
 * @Title 15. 三数之和
 * @Description 给定一个包含n个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 **/

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, 6, -8, 3, -1, -4, -1, -9, 9, -1, 4, -3, 0, 1};
        //Arrays.sort(nums);
        ThreeSum threeSum = new ThreeSum();
        threeSum.sortByAbs(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }

    }

    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        sortByAbs(nums);
        int head = 0;
        if (nums[head] == 0) {
            while (nums[head] == 0) {
                head++;
            }
            for (int i = head; i < nums.length - 1; i++) {
                if (nums[i] + nums[i + 1] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(0);
                    list.add(nums[i]);
                    list.add(nums[i + 1]);
                    lists.add(list);
                }
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            findNumbers(nums, head, i - 1, nums[i]);
        }
        return lists;
    }

    public void findNumbers(int[] nums, int head, int tail, int number) {
        if (head > tail - 1) {
            return;
        }
        while (head < tail - 1) {
            while (head < tail - 1 && Math.abs(nums[head]) + Math.abs(nums[tail]) > Math.abs(number)) {
                tail--;
            }
            if (nums[head] + nums[tail] == -number) {
                List<Integer> list = new ArrayList<>();
                list.add(number);
                list.add(nums[head]);
                list.add(nums[tail]);
                lists.add(list);
                while (head < tail - 1 && nums[head] == nums[head + 1]) {
                    head++;
                }
                while (head < tail - 1 && nums[tail] == nums[tail - 1]) {
                    tail--;
                }
            }
            if (head < tail - 1 && (nums[head] > 0 && number > 0) || (nums[head] < 0 && number < 0)) {
                head++;
            } else {
                tail--;
            }
            while (head < tail - 1 && Math.abs(nums[head]) + Math.abs(nums[tail]) < Math.abs(number)) {
                head++;
            }
        }
    }


    public void sortByAbs(int[] nums) {
        quickSortAbs(nums, 0, nums.length - 1);
    }

    //按绝对值快速排序
    public void quickSortAbs(int[] nums, int left, int right) {
        if (left < right) {
            int mid = partition(nums, left, right);
            quickSortAbs(nums, left, mid - 1);
            quickSortAbs(nums, mid + 1, right);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int k = nums[left];
        while (left < right) {
            while (left < right && compareByAbs(nums[right], k)) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && compareByAbs(k, nums[left])) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = k;
        return left;
    }

    public boolean compareByAbs(int x, int y) {
        if (x + y == 0) {
            return x > 0;
        }
        x = (x < 0) ? -x : x;
        y = (y < 0) ? -y : y;
        return x >= y;
    }

    public void test(int[] nums) {
        boolean hasZero = false;
        List<Integer> positiveList = new ArrayList<>();
        List<Integer> negativeList = new ArrayList<>();
        for (int i : nums) {
            if (i > 0) {
                positiveList.add(i);
            } else if (i < 0) {
                negativeList.add(i);
            } else {
                hasZero = true;
            }
        }
        if (hasZero) {

        }
    }
}
