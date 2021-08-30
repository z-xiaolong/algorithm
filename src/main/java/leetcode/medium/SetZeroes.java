package leetcode.medium;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2021/3/21 16:59
 * @Title
 * @Description //TODO
 **/

public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int flag = -1;
        for (int i = 0; i < n; i++) {
            boolean existZero = false;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    if (flag == -1) {
                        flag = i;
                        break;
                    } else {
                        existZero = true;
                        matrix[flag][j] = 0;
                    }
                }
            }
            if (existZero) {
                Arrays.fill(matrix[i], 0);
            }
        }
        if (flag == -1) {
            return;
        }
        for (int i = 0; i < m; i++) {
            if (matrix[flag][i] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        Arrays.fill(matrix[flag], 0);
    }
}
