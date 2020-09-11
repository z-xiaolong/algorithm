package algorithm;


import java.util.LinkedList;

/**
 * @Author: long
 * @Date: 2020/8/12 10:32
 * @Title 装载问题
 * @Description:
 */
public class Loading {
    int n;      //集装箱数量
    int[] w;     //集装箱重量数组
    int c;       //轮船载重量
    int cw;     //当前载重量
    int bestW;  //最优载重量
    int r;     //剩余集装箱重量

    public int maxLoading(int[] w, int c) {
        this.n = w.length - 1;
        this.w = w;
        this.c = c;
        this.cw = 0;
        this.bestW = 0;
        this.r = 0;
        backtrack(1);
        return bestW;
    }

    private void backtrack(int i) {
        if (i > n) {
            if (cw > bestW) bestW = cw;
            return;
        }
        r -= w[i];
        if (cw + w[i] <= c) {
            cw += w[i];
            backtrack(i + 1);
            cw -= w[i];
        }
        if (cw - r > bestW) {
            backtrack(i + 1);
        }
        r += w[i];
    }

    public static void main(String[] args) {
        int[] w = new int[]{0, 10, 5, 6, 5, 15, 20};
        int n = w.length - 1;
        int[] best = new int[n + 1];
        System.out.println(maxLoading(w, 40, n, best));
        for (int i = 1; i < best.length; i++) {
            System.out.print(best[i] + " ");
        }
    }

    public static int maxLoading(int[] w, int c, int n, int[] best) {
        int i = 1;
        int[] x = new int[n + 1];
        int bestW = 0;
        int cw = 0;
        int r = 0;
        for (int j = 1; j <= n; j++) {
            r += w[j];
        }
        while (true) {
            while (i <= n && cw + w[i] <= c) {  //进入左子树
                r -= w[i];
                cw += w[i];
                x[i] = 1;
                i++;
            }
            if (i > n) {    //到达叶节点
                for (int j = 1; j <= n; j++) {
                    best[j] = x[j];
                    bestW = cw;
                }
            } else {  //进入右子树
                r -= w[i];
                x[i] = 0;
                i++;
            }
            while (cw + r <= bestW) {   //剪枝回溯
                i--;
                while (i > 0 && x[i] == 0) {  //从右子树返回
                    r += w[i];
                    i--;
                }
                if (i == 0) {
                    return bestW;
                }
                //进入右子树
                x[i] = 0;
                cw -= w[i];
                i++;
            }
        }

    }


}
