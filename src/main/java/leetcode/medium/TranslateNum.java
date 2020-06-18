package leetcode.medium;

/**
 * @Author long
 * @Date 2020/6/9 11:05
 * @Title 面试题46. 把数字翻译成字符串
 * @Description //TODO
 **/

public class TranslateNum {

    public static void main(String[] args) {
        TranslateNum num = new TranslateNum();
        num.translateNum(12258);
    }

    public int translateNum(int num) {
        String strNum = String.valueOf(num);
        int length = strNum.length();
        if (length == 1) return 1;
        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= length; i++) {
            if (isSatisfy(strNum, i)) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[length];
    }

    public boolean isSatisfy(String str, int i) {
        int num = Integer.parseInt(str.substring(i - 2, i));
        return num >= 10 && num <= 25;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String num = String.valueOf(x);
        int left = 0;
        int right = num.length() - 1;
        while (left < right) {
            if (num.charAt(left) == num.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) return 0;
        int length = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                length++;
            } else {
                max = Math.max(max, length);
                length = 1;
            }
        }
        max = Math.max(max, length);
        return max;
    }


}
