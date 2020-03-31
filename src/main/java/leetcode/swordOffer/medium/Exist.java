package leetcode.swordOffer.medium;

/**
 * @Author long
 * @Date 2020/3/27 16:32
 * @Title 面试题12. 矩阵中的路径
 * @Description //TODO
 **/

public class Exist {


    //执行用时 :5 ms, 在所有 Java 提交中击败了98.68%的用户
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int[][] flag = new int[n][m];
        boolean res;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = backtrack(i, j, board, flag, word, 0);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(int i, int j, char[][] board, int[][] flag, String word, int index) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1 && board[i][j] == word.charAt(index)) {
            return true;
        }
        boolean res = false;
        flag[i][j] = -1;
        if (i - 1 >= 0 && flag[i - 1][j] == 0) {
            res = res || backtrack(i - 1, j, board, flag, word, index + 1);
        }
        if (i + 1 < board.length && flag[i + 1][j] == 0) {
            res = res || backtrack(i + 1, j, board, flag, word, index + 1);
        }
        if (j - 1 >= 0 && flag[i][j - 1] == 0) {
            res = res || backtrack(i, j - 1, board, flag, word, index + 1);
        }
        if (j + 1 < board[0].length && flag[i][j + 1] == 0) {
            res = res || backtrack(i, j + 1, board, flag, word, index + 1);
        }
        flag[i][j] = 0;
        return res;
    }
}
