package leetcode.medium;

/**
 * @Author long
 * @Date 2020/3/27 16:57
 * @Title 79. 单词搜索
 * @Description //TODO
 **/

public class Exist {

    //不使用标记
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean res;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = backtrack(i, j, board, word, 0);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(int i, int j, char[][] board, String word, int index) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1 && board[i][j] == word.charAt(index)) {
            return true;
        }
        boolean res = false;
        char c = board[i][j];
        board[i][j] = '.';
        if (i - 1 >= 0 && board[i - 1][j] != '.') {
            res = backtrack(i - 1, j, board, word, index + 1);
        }
        if (i + 1 < board.length && board[i + 1][j] != '.') {
            res = res || backtrack(i + 1, j, board, word, index + 1);
        }
        if (j - 1 >= 0 && board[i][j - 1] != '.') {
            res = res || backtrack(i, j - 1, board, word, index + 1);
        }
        if (j + 1 < board[0].length && board[i][j + 1] != '.') {
            res = res || backtrack(i, j + 1, board, word, index + 1);
        }
        board[i][j] = c;
        return res;
    }
}
