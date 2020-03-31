package leetcode.hard;

/**
 * @Author long
 * @Date 2020/3/1 16:11
 * @Title 52. N皇后 II
 * @Description //TODO
 **/

public class SolveNQueensII {

    public int totalNQueens(int n) {
        int[][] chessboard = new int[n][n];
        return backtrack(chessboard, 0, n);
    }

    public int backtrack(int[][] chessboard, int index, int n) {
        if (index >= n) {
            return 1;
        }
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (chessboard[index][j] == 0) {
                setStatus(chessboard, index, j, n, 1);
                count += backtrack(chessboard, index + 1, n);
                setStatus(chessboard, index, j, n, -1);
            }
        }
        return count;
    }


    public void setStatus(int[][] chessboard, int i, int j, int n, int status) {
        for (int k = 0; k < n; k++) {
            chessboard[i][k] += status;
            chessboard[k][j] += status;
        }
        for (int m = i, k = j; k < n && m < n; k++, m++) {
            chessboard[m][k] += status;
        }
        for (int m = i, k = j; k >= 0 && m >= 0; k--, m--) {
            chessboard[m][k] += status;
        }
        for (int m = i, k = j; k >= 0 && m < n; k--, m++) {
            chessboard[m][k] += status;
        }
        for (int m = i, k = j; k < n && m >= 0; k++, m--) {
            chessboard[m][k] += status;
        }
    }
}
