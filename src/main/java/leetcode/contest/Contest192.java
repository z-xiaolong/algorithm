package leetcode.contest;

import java.util.*;

/**
 * @Author long
 * @Date 2020/6/7 10:27
 * @Title
 * @Description //TODO
 **/

public class Contest192 {

    //5428. 重新排列数组
    public int[] shuffle(int[] nums, int n) {
        int[] newNums = new int[2 * n];
        int k = 0;
        for (int i = 0, j = n; i < n && j < 2 * n; i++, j++) {
            newNums[k++] = nums[i];
            newNums[k++] = nums[j];
        }
        return newNums;
    }

    //5429. 数组中的 k 个最强值
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int mid = arr[(arr.length - 1) >> 1];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int a = Math.abs(o1 - mid);
            int b = Math.abs(o2 - mid);
            if (a == b) return o1 - o2;
            return a - b;
        });
        for (int a : arr) {
            priorityQueue.add(a);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }


    //5430. 设计浏览器历史记录
    class BrowserHistory {

        private String homepage;
        private Stack<String> forward = new Stack<>();
        private Stack<String> back = new Stack<>();

        public BrowserHistory(String homepage) {
            this.homepage = homepage;
            back.add(homepage);
        }

        public void visit(String url) {
            back.add(url);
            forward.clear();
        }

        public String back(int steps) {
            while (back.size() > 1 && steps > 0) {
                forward.push(back.pop());
                steps--;
            }
            return back.peek();
        }

        public String forward(int steps) {
            if (forward.isEmpty()) return back.peek();
            while (forward.size() > 0 && steps > 0) {
                back.push(forward.pop());
                steps--;
            }
            return back.peek();
        }
    }

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        return 0;
    }


    public static void main(String[] args) {

    }
}
