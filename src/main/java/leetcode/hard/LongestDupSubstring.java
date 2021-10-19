package leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author long
 * @Date 2021/9/28 11:02
 * @Title
 * @Description //TODO
 **/

public class LongestDupSubstring {

    public static void main(String[] args) {
        LongestDupSubstring longestDupSubstring = new LongestDupSubstring();
        longestDupSubstring.longestDupSubstring("nnpxouomcofdjuujloanjimymadkuepightrfodmauhrsy");

    }

    public String longestDupSubstring(String S) {
        int n = S.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = S.charAt(i) - 'a';
        }
        int base = 26;
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (search(mid, base, n, nums) != -1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int start = search(left - 1, base, n, nums);
        return start == -1 ? "" : S.substring(start, start + left - 1);
    }

    public void dp() {

    }

    public int search(int len, int base, int n, int[] nums) {
        long hash = 0L;
        long hashBase = 1L;
        for (int i = 0; i < len; i++) {
            hash = hash * base + nums[i];
            hashBase = hashBase * base;
        }
        HashSet<Long> seen = new HashSet<>();
        seen.add(hash);
        for (int i = 1; i < n - len + 1; i++) {
            hash = hash * base - nums[i - 1] * hashBase;
            hash = hash + nums[i + len - 1];
            if (seen.contains(hash)) return i;
            seen.add(hash);
        }
        return -1;
    }


    public int valid(String S, int len) {
        int n = S.length();
        Set<String> set = new HashSet<>();
        for (int i = 0; i + len <= n; i++) {
            String sub = S.substring(i, i + len);
            if (set.contains(sub)) return i;
            set.add(sub);
        }
        return -1;
    }

    public int[] hash(int n) {
        int[] ans = new int[n];
        int k = 2;
        for (int i = 0; i < n; i++, k++) {
            while (!isPrime(k)) k++;
            ans[i] = k;
        }
        return ans;
    }

    public boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
