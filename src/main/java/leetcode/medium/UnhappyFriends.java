package leetcode.medium;

/**
 * @Author long
 * @Date 2021/8/28 17:02
 * @Title
 * @Description //TODO
 **/

public class UnhappyFriends {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int ans = 0;
        int[] map = new int[n];
        for (int[] pair : pairs) {
            map[pair[0]] = pair[1];
            map[pair[1]] = pair[0];
        }

        for (int[] pair : pairs) {
            if (isUnhappy(pair[0], pair[1], preferences, map)) {
                ans++;
            }
            if (isUnhappy(pair[1], pair[0], preferences, map)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean isUnhappy(int i, int j, int[][] preferences, int[] map) {
        int n = preferences.length;
        for (int k = 0; k < n - 1; k++) {
            if (preferences[i][k] != j) {
                int friend = preferences[i][k];
                int other = map[friend];
                for (int l = 0; l < n - 1; l++) {
                    if (preferences[friend][l] == i) {
                        return true;
                    } else if (preferences[friend][l] == other) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return false;
    }
}
