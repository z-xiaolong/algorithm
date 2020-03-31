package leetcode.contest;

import leetcode.entity.ListNode;

import java.util.*;

/**
 * @Author long
 * @Date 2020/3/15 10:30
 * @Title 第 180 场周赛
 * @Description //TODO
 **/

public class Contest180 {

    //5356. 矩阵中的幸运数
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        List<Integer> list = new LinkedList<>();
        if (m == 0) {
            return list;
        }
        for (int i = 0; i < m; i++) {
            int min = min(matrix, i);
            if (isMax(matrix, i, min)) {
                list.add(matrix[i][min]);
            }
        }
        return list;
    }

    public boolean isMax(int[][] matrix, int i, int j) {
        int m = matrix.length;
        for (int k = 0; k < m; k++) {
            if (matrix[k][j] > matrix[i][j]) {
                return false;
            }
        }
        return true;
    }

    public int min(int[][] matrix, int i) {
        int n = matrix[0].length;
        int min = 0;
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] < matrix[i][min]) {
                min = j;
            }
        }
        return min;
    }

    //5359. 最大的团队表现值

    private long speedSum;
    private long minEfficiency;

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int max = 0;
        int[] flag = new int[n];
        for (int i = 0; i < n; i++) {
            if (speed[i] * efficiency[i] > speed[max] * efficiency[max]) {
                max = i;
            } else if (speed[i] * efficiency[i] == speed[max] * efficiency[max]) {
                if (efficiency[i] < efficiency[max]) {
                    max = i;
                }
            }
        }
        speedSum = speed[max];
        minEfficiency = efficiency[max];
        flag[max] = 1;
        k--;
        while (k > 0) {
            choice(n, speed, efficiency, flag);
            k--;
        }
        return (int) ((speedSum * minEfficiency) % 1000000007);
    }


    public void choice(int n, int[] speed, int[] efficiency, int[] flag) {
        long max = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (flag[i] == 0) {
                long value = getValue(speed[i], efficiency[i]);
                if (value > 0) {
                    if (max < value) {
                        index = i;
                        max = value;
                    } else if (value == max && efficiency[i] < efficiency[index]) {
                        index = i;
                    }
                } else if (value == 0 && max == 0) {
                    index = i;
                }
            }
        }
        if (index == -1) {
            return;
        }
        flag[index] = 1;
        speedSum = speedSum + speed[index];
        minEfficiency = Math.min(minEfficiency, efficiency[index]);
    }

    public long getValue(int speed, int efficiency) {
        long value = speed * Math.min(minEfficiency, efficiency);
        if (minEfficiency <= efficiency) {
            return value;
        }
        value -= speedSum * (minEfficiency - efficiency);
        return value;
    }

    //参考解：执行用时 :58 ms, 在所有 Java 提交中击败了100.00%的用户
    public int maxPerformanceI(int n, int[] speed, int[] efficiency, int k) {
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = speed[i];
            items[i][1] = efficiency[i];
        }
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long res = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            queue.add(items[i][0]);
            sum += items[i][0];
            if (queue.size() > k) {
                sum -= queue.poll();
            }
            res = Math.max(res, sum * items[i][1]);
        }
        return (int) (res % ((int) 1e9 + 7));
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.increment(5, 100);
        stack.increment(2, 100);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }


}
