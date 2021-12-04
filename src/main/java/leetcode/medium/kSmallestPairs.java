package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author long
 * @Date 2021/11/19 11:00
 * @Title
 * @Description //TODO
 **/

public class kSmallestPairs {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 7, 11};
        int[] nums2 = new int[]{1, 4, 6};
        kSmallestPairs smallest = new kSmallestPairs();
        smallest.kSmallestPairs(nums1, nums2, 3);
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] + b[1] - a[0] - a[1]);
        for (int i = 0; i < n && i < k; i++) {
            for (int j = 0; j < m && j < k; j++) {
                queue.add(new int[]{nums1[i], nums2[j]});
            }
        }
        int size = Math.min(m * n, k);
        ArrayList<List<Integer>> ans = new ArrayList<>(size);
        while (queue.size() > size) queue.poll();
        for (int j = 0; j < size; j++) {
            ans.add(new ArrayList<>());
        }
        for (int j = size - 1; j >= 0; j--) {
            int[] p = queue.poll();
            ans.get(j).add(p[0]);
            ans.get(j).add(p[1]);
        }
        return ans;
    }

    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] + b[1] - a[0] - a[1]);
        for (int i = 0; i < n && i < k; i++) {
            for (int j = 0; j < m && j < k; j++) {
                if (queue.size() < k) {
                    queue.add(new int[]{nums1[i], nums2[j]});
                } else {
                    int cur = nums1[i] + nums2[j];
                    int max = queue.peek()[0] + queue.peek()[1];
                    if (cur < max) {
                        queue.poll();
                        queue.add(new int[]{nums1[i], nums2[j]});
                    } else {
                        break;
                    }
                }
            }
        }
        ArrayList<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            List<Integer> list = new ArrayList<>();
            list.add(top[0]);
            list.add(top[1]);
            ans.add(list);
        }
        return ans;
    }
}
