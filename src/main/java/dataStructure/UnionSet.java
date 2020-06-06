package dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/5/14 10:29
 * @Title
 * @Description //TODO
 **/

public class UnionSet {

    private int count;
    private int[] parent;

    public UnionSet(int count) {
        this.count = count;
        parent = new int[count];
    }

    public int find(int p) {
        while (parent[p] != p) {
            // 进行路径压缩
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int parentP = find(p);
        int parentQ = find(q);
        if (parentP == parentQ) return;
        parent[parentP] = parentQ;
        count--;
    }
}
