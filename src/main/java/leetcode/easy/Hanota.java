package leetcode.easy;

import java.util.List;

/**
 * @Author long
 * @Date 2020/7/21 10:43
 * @Title
 * @Description //TODO
 **/

public class Hanota {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(n, A, B, C);
    }

    public void move(int size, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (size == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        move(size - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        move(size - 1, B, A, C);

    }


    public static void main(String[] args) {
        Hanota hanota = new Hanota();
        hanota.minArray(new int[]{10, 1, 10, 10, 10});
    }

    public int minArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right] || left == right)
            return nums[left];
        while (left <= right) {

            int mid = (left + right) >> 1;
            if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                left++;
                right--;
            } else if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else if (nums[mid] <= nums[right]) {
                right = mid;
            }
            if (nums[left] < nums[right]) return nums[left];
        }
        return nums[left];
    }
}
