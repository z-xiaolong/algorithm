package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: long
 * @Date: 2020/8/22 10:24
 * @Title 679. 24 点游戏
 * @Description:
 */
public class JudgePoint24 {

    static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        return dfs(list);
    }

    public boolean dfs(List<Double> list) {
        if (list.size() == 0) return false;
        if (list.size() == 1) return Math.abs(list.get(0) - TARGET) < EPSILON;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    List<Double> next = new ArrayList<>();
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) {
                            next.add(list.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && i > j) continue;
                        if (k == ADD) {
                            next.add(list.get(i) + list.get(j));
                        } else if (k == MULTIPLY) {
                            next.add(list.get(i) * list.get(j));
                        } else if (k == SUBTRACT) {
                            next.add(list.get(i) - list.get(j));
                        } else {
                            if (Math.abs(list.get(j)) >= EPSILON) {
                                next.add(list.get(i) / list.get(j));
                            } else {
                                continue;
                            }
                        }
                        if (dfs(next)) return true;
                        next.remove(next.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}
