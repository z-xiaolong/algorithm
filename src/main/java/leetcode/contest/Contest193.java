package leetcode.contest;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author long
 * @Date 2020/6/14 10:29
 * @Title
 * @Description //TODO
 **/

public class Contest193 {

    //5436. 一维数组的动态和
    public int[] runningSum(int[] nums) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        return sums;
    }

    //5437. 不同整数的最少数目
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int a : arr) {
            hashMap.put(a, hashMap.getOrDefault(a, 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(hashMap.values());
        int min = hashMap.size();
        while (k > 0) {
            int count = priorityQueue.poll();
            if (k >= count) {
                k -= count;
                min--;
            } else {
                break;
            }
        }
        return min;
    }


    //5438. 制作 m 束花所需的最少天数
    public int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean[] bloom = new boolean[bloomDay.length];
        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }
        int left = min;
        int right = max;
        while (left < right) {
            int mid = (left + right) >> 1;
            int num = getNum(bloomDay, bloom, mid, k);
            if (num > m) {
                right = mid - 1;
            } else if (num < m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (getNum(bloomDay, bloom, left, k) >= m) return left;
        return -1;
    }

    public int getNum(int[] bloomDay, boolean[] bloom, int day, int k) {
        int num = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            bloom[i] = bloomDay[i] <= day;
        }
        int count = 0;
        for (boolean b : bloom) {
            if (b) count++;
            else count = 0;
            if (count == k) {
                num++;
                count = 0;
            }
        }
        return num;
    }


    //5188. 树节点的第 K 个祖先
    class TreeAncestor {

        int[] parent;
        int n;
        HashMap<Integer, HashMap<Integer, Integer>> hashMap = new HashMap<>();

        public TreeAncestor(int n, int[] parent) {
            this.parent = parent;
            this.n = n;
        }

        public int getKthAncestor(int node, int k) {
            if (node == -1) return -1;
            if (k == 0) return node;
            int kParent;
            int max = 1;
            int parentNode = parent[node];
            if (hashMap.containsKey(node)) {
                HashMap<Integer, Integer> map = hashMap.get(node);
                if (map.containsKey(k))
                    return map.get(k);
                for (Integer i : map.keySet()) {
                    if (i < k) {
                        max = Math.max(max, i);
                        parentNode = map.get(i);
                    }
                }
            }
            kParent = getKthAncestor(parentNode, k - max);
            HashMap<Integer, Integer> map = hashMap.getOrDefault(node, new HashMap<>());
            map.put(k, kParent);
            hashMap.put(node, map);
            return kParent;
        }
    }

    public static void main(String[] args) {

    }
}
