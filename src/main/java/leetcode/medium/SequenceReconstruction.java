package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2021/9/13 22:17
 * @Title
 * @Description //TODO
 **/

public class SequenceReconstruction {
    //[[5,2,6,3],[4,1,5,2]]

    public static void main(String[] args) {
        Integer[] nums1 = new Integer[]{5, 2, 6, 3};
        Integer[] nums2 = new Integer[]{4, 1, 5, 2};
        int[] org = new int[]{4, 1, 5, 2, 6, 3};
        List<List<Integer>> seqs = new ArrayList<>();
        seqs.add(Arrays.asList(nums1));
        seqs.add(Arrays.asList(nums2));
        SequenceReconstruction s = new SequenceReconstruction();
        s.sequenceReconstruction(org, seqs);
    }

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs.isEmpty()) return false;
        int n = org.length;
        if (n == 1) {
            boolean flag = false;
            for (List<Integer> seq : seqs) {
                int count = 0;
                for (int num : seq) {
                    if (num == org[0]) {
                        count++;
                        flag = true;
                    }
                    if (count > 1) return false;
                }
            }
            return flag;
        }
        int[] degree = new int[n + 1];
        Set<Integer>[] adj = new Set[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new HashSet<>();
        }
        for (List<Integer> seq : seqs) {
            int size = seq.size();
            for (int i = 0; i < size - 1; i++) {
                int num = seq.get(i);
                if (num > n) return false;
                if (!adj[num].contains(seq.get(i + 1))) {
                    adj[num].add(seq.get(i + 1));
                    degree[seq.get(i + 1)]++;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (degree[org[i]] == 0) return false;
        }
        for (int i = 0; i < n; i++) {
            if (degree[org[i]] != 0) return false;
            for (int k : adj[org[i]]) {
                degree[k]--;
                if (i < n - 1 && degree[k] == 0 && k != org[i + 1])
                    return false;
            }
        }
        return true;
    }
}
