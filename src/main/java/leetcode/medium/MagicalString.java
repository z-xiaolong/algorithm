package leetcode.medium;

/**
 * @Author long
 * @Date 2021/11/18 15:29
 * @Title
 * @Description //TODO
 **/

public class MagicalString {

    public static void main(String[] args) {
        MagicalString magicalString = new MagicalString();
        magicalString.magicalString(6);
    }

    static int[] arr = new int[100010];

    static {
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 2;
        int left = 2;
        int right = 3;
        while (right <= 100000) {
            for (int i = 0; i < arr[left]; i++) {
                if (arr[right - 1] == 2) {
                    arr[right + i] = 1;
                } else {
                    arr[right + i] = 2;
                }
            }
            right += arr[left];
            left++;
        }
    }

    public int magicalString(int n) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) cnt++;
        }
        return cnt;
    }
}
