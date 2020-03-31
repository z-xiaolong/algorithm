package leetcode.hard;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/3/8 14:13
 * @Title 5355. T 秒后青蛙的位置
 * @Description //TODO
 **/

public class FrogPosition {


    public double frogPosition(int n, int[][] edges, int t, int target) {
        List[] lists = new LinkedList[n + 1];
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (lists[x] == null) {
                lists[x] = new LinkedList<Integer>();
            }
            if (lists[y] == null) {
                lists[y] = new LinkedList<Integer>();
            }
            lists[x].add(y);
            lists[y].add(x);
        }


        return 0;
    }
}
