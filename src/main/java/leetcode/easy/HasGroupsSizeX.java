package leetcode.easy;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/3/27 9:47
 * @Title 914. 卡牌分组
 * @Description //TODO
 **/

public class HasGroupsSizeX {

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        HasGroupsSizeX hasGroupsSizeX = new HasGroupsSizeX();
        hasGroupsSizeX.hasGroupsSizeX(nums);
        //System.out.println(gcd(4, 6));
    }

    //执行用时 :3 ms, 在所有 Java 提交中击败了84.46%的用户
    public boolean hasGroupsSizeX(int[] deck) {
        Arrays.sort(deck);
        int prev = 1;
        int current = 0;
        int gcd = 1;
        while (prev < deck.length && deck[prev] == deck[prev - 1]) {
            prev++;
        }
        for (int i = prev + 1; i < deck.length; i++) {
            if (deck[i] == deck[i - 1]) {
                current++;
            } else {
                gcd = gcd(current + 1, prev);
                if (gcd < 2) {
                    return false;
                }
                prev = gcd;
                current = 0;
            }
        }
        if (current == 0 && prev >= 2) {
            return true;
        }
        gcd = gcd(current + 1, prev);
        return gcd >= 2;
    }

    public static int gcd(int a, int b) {
        while (a % b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return b;
    }
}
