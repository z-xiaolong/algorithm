package leetcode.contest;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2021/10/3 10:28
 * @Title
 * @Description //TODO
 **/

public class Contest261 {

    public static void main(String[] args) {
        Contest261 contest261 = new Contest261();
    }

    public boolean stoneGameIX(int[] stones) {
        int n = stones.length;
        if (n == 1) return false;
        int[] cnt = new int[3];
        for (int stone : stones) {
            cnt[stone % 3]++;
        }
        if (cnt[0] % 2 == 0) {
            if (cnt[2] > 0 && cnt[2] - 1 < cnt[1]) return true;
            if (cnt[1] > 0 && cnt[1] - 1 < cnt[2]) return true;
        } else {
            if (cnt[1] > 0 && cnt[1] - 2 > cnt[2]) return true;
            if (cnt[2] > 0 && cnt[2] - 2 > cnt[1]) return true;
        }
        return false;
    }

    private long sub(long stones, int index) {
        int[] cnt = new int[3];
        for (int i = 0; i < 3; i++) {
            cnt[i] = (int) ((stones >> (i * 20)) | 0xfffff);
        }
        if (cnt[index] == 0) return 0;
        cnt[index]--;
        return getStones(cnt);
    }

    private long getStones(int[] cnt) {
        long ans = 0;
        ans |= cnt[0];
        ans |= (long) cnt[1] << 20;
        ans |= (long) cnt[2] << 40;
        return ans;
    }


    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int[] ans = new int[n];
        int remain = (m + n) * mean - Arrays.stream(rolls).sum();
        if (remain > n * 6 || remain < n) return new int[0];
        int mod = remain % n;
        int avg = remain / n;
        for (int i = 0; i < n; i++) {
            ans[i] = avg;
            if (mod > 0) {
                ans[i]++;
                mod--;
            }
        }
        return ans;
    }

    public int minimumMoves(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        int cnt = 0;
        for (char c : chars) {
            if (c == 'X' || cnt != 0) {
                cnt++;
            }
            if (cnt == 3) {
                ans++;
                cnt = 0;
            }
        }
        if (cnt > 0) ans++;
        return ans;
    }
}
