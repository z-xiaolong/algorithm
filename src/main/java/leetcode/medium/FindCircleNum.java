package leetcode.medium;

/**
 * @Author long
 * @Date 2020/5/14 9:33
 * @Title
 * @Description //TODO
 **/

public class FindCircleNum {

    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionSet unionSet = new UnionSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) unionSet.union(i, j);
            }
        }
        return unionSet.count;
    }


    static class UnionSet {
        private int count;
        private int[] parent;

        public UnionSet(int count) {
            this.count = count;
            parent = new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
            }
        }

        //找到 P 的根节点
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }
    }
}
