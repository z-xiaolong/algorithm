package leetcode.contest;

import leetcode.byteDance.Contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author long
 * @Date 2020/7/12 9:32
 * @Title
 * @Description //TODO
 **/

public class Contest197 {


    //5460. 好数对的数目
    public int numIdenticalPairs(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    //5461. 仅含 1 的子串数
    public int numSub(String s) {
        int mod = 1000000007;
        int i = 0;
        long cnt;
        long sum = 0;
        while (i < s.length()) {
            cnt = 0;
            while (i < s.length() && s.charAt(i) == '1') {
                i++;
                cnt++;
            }
            sum = (sum + ((cnt + 1) * cnt >> 1)) % mod;
            i++;
        }
        return (int) sum;
    }


    private double res = 0.0;

    //5211. 概率最大的路径
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Set<double[]>> hashMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!hashMap.containsKey(edges[i][0])) {
                hashMap.put(edges[i][0], new HashSet<>());
            }
            hashMap.get(edges[i][0]).add(new double[]{edges[i][1], succProb[i]});
            if (!hashMap.containsKey(edges[i][1])) {
                hashMap.put(edges[i][1], new HashSet<>());
            }
            hashMap.get(edges[i][1]).add(new double[]{edges[i][0], succProb[i]});
        }
        if (!hashMap.containsKey(end)) return res;
        boolean[] flag = new boolean[n];
        backtrack(hashMap, flag, start, end, 1.0);
        return res;
    }

    public void backtrack(Map<Integer, Set<double[]>> hashMap, boolean[] flag, int i, int end, double p) {
        if (i == end) {
            res = Math.max(res, p);
            return;
        }
        flag[i] = true;
        if (p <= res || p == 0) return;
        Set<double[]> set = hashMap.get(i);
        for (double[] sub : set) {
            double temp = p * sub[1];
            if (temp < res) continue;
            int next = (int) sub[0];
            if (!flag[next]) {
                backtrack(hashMap, flag, next, end, temp);
            }
        }
        flag[i] = false;
    }



    public static void main(String[] args) {
        Contest197 contest = new Contest197();
    }
}
