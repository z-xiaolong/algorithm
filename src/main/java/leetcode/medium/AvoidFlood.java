package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2020/6/22 10:14
 * @Title 1488. 避免洪水泛滥
 * @Description //TODO
 **/

public class AvoidFlood {


    public int[] avoidFlood(int[] rains) {
        int len = rains.length;
        int[] mem = new int[len];
        int[] res = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = len - 1; i >= 0; i--) {
            mem[i] = map.getOrDefault(rains[i], -1);
            map.put(rains[i], i);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> mem[o]));
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (rains[i] == 0) {
                if (!queue.isEmpty()) {
                    int temp = rains[queue.poll()];
                    set.remove(temp);
                    res[i] = temp;
                } else {
                    res[i] = 1;
                }
            } else if (set.contains(rains[i])) {
                return new int[0];
            } else {
                set.add(rains[i]);
                if (mem[i] != -1) {
                    queue.add(i);
                }
                res[i] = -1;
            }
        }
        return res;
    }


    //贪心+二分查找：执行用时：176 ms
    public int[] avoidFloodI(int[] rains) {
        int[] res = new int[rains.length];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                list.add(i);
                continue;
            } else if (map.containsKey(rains[i])) {
                int lastDay = map.get(rains[i]);
                int sunDay = binarySearch(list, lastDay);
                if (sunDay == -1) return new int[0];
                else res[sunDay] = rains[i];
            }
            res[i] = -1;
            map.put(rains[i], i);
        }
        if (list.size() > 0) {
            for (Integer i : list) {
                res[i] = 1;
            }
        }
        return res;
    }

    public int binarySearch(List<Integer> list, int target) {
        if (list.size() == 0) return -1;
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            int num = list.get(mid);
            if (num <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == list.size() - 1 && list.get(left) <= target) {
            return -1;
        }
        int res = list.get(left);
        list.remove(left);
        return res;
    }
}
