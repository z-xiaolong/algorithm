package leetcode.medium.dp;

/**
 * @Author long
 * @Date 2020/3/5 16:59
 * @Title 85. 最大矩形
 * @Description 给定一个仅包含 0 和 1 的二维二进制矩阵，
 * 找出只包含 1 的最大矩形，并返回其面积。
 **/

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        int max = 0;
        Rectangle prv = new Rectangle(0, 0);
        Rectangle[] rectangles = new Rectangle[m + 1];
        for (int i = 1; i <= m; i++) {
            if (matrix[0][i - 1] == '1') rectangles[i] = new Rectangle(1, 1);
            else rectangles[i] = new Rectangle(0, 0);
        }
        rectangles[0] = new Rectangle(0, 0);
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                Rectangle temp = rectangles[j];
                if (matrix[i - 1][j - 1] == '1') {
                    int x = Math.min(rectangles[j].x, prv.x) + 1;
                    int y = Math.min(rectangles[j - 1].y, prv.y) + 1;
                    rectangles[j] = new Rectangle(x, y);
                    max = Math.max(max, x * y);
                } else {
                    rectangles[j] = new Rectangle(0, 0);
                }
                prv = temp;
            }
        }
        return max;
    }

    class Rectangle {
        public int x;
        public int y;

        public Rectangle(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
