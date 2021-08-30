package leetcode.hard;

/**
 * @Author long
 * @Date 2021/1/16 16:30
 * @Title
 * @Description //TODO
 **/

public class HitBricks {

    private int rows;
    private int cols;
    public static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        int[][] copy = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (cols >= 0) {
                System.arraycopy(grid[i], 0, copy[i], 0, cols);
            }
        }
        for (int[] hit : hits) {
            copy[hit[0]][hit[1]] = 0;
        }
        int size = cols * rows;
        UnionSet unionSet = new UnionSet(size + 1);
        for (int i = 0; i < cols; i++) {
            if (copy[0][i] == 1) {
                unionSet.union(i, size);
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (copy[i][j] == 1) {
                    if (copy[i - 1][j] == 1) {
                        unionSet.union(getIndex(i, j), getIndex(i - 1, j));
                    }
                    if (j > 0 && copy[i][j - 1] == 1) {
                        unionSet.union(getIndex(i, j), getIndex(i, j - 1));
                    }
                }
            }
        }

        int hitLength = hits.length;
        int[] res = new int[hitLength];
        for (int i = hitLength - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if (grid[x][y] == 0) {
                continue;
            }
            int origin = unionSet.getSize(size);
            if (x == 0) {
                unionSet.union(y, size);
            }
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY) && copy[newX][newY] == 1) {
                    unionSet.union(getIndex(x, y), getIndex(newX, newY));
                }
            }
            int current = unionSet.getSize(size);
            res[i] = Math.max(0, current - origin - 1);
            copy[x][y] = 1;
        }
        return res;
    }

    public boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public int getIndex(int i, int j) {
        return i * cols + j;
    }


    class UnionSet {
        private int[] parent;
        private int[] size;

        public UnionSet(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                int p = find(parent[x]);
                parent[x] = p;
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int xParent = find(x);
            int yParent = find(y);
            if (xParent == yParent) {
                return;
            }
            parent[xParent] = yParent;
            size[yParent] += size[xParent];
        }

        public int getSize(int x) {
            int root = find(x);
            return size[root];
        }
    }
}
