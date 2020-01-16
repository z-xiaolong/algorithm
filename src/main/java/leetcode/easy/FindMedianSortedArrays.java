package leetcode.easy;

/**
 * @Author long
 * @Date 21:52 2019/11/12
 * @Title 寻找两个有序数组的中位数
 * @Description 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 **/

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        int i = 0;
        int j = 0;
        int mid = (nums1.length + nums2.length) / 2;
        while (i + j + 2 < mid) {
            if (i < nums1.length && nums1[i] <= nums2[j]) {
                i++;
            }
            if (j < nums2.length && nums1[i] > nums2[j]) {
                j++;
            }
        }
        //TODO
        return median;
    }

}
