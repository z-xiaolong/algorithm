package leetcode.swordOffer.easy;

/**
 * @Author long
 * @Date 2020/3/1 20:38
 * @Title 面试题04. 二维数组中的查找
 * @Description 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 **/

public class FindNumberIn2DArray {

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 3, 5}};
        FindNumberIn2DArray array = new FindNumberIn2DArray();
        array.findNumberIn2DArray(nums, 5);
    }

    //重点题目
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = 0;
        int n = matrix[0].length - 1;
        while (n >= 0 && m < matrix.length) {
            if (matrix[m][n] > target) {
                n--;
            } else if (matrix[m][n] < target) {
                m++;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArrayI(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int k = Math.min(m, n);
        int index = 0;
        for (int i = 0; i < k; i++) {
            if (matrix[i][i] < target) {
                index++;
            } else if (matrix[i][i] == target) {
                return true;
            }
        }
        for (int i = index; i < m; i++) {
            if (matrix[i][0] > target) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > target) {
                    break;
                } else if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        for (int i = index; i < n; i++) {
            if (matrix[0][i] > target) {
                break;
            }
            for (int j = 0; j < m; j++) {
                if (matrix[j][i] > target) {
                    break;
                } else if (matrix[j][i] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
