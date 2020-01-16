package leetcode;

import java.util.ArrayList;

/**
 * @author long
 */
public class LeetCode {

    public static void main(String[] args) {
        String str = "babad";

        System.out.println(longestPalindrome(str));
    }

    //Definition for singly-linked list.

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode flag = listNode;
        int k = 0;
        int number1 = 0;
        int number2 = 0;
        while (l1 != null) {
            number1 = l1.val * (10 ^ k) + number1;
            k++;
        }
        k = 0;
        while (l2 != null) {
            number2 = l2.val * (10 ^ k) + number2;
            k++;
        }
        int number = number1 + number2;
        while (number > 9) {
            listNode = new ListNode(number % 10);
            number = number / 10;
            listNode = listNode.next;
        }
        return flag.next;
    }

    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i)) == false) {
                list.add(s.charAt(i));
                length = Math.max(length, list.size());
            } else {
                length = Math.max(length, list.size());
                int index = list.indexOf(s.charAt(i));
                for (int j = 0; j <= index; j++) {
                    list.remove(0);
                }
                list.add(s.charAt(i));
            }
        }
        return length;
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
/*            if(m == 0){
                if(n%2 == 0){
                    return (nums2[n/2]+nums2[n/2+1])/2.0;
                }
                else if(n%2 == 1){
                    return nums2[n/2+1]/1.0;
                }
            }
            if(n == 0){
                if(m%2 == 0){
                    return (nums1[m/2]+nums1[m/2+1])/2.0;
                }
                else if(m%2 == 1){
                    return nums1[m/2+1]/1.0;
                }
            }*/
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int k = m;
            m = n;
            n = k;
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


    public static double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }
        int subLeft = 0;
        int subRight = 0;
        for (int i = 0; i <= 2 * length; i++) {
            int left = i % 2 == 0 ? i - 1 : i;
            int right = i % 2 == 0 ? i + 1 : i;
            while (left >= 0 && right <= 2 * length && s.charAt(left / 2) == s.charAt(right / 2)) {
                if ((right - left) > (subRight - subLeft)) {
                    subLeft = left;
                    subRight = right;
                }
                left = left - 2;
                right = right + 2;
            }
        }
        return s.substring(subLeft / 2, subRight / 2 + 1);
    }

}

