package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @author long
 */
public class LeetCode {


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

    //70. 爬楼梯
    public int climbStairs(int n) {
        if (n == 0) return 0;
        int one = 1;
        int two = 1;
        for (int i = 2; i <= n; i++) {
            int temp = two;
            two = two + one;
            one = temp;
        }
        return two;
    }

    //1137. 第 N 个泰波那契数
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int T0 = 0;
        int T1 = 1;
        int T2 = 1;
        for (int i = 3; i <= n; i++) {
            int temp = T2;
            T2 = T0 + T1 + T2;
            T0 = T1;
            T1 = temp;
        }
        return T2;
    }


    public static void backtrack(int i) {
        System.out.println(i);
        try {
            backtrack(i + 1);
        } catch (StackOverflowError error) {
            error.printStackTrace();
        }
    }

    public static int maximum(int a, int b) {
        long sum = (long) a + (long) b;
        long diff = (long) b - (long) a;
        long abs_diff = (diff ^ (diff >> 63)) - (diff >> 63);
        return (int) ((sum + abs_diff) / 2);
    }

    //14. 最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String s1 = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(s1) != 0) {
                s1 = s1.substring(0, s1.length() - 1);
            }
        }
        return s1;
    }

    //面试题 02.07. 链表相交 执行用时 :3 ms, 在所有 Java 提交中击败了18.32%的用户
    public ListNode getIntersectionNodeI(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        ListNode temp = headA;
        while (temp != null) {
            stackA.push(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            stackB.push(temp);
            temp = temp.next;
        }
        ListNode node = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode a = stackA.pop();
            ListNode b = stackB.pop();
            if (a == b) node = a;
            else break;
        }
        return node;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            if (nodeA == null) nodeA = headB;
            else nodeA = nodeA.next;
            if (nodeB == null) nodeB = headA;
            else nodeB = nodeB.next;
        }
        return nodeA;
    }

    public int exchangeBits(int num) {
        return ((num & 0xaaaaaaaa) >> 1) | ((num & 0x55555555) << 1);
    }


    public boolean canPermutePalindrome(String s) {
        int[] hash = new int[128];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }
        int count = 0;
        for (int h : hash) {
            if (h % 2 == 1) count++;
            if (count > 1) return false;
        }
        return true;
    }

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String s = s2 + s2;
        return s.contains(s1);
    }

    public static void main(String[] args) {
        int i = 16;
        System.out.println(Integer.toBinaryString(~i));
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(-17));
    }
}

