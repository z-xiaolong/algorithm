package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author long
 * @Date 2021/10/28 9:44
 * @Title
 * @Description //TODO
 **/

public class ReorderedPowerOf2 {


    public boolean reorderedPowerOf2(int n) {
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= 1e9; i <<= 1) {
            set.add(countDigits(i));
        }
        return set.contains(countDigits(n));
    }

    public String countDigits(int n) {
        char[] chars = new char[10];
        while (n > 0) {
            chars[n % 10]++;
            n = n / 10;
        }
        return new String(chars);
    }


    public boolean dfs(int[] bits, boolean[] flag, int cnt, int num) {
        if (cnt == bits.length) {
            return valid(num);
        }
        for (int i = 0; i < flag.length; i++) {
            if (!flag[i]) {
                if (cnt == 0 && bits[i] == 0) continue;
                flag[i] = true;
                boolean ans = dfs(bits, flag, cnt + 1, num * 10 + bits[i]);
                if (ans) return true;
                flag[i] = false;
            }
        }
        return false;
    }

    public boolean valid(int n) {
        if (n == 0) return false;
        while ((n & 1) == 0) {
            n >>= 1;
        }
        return n == 1;
    }

    public int[] bits(int n, int len) {
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = n % 10;
            n /= 10;
        }
        return ans;
    }

    public int len(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n / 10;
        }
        return count;
    }
}
