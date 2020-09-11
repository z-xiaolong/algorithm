package exam;

/**
 * @Author: long
 * @Date: 2020/8/1 15:43
 * @Title
 * @Description:
 */
public class Solution {

    private int count = 0;
    public int reletive_7(int[] digit) {
        int n = digit.length;
        boolean[] flag = new boolean[n];
        int[] num = new int[n];
        dfs(digit, flag, num, 0);
        return count;
    }
    public void dfs(int[] digit, boolean[] flag, int[] num, int index) {
        if (index == num.length) {
            if (isReletive(num)) count++;
            return;
        }
        for (int i = 0; i < digit.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                num[index] = digit[i];
                dfs(digit, flag, num, index + 1);
                flag[i] = false;
            }
        }
    }
    public boolean isReletive(int[] num) {
        int temp = 0;
        for (int i : num) {
            temp = temp * 10 + i;
        }
        return temp % 7 == 0;
    }
}
