package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/3/1 14:44
 * @Title 51. N皇后
 * @Description //TODO
 **/

public class SolveNQueens {
    public static void main(String[] args) {
        SolveNQueens queens = new SolveNQueens();
        queens.solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new LinkedList<>();
        int[][] chessboard = new int[n][n];
        List<String> strings = new ArrayList<>(n);
        backtrack(output, strings, chessboard, 0, n);
        return output;
    }

    public void backtrack(List<List<String>> output, List<String> strings, int[][] chessboard, int index, int n) {
        if (index >= n) {
            output.add(new LinkedList<>(strings));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (chessboard[index][j] == 0) {
                setStatus(chessboard, index, j, n, 1);
                strings.add(index, getString(j, n));
                backtrack(output, strings, chessboard, index + 1, n);
                setStatus(chessboard, index, j, n, -1);
                strings.remove(index);
            }
        }
    }

    public String getString(int j, int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        chars[j] = 'Q';
        return new String(chars);
    }

    public boolean check(int[][] chessboard, int i, int j, int n) {
        for (int k = 0; k < n; k++) {
            if (chessboard[i][k] == 1) {
                return false;
            }
        }
        for (int k = 0; k < n; k++) {
            if (chessboard[k][j] == 1) {
                return false;
            }
        }
        for (int m = i, k = j; k < n && m < n; k++, m++) {
            if (chessboard[m][k] == 1) {
                return false;
            }
        }
        for (int m = i, k = j; k >= 0 && m >= 0; k--, m--) {
            if (chessboard[m][k] == 1) {
                return false;
            }
        }
        for (int m = i, k = j; k >= 0 && m < n; k--, m++) {
            if (chessboard[m][k] == 1) {
                return false;
            }
        }
        for (int m = i, k = j; k < n && m >= 0; k++, m--) {
            if (chessboard[m][k] == 1) {
                return false;
            }
        }
        return true;
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
