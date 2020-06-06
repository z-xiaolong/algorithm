package leetcode.hard;

/**
 * @Author long
 * @Date 2020/5/24 9:09
 * @Title 4. 寻找两个正序数组的中位数
 * @Description //TODO
 **/

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int median = (length1 + length2) >> 1;
        int left1 = 0;
        int left2 = 0;
        int right1 = length1 - 1;
        int right2 = length2 - 1;
        while (left1 < right1 || left2 < right2) {
            int mid1 = (left1 + right1) >> 1;
            int mid2 = (left2 + right2) >> 1;
            if (nums1[mid1] > nums2[mid2]) {
                if (mid1 + mid2 + 2 < median) {
                    left2 = mid2 + 1;
                } else if (mid1 + mid2 + 2 > median) {
                    right1 = mid1 - 1;
                } else {
                    right1 = mid1;
                    left2 = mid2;
                }
            } else if (nums1[mid1] < nums2[mid2]) {
                if (mid1 + mid2 + 2 < median) {
                    left1 = mid1 + 1;
                } else if (mid1 + mid2 + 2 > median) {
                    right2 = mid2 - 1;
                } else {
                    left1 = mid1;
                    right2 = mid2;
                }
            } else {
                if (mid1 + mid2 + 2 < median) {
                    left1 = mid1 + 1;
                    left2 = mid2;
                } else if (mid1 + mid2 + 2 > median) {
                    right1 = mid1 - 1;
                    right2 = mid2;
                } else {
                    return nums1[mid1];
                }
            }
        }
        int mid1 = (left1 + right1) >> 1;
        int mid2 = (left2 + right2) >> 1;
        return (double) (nums1[mid1] + nums2[mid2]) / 1;
    }

    public double findMedianSortedArraysI(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2] + nums2[n / 2 - 1]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2] + nums1[m / 2 - 1]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            m = m + n;
            n = m - n;
            m = m - n;
        }
        int iMin = 0;
        int iMax = m;
        int halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
