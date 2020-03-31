package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2020/3/8 14:05
 * @Title 5354. 通知所有员工所需的时间
 * @Description //TODO
 **/

public class NumOfMinutes {


    //自己解 116ms
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, LinkedList<Integer>> hashMap = new HashMap<>(manager.length);
        for (int i = 0; i < manager.length; i++) {
            LinkedList<Integer> linkedList = hashMap.get(manager[i]);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
            }
            linkedList.add(i);
            hashMap.put(manager[i], linkedList);
        }
        return recursion(headID, informTime, hashMap);
    }

    public int recursion(int headID, int[] informTime, Map<Integer, LinkedList<Integer>> hashMap) {
        if (informTime[headID] == 0) {
            return 0;
        }
        int max = 0;
        LinkedList<Integer> linkedList = hashMap.get(headID);
        for (int num : linkedList) {
            int temp = recursion(num, informTime, hashMap) + informTime[headID];
            max = Math.max(temp, max);
        }
        return max;
    }


    //别人的DFS 98ms
    public int numOfMinutesI(int n, int headID, int[] managers, int[] informTime) {
        adj = new ArrayList[n];
        this.informTime = informTime;
        for (int i = 0; i < n; i++) {
            int manager = managers[i];
            if (manager == -1) {
                continue;
            }
            if (adj[manager] == null) {
                adj[manager] = new ArrayList<>();
            }
            adj[manager].add(i);
        }

        dfs(headID, 0);
        return ansMax;
    }

    private List<Integer>[] adj;
    private int ansMax = 0;
    private int[] informTime;

    private void dfs(int idx, int sum) {
        if (adj[idx] == null) {
            ansMax = Math.max(ansMax, sum);
            return;
        }
        List<Integer> nextList = adj[idx];
        for (Integer next : nextList) {
            dfs(next, sum + informTime[idx]);
        }
    }
}
