package leetcode.contest;

import java.util.*;

/**
 * @Author long
 * @Date 2020/4/18 14:56
 * @Title
 * @Description //TODO
 **/

public class Contest1 {

    public int minCount(int[] coins) {
        int min = 0;
        for (int coin : coins) {
            min += (coin + 1) / 2;
        }
        return min;
    }


    public int numWays(int n, int[][] relation, int k) {
        boolean[][] relations = new boolean[n][n];
        for (int[] r : relation) {
            relations[r[0]][r[1]] = true;
        }
        backtrack(relations, n, k, 0);
        return count;
    }

    public void backtrack(boolean[][] relations, int n, int k, int index) {
        if (k == 0) {
            if (index == n - 1) count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (relations[index][i]) {
                backtrack(relations, n, k - 1, i);
            }
        }
    }


    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] power = new int[3];
        int[] result = new int[requirements.length];
        Arrays.fill(result, -1);


        Map<int[], Integer> hashMap = new HashMap<>();
        for (int i = 0; i < requirements.length; i++) {
            hashMap.put(requirements[i], i);
        }
        Arrays.sort(requirements, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            if (o1[2] != o2[2]) return o1[2] - o2[2];
            return 0;
        });
        int day = 0;
        int index = check(hashMap, requirements, power, result, day, 0);
        for (int i = 0; i < increase.length; i++) {
            day++;
            increasePower(power, increase[i]);
            index = check(hashMap, requirements, power, result, day, index);
        }
        check(hashMap, requirements, power, result, day, index);
        return result;
    }

    public void increasePower(int[] power, int[] increase) {
        for (int i = 0; i < 3; i++) {
            power[i] += increase[i];
        }
    }

    public int check(Map<int[], Integer> hashMap, int[][] requirements, int[] power, int[] result, int day, int index) {
        while (index < requirements.length) {
            if (power[0] >= requirements[index][0] && power[1] >= requirements[index][1] && power[2] >= requirements[index][2]) {
                int i = hashMap.get(requirements[index]);
                result[i] = day;
                index++;
            } else {
                break;
            }
        }
        return index;
    }


    private int count = Integer.MAX_VALUE;

    public int minJump(int[] jump) {
        backtrack(jump, 0, 0);
        return count;
    }

    public void backtrack(int[] jump, int index, int times) {
        if (times >= count) return;
        int step = jump[index];
        if (index + step >= jump.length) {
            count = times + 1;
            return;
        }
        backtrack(jump, index + step, times + 1);
        if (index - step > 0) backtrack(jump, index - step, times + 1);
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        int[][] increase = new int[][]{{2, 8, 4}, {2, 5, 0}, {10, 9, 8}};
        int[][] re = new int[][]{{2, 11, 3}, {15, 10, 7}, {9, 17, 12}, {8, 1, 14}};
        contest.minJump(new int[]{1, 2, 3, 4, 5, 6, 4, 4, 2, 2, 2, 1, 1, 1, 1, 1});
    }
}
