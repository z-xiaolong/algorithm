package leetcode.medium;

/**
 * @Author long
 * @Date 2021/3/31 11:12
 * @Title
 * @Description //TODO
 **/

public class MinHeightShelves {

    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        int[] dp = new int[n + 1];
        dp[1] = books[0][1];
        for (int i = 1; i < n; i++) {
            int width = 0;
            dp[i + 1] += dp[i] + books[i][1];
            int height = books[i][1];
            int j = i;
            while (j >= 0 && width + books[j][0] <= shelf_width) {
                height = Math.max(books[j][1], height);
                dp[i + 1] = Math.min(dp[j] + height, dp[i + 1]);
                width += books[j][0];
                j--;
            }
        }
        return dp[n];
    }
}
