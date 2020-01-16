package leetcode.medium;

/**
 * @Author long
 * @Date 2019/12/25 19:43
 * @Title 338. 比特位计数
 * @Description 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，
 * 计算其二进制数中的 1 的数目并将它们作为数组返回。
 **/

public class CountBits {

    public static void main(String[] args) {
        System.out.println(4 % 2);
    }

    public int[] countBits(int num) {
        int[] array = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            array[i] = sizeof(i);
        }

        return array;
    }

    public int sizeof(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 2;
            num = num / 2;
        }
        return sum;
    }

    static class Solution1 {
        public static void main(String[] args) {
            int[] a = countBits(2);
            for (int i : a) {
                System.out.print(i + " ");
            }
        }

        public static int[] countBits(int num) {
            if (num == 0) {
                return new int[]{0};
            }
            if (num == 1) {
                return new int[]{0, 1};
            }
            int k = 2;
            int[] array = new int[num + 1];
            array[0] = 0;
            array[1] = 1;
            for (int i = 2; i <= num; i++) {
                array[i] = array[i % k] + 1;
                if (i == 2 * k - 1) {
                    k = 2 * k;
                }
            }
            return array;
        }
    }

    public static class Solution2 {
        public int[] countBits(int num) {
            int[] ans = new int[num + 1];
            for (int i = 1; i <= num; ++i) {
                ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
            }
            return ans;
        }
    }

    public static class Solution3 {
        public int[] countBits(int num) {
            int[] ans = new int[num + 1];
            for (int i = 1; i <= num; ++i) {
                ans[i] = ans[i & (i - 1)] + 1;
            }
            return ans;
        }
    }
}
