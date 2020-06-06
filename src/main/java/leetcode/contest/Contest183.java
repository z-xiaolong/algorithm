package leetcode.contest;

import java.util.*;

/**
 * @Author long
 * @Date 2020/4/5 10:21
 * @Title
 * @Description //TODO
 **/

public class Contest183 {

    //5376. 非递增顺序的最小子序列
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int sub = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (sub <= sum - sub) {
                sub += nums[i];
                ans.add(nums[i]);
            } else {
                break;
            }
        }
        return ans;
    }


    //5377. 将二进制表示减到 1 的步骤数
    public int numSteps(String s) {
        char[] bits = s.toCharArray();
        int index = s.length() - 1;
        int count = 0;
        char carry = '0';
        if (index == 0) return 0;
        while (index > 0) {
            if (bits[index] == '0' && carry == '0') {
                index--;
                count++;
            } else if (bits[index] == '1' && carry == '0') {
                carry = '1';
                count += 2;
                index--;
            } else if (bits[index] == '0' && carry == '1') {
                index--;
                count += 2;
            } else if (bits[index] == '1' && carry == '1') {
                index--;
                count++;
            }
        }
        if (carry == '1') count++;
        return count;
    }

    //5195. 最长快乐字符串

    public String longestDiverseString(int a, int b, int c) {
        if (a == 0 && b == 0 && c == 0) return "";
        int[] nums = new int[]{a, b, c};
        Arrays.sort(nums);
        Map<Integer, Character> hashMap = new HashMap<>();
        hashMap.put(a, 'a');
        hashMap.put(b, 'b');
        hashMap.put(c, 'c');
        StringBuilder builder = new StringBuilder();
        char c1 = hashMap.get(nums[2]);
        if (nums[2] >= 2) {
            builder.append(c1).append(c1);
            if (nums[1] * 2 > nums[2] && nums[1] >= 2) {
                builder.append(hashMap.get(nums[1])).append(hashMap.get(nums[1]));
                if(nums[0] * 2 > nums[1] && nums[0]>= 2){

                }
            } else if (nums[1] > 0) {
                builder.append(hashMap.get(nums[1]));
            }
        } else {
            builder.append(c1);
            if (nums[1] > 0) builder.append(hashMap.get(nums[1]));
            if (nums[0] > 0) builder.append(hashMap.get(nums[0]));
        }
        return builder.toString();
    }

    public void append(StringBuilder builder, int count, char c) {
        while (count > 0) {
            builder.append(c);
            count--;
        }
    }

    public static void main(String[] args) {
        Contest183 contest183 = new Contest183();
        System.out.println(contest183.numSteps("10"));
    }
}
