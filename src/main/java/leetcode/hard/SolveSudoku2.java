package leetcode.hard;

import java.util.*;

/**
 * @Author long
 * @Date 2021/9/17 14:50
 * @Title
 * @Description //TODO
 **/

public class SolveSudoku2 {
    private Set<Integer>[] col = new Set[9];
    private Set<Integer>[] row = new Set[9];
    private Set<Integer>[][] block = new Set[3][3];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            col[i] = new HashSet<>();
            row[i] = new HashSet<>();
            block[i / 3][i % 3] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '1';
                    flip(i, j, digit);
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
        for (int k = 0; k < 9 && !valid; k++) {
            if (!col[i].contains(k) && !row[j].contains(k)
                    && !block[i / 3][j / 3].contains(k)) {
                flip(i, j, k);
                board[i][j] = (char) (k + '1');
                dfs(board, index + 1);
                remove(i, j, k);
            }
        }
    }

    public void remove(int i, int j, int digit) {
        col[i].remove(digit);
        row[j].remove(digit);
        block[i / 3][j / 3].remove(digit);
    }

    public void flip(int i, int j, int digit) {
        col[i].add(digit);
        row[j].add(digit);
        block[i / 3][j / 3].add(digit);
    }
}
