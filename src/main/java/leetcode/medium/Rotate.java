package leetcode.medium;

/**
 * @Author long
 * @Date 2020/2/22 18:56
 * @Title 48. 旋转图像
 * @Description 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。
 * 请不要使用另一个矩阵来旋转图像。
 **/

public class Rotate {

    //水平翻转+主对角线翻转
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //水平翻转
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = temp;
        }
        //主对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(matrix, i, j);
            }
        }
    }

    public void swap(int[][] matrix, int i, int j) {
        if (i == j) return;
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
