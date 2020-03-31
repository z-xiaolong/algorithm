package leetcode.swordOffer.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/3/11 17:06
 * @Title 面试题29. 顺时针打印矩阵
 * @Description 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 **/

public class SpiralOrder {


    public static void main(String[] args) {
        SpiralOrder order = new SpiralOrder();
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        order.spiralOrder(matrix);
    }

    //执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public int[] spiralOrderI(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return new int[0];
        }
        int column = matrix[0].length;
        int[] output = new int[row * column];
        ring(matrix, output, 0, 0);
        return output;
    }

    public void ring(int[][] matrix, int[] output, int index, int layer) {
        if (index >= output.length) {
            return;
        }
        int length = matrix.length;
        int row = matrix[0].length;
        int i = layer;
        int j;
        for (j = i; j < row - layer && index < output.length; j++) {
            output[index] = matrix[i][j];
            index++;
        }
        j--;
        for (i = i + 1; i < length - layer && index < output.length; i++) {
            output[index] = matrix[i][j];
            index++;
        }
        i--;
        for (j = j - 1; j >= layer && index < output.length; j--) {
            output[index] = matrix[i][j];
            index++;
        }
        j++;
        for (i = i - 1; i > layer && index < output.length; i--) {
            output[index] = matrix[i][j];
            index++;
        }
        ring(matrix, output, index, layer + 1);
    }

    //执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return new ArrayList<>();
        }
        int column = matrix[0].length;
        int size = row * column;
        ArrayList<Integer> output = new ArrayList<>(size);
        circle(matrix, output, size, 0, 0);
        return output;
    }

    public void circle(int[][] matrix, ArrayList<Integer> output, int size, int index, int layer) {
        if (index >= size) {
            return;
        }
        int length = matrix.length;
        int row = matrix[0].length;
        int i = layer;
        int j;
        for (j = i; j < row - layer && index < size; j++) {
            output.add(matrix[i][j]);
            index++;
        }
        j--;
        for (i = i + 1; i < length - layer && index < size; i++) {
            output.add(matrix[i][j]);
            index++;
        }
        i--;
        for (j = j - 1; j >= layer && index < size; j--) {
            output.add(matrix[i][j]);
            index++;
        }
        j++;
        for (i = i - 1; i > layer && index < size; i--) {
            output.add(matrix[i][j]);
            index++;
        }
        circle(matrix, output, size, index, layer + 1);
    }
}
