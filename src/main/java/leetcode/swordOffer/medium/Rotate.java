package leetcode.swordOffer.medium;

/**
 * @Author long
 * @Date 2020/4/7 9:32
 * @Title 面试题 01.07. 旋转矩阵
 * @Description //TODO
 **/

public class Rotate {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Rotate rotate = new Rotate();
        rotate.rotate(matrix);
    }

    //执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            rotateLayer(matrix, i);
        }
    }

    public void rotateLayer(int[][] matrix, int i) {
        int n = matrix.length - 1 - i * 2;
        for (int k = 0; k < n; k++) {
            rotate(matrix, i, i + k, k, n - k);
        }
    }

    public void rotate(int[][] matrix, int i, int j, int m, int n) {
        int[] x = new int[]{m, n, -m, -n};
        int[] y = new int[]{n, -m, -n, m};
        int prev = matrix[i][j];
        for (int k = 0; k < 4; k++) {
            i += x[k];
            j += y[k];
            int temp = matrix[i][j];
            matrix[i][j] = prev;
            prev = temp;
        }
    }
}
