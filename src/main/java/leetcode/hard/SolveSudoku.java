package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 2021/9/17 11:54
 * @Title
 * @Description //TODO
 **/

public class SolveSudoku {
    private final int[] col = new int[9];
    private final int[] row = new int[9];
    private final int[][] block = new int[3][3];
    private boolean valid = false;
    private final List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '1';
                    flip(i, j, digit);
                }
            }
        }
        while (true) {
            boolean flag = false;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        int mask = ~(col[i] | row[j] | block[i / 3][j / 3]) & 0x1ff;
                        if ((mask & (mask - 1)) == 0) {
                            int digit = Integer.bitCount(mask - 1);
                            flip(i, j, digit);
                            board[i][i] = (char) (digit + '1');
                            flag = true;
                        }
                    }
                }
            }
            if (!flag) break;
        }
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                }
            }
        }
        dfs(board, 0);
    }


    public void dfs(char[][] board, int index) {
        if (index == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(index);
        int i = space[0];
        int j = space[1];
        int mask = ~(col[i] | row[j] | block[i / 3][j / 3]) & 0x1ff;
        for (; mask != 0 && !valid; mask &= mask - 1) {
            int digitMask = mask & (-mask); //正数的 (原码 & 补码) = 最后一位 1
            int digit = Integer.bitCount(digitMask - 1); // bit位为1的个数
            flip(i, j, digit);
            board[i][j] = (char) (digit + '1');
            dfs(board, index + 1);
            flip(i, j, digit); //复位，还原
        }
    }

    public void flip(int i, int j, int digit) {
        col[i] ^= 1 << digit;
        row[j] ^= 1 << digit;
        block[i / 3][j / 3] ^= 1 << digit;
    }
}
