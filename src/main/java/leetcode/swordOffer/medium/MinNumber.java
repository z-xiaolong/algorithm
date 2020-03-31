package leetcode.swordOffer.medium;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author long
 * @Date 2020/3/24 11:41
 * @Title 面试题45. 把数组排成最小的数
 * @Description //TODO
 **/

public class MinNumber {

    public static void main(String[] args) {
        String s = "b";
        System.out.println(s.compareTo("b"));
    }


    //官方最佳解
    public String minNumber(int[] nums) {
        List<String> strList = new ArrayList<>();
        for (int num : nums) {
            strList.add(String.valueOf(num));
        }
        strList.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String str : strList) {
            sb.append(str);
        }
        return sb.toString();
    }

    //执行用时 :17 ms, 在所有 Java 提交中击败了13.06%的用户
    public String minNumberII(int[] nums) {
        sort(nums, 0, nums.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    public void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = mid(nums, left, right);
        sort(nums, left, mid - 1);
        sort(nums, mid + 1, right);
    }

    public int mid(int[] nums, int left, int right) {
        if (left >= right) {
            return left;
        }
        int k = nums[left];
        while (left < right) {
            while (left < right && compare(nums[right], k) >= 0) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && compare(nums[left], k) <= 0) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = k;
        return left;
    }

    public int compare(int num1, int num2) {
        String s1 = num1 + String.valueOf(num2);
        String s2 = num2 + String.valueOf(num1);
        int length = s1.length();
        int i = 0;
        int j = 0;
        if (num1 != num2) {
            while (i < length && j < length && s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            }
            if (i < length && j < length && s1.charAt(i) > s2.charAt(j)) {
                return 1;
            } else if (i < length && j < length && s1.charAt(i) < s2.charAt(j)) {
                return -1;
            }
        }
        return 0;
    }


    //题意理解错误
    public String minNumberI(int[] nums) {
        int[] bit = new int[10];
        for (int num : nums) {
            while (num != 0) {
                bit[num % 10]++;
                num = num / 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int index = 1;
        while (bit[index] == 0) {
            index++;
        }
        for (int i = 0; i < bit[index]; i++) {
            stringBuilder.append(index);
        }
        for (int i = 0; i < bit[0]; i++) {
            stringBuilder.append(0);
        }
        index++;
        while (index < bit.length) {
            for (int i = 0; i < bit[index]; i++) {
                stringBuilder.append(index);
            }
            index++;
        }
        return stringBuilder.toString();
    }

    public void setBit(int[] bit, int num) {
        while (num != 0) {
            bit[num % 10]++;
            num = num / 10;
        }
    }
}
