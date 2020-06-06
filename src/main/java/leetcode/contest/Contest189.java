package leetcode.contest;

import leetcode.entity.ListNode;

import java.util.*;

/**
 * @Author long
 * @Date 2020/5/17 10:29
 * @Title
 * @Description //TODO
 **/

public class Contest189 {

    //5412. 在既定时间做作业的学生人数
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        int n = startTime.length;
        for (int i = 0; i < n; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i])
                count++;
        }
        return count;
    }


    //5413. 重新排列句子中的单词
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        words[0] = words[0].toLowerCase();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        String str = words[0].substring(0, 1);
        str = str.toUpperCase();
        words[0] = str + words[0].substring(1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            builder.append(words[i]).append(" ");
        }
        builder.append(words[words.length - 1]);
        return builder.toString();
    }


    //5414. 收藏清单
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        HashSet<String>[] sets = new HashSet[n];
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<>(favoriteCompanies.get(i));
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i != j && match(sets[i], sets[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) list.add(i);
        }
        return list;
    }

    public boolean match(HashSet<String> set1, HashSet<String> set2) {
        int count = 0;
        for (String str : set1) {
            if (set2.contains(str)) count++;
        }
        return count == set1.size();
    }


    //5415. 圆形靶内的最大飞镖数量
    public int numPoints(int[][] points, int r) {
        int n = points.length;
        HashSet<Integer>[] sets = new HashSet[n];
        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
        }
        for (int i = 0; i < n; i++) {
            sets[i].add(i);
            for (int j = i + 1; j < n; j++) {
                if (match(points[i], points[j], r)) {
                    sets[i].add(j);
                    sets[j].add(i);
                }
            }
        }
        int max = 0;
        HashSet<Integer> set;
        for (int i = 0; i < sets.length; i++) {
            set = new HashSet<>(sets[i]);
            for (int j : sets[i]) {
                for (int k : sets[i]) {
                    if (!sets[j].contains(k)) {
                        set.remove(k);
                    }
                }
            }
            max = Math.max(max, set.size());
        }
        return max;
    }

    public boolean match(int[] point1, int[] point2, int r) {
        int x = Math.abs(point1[0] - point2[0]);
        int y = Math.abs(point1[1] - point2[1]);
        return (x * x + y * y) <= 4 * r * r;
    }

    public void backtrack(int[][] points, int index) {

    }


    public static void main(String[] args) {

    }
}
