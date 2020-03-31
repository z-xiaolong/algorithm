package leetcode.easy;

/**
 * @Author long
 * @Date 2020/3/11 11:52
 * @Title 1013. 将数组分成和相等的三个部分
 * @Description //TODO
 **/

public class CanThreePartsEqualSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, 1, -1};
        canThreePartsEqualSum(nums);
    }

    //优化内存 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
    public static boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int value : A) {
            sum += value;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int subSum = 0;
        int temp = sum / 3;
        int count = 0;
        for (int value : A) {
            subSum += value;
            if (subSum == temp) {
                subSum = 0;
                count++;
            }
        }
        return count >= 3;
    }

    //执行用时 :2 ms, 在所有 Java 提交中击败了86.81%的用户
    public static boolean canThreePartsEqualSumI(int[] A) {
        int[] sums = new int[A.length];
        sums[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sums[i] = sums[i - 1] + A[i];
        }
        int lastSum = sums[A.length - 1];
        if (lastSum % 3 != 0) {
            return false;
        }
        int temp = lastSum / 3;
        int count = 0;
        for (int i = 0; i < sums.length - 1; i++) {
            if (sums[i] == temp) {
                temp += temp;
                count++;
            }
        }
        return count >= 2;
    }
}
