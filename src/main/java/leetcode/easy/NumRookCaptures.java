package leetcode.easy;

/**
 * @Author long
 * @Date 2020/3/26 10:06
 * @Title 999. 车的可用捕获量
 * @Description //TODO
 **/

public class NumRookCaptures {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', 'R', '.', '.', '.', 'p'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}};
        numRookCaptures(board);
    }

    public static int numRookCaptures(char[][] board) {
        int n = board.length;
        int count = 0;
        int i = 0;
        int j = 0;
        outerLoop:
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    break outerLoop;
                }
            }
        }
        int up = i - 1;
        int down = i + 1;
        int left = j - 1;
        int right = j + 1;
        while (up >= 0) {
            if (board[up][j] == 'p') {
                count++;
                break;
            } else if (board[up][j] == 'B') {
                break;
            } else if (board[up][j] == '.') {
                up--;
            }
        }
        while (down < n) {
            if (board[down][j] == 'p') {
                count++;
                break;
            } else if (board[down][j] == 'B') {
                break;
            } else if (board[down][j] == '.') {
                down++;
            }
        }
        while (left >= 0) {
            if (board[i][left] == 'p') {
                count++;
                break;
            } else if (board[i][left] == 'B') {
                break;
            } else if (board[i][left] == '.') {
                left--;
            }
        }
        while (right < n) {
            if (board[i][right] == 'p') {
                count++;
                break;
            } else if (board[i][right] == 'B') {
                break;
            } else if (board[i][right] == '.') {
                right++;
            }
        }
        return count;
    }
}
