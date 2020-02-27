package leetcode.contest;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Author long
 * @Date 2020/2/23 11:55
 * @Title
 * @Description //TODO
 **/

public class Contest177 {


    public int daysBetweenDates(String date1, String date2) {
        int result = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            int time1 = (int) (format.parse(date1).getTime() / 1000 / 60 / 60 / 24);
            int time2 = (int) (format.parse(date2).getTime() / 1000 / 60 / 60 / 24);
            result = Math.abs(time1 - time2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] tree = new boolean[n];
        traverse(tree, leftChild, rightChild, 0);
        boolean result = true;
        for (boolean node : tree) {
            result = result && node;
        }
        return result;
    }

    public void traverse(boolean[] tree, int[] leftChild, int[] rightChild, int index) {

        if (leftChild[index] <= index && leftChild[index] != -1) {
            return;
        }
        if (rightChild[index] <= index && rightChild[index] != -1) {
            return;
        }
        if (leftChild[index] != -1) {
            traverse(tree, leftChild, rightChild, leftChild[index]);
        }
        if (rightChild[index] != -1) {
            traverse(tree, leftChild, rightChild, rightChild[index]);
        }
        tree[index] = !tree[index];
    }


    /*给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
      两数乘积等于  num + 1 或 num + 2
      以绝对差进行度量，两数大小最接近
      你可以按任意顺序返回这两个整数。
    * */
    public int[] closestDivisors(int num) {
        int[] result = new int[2];
        int a = 1;
        int b = num + 1;
        for (int i = 1; i * i <= num + 1; i++) {
            if ((num + 1) % i == 0) {
                int temp = (num + 1) / i;
                if (Math.abs(temp - i) < Math.abs(a - b)) {
                    a = i;
                    b = temp;
                }
            }
        }
        for (int i = 1; i * i <= num + 2; i++) {
            if ((num + 2) % i == 0) {
                int temp = (num + 2) / i;
                if (Math.abs(temp - i) < Math.abs(a - b)) {
                    a = i;
                    b = temp;
                }
            }
        }
        result[0] = a;
        result[1] = b;
        return result;
    }

    /**
     * create by long on 2020/2/23
     *
     * @description 给你一个整数数组 digits，
     * 你可以通过按任意顺序连接其中某些数字来形成 3 的倍数，请你返回所能得到的最大的 3 的倍数。
     * 由于答案可能不在整数数据类型范围内，请以字符串形式返回答案。
     * 如果无法得到答案，请返回一个空字符串。
     */
    public String largestMultipleOfThree(int[] digits) {
        int[] array = new int[10];
        int sum = 0;
        for (int num : digits) {
            array[num]++;
            sum += num;
        }
        set(array, sum);
        if (sum == 0) {
            return "0";
        }
        if (sum == -1) {
            return "";
        }
        StringBuilder result = new StringBuilder(digits.length);
        for (int i = 9; i >= 0; i--) {
            while (array[i] > 0) {
                result.append(i);
                array[i]--;
            }
        }
        return result.toString();
    }

    public int set(int[] array, int sum) {
        if (sum % 3 == 0) {
            return sum;
        } else if (sum % 3 == 1) {
            for (int i = 1; i < 9; i++) {
                if (i % 3 == 1 && array[i] > 0) {
                    sum = sum - i;
                    array[i]--;
                    return sum;
                }
            }
            for (int i = 1; i < 9; i++) {
                if (i % 3 == 2 && array[i] > 0) {
                    sum = sum - i;
                    array[i]--;
                    return set(array, sum);
                }
            }
        } else {
            for (int i = 1; i < 9; i++) {
                if (i % 3 == 2 && array[i] > 0) {
                    sum = sum - i;
                    array[i]--;
                    return sum;
                }
            }
            for (int i = 1; i < 9; i++) {
                if (i % 3 == 1 && array[i] > 0) {
                    sum = sum - i;
                    array[i]--;
                    return set(array, sum);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 4, 3, 2};

    }

}
