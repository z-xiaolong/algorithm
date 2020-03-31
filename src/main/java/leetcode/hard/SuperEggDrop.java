package leetcode.hard;

/**
 * @Author long
 * @Date 2020/2/21 17:51
 * @Title 887. 鸡蛋掉落
 * @Description 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，
 * 从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层X扔下（满足 1 <= X <= N）
 * 你的目标是确切地知道 F 的值是多少。
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 **/

public class SuperEggDrop {

    public static void main(String[] args) {
        SuperEggDrop eggDrop = new SuperEggDrop();
        eggDrop.superEggDrop(2, 6);
    }

    public int superEggDrop(int K, int N) {
        // m 最多不会超过N 次（线性扫描）
        int[][] dp = new int[K + 1][N + 1];
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int i = 1; i <= K; i++) {
                dp[i][m] = dp[i][m - 1] + dp[i - 1][m - 1] + 1;
            }
        }
        return m;
    }


    int[][] nums;

    //动态规划+二分
    public int superEggDrop2(int K, int N) {
        nums = new int[K + 1][N + 1];
        return dp2(K, N);
    }

    public int dp2(int K, int N) {
        if (nums[K][N] != 0) {
            return nums[K][N];
        }
        if (K == 1 || N <= 2) {
            nums[K][N] = N;
            return N;
        }
        nums[K][N] = N;
        int high = N;
        int low = 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            int broken = dp2(K - 1, mid - 1);
            int notBroken = dp2(K, N - mid);
            if (broken > notBroken) {
                high = mid - 1;
                nums[K][N] = Math.min(nums[K][N], broken + 1);
            } else {
                low = mid + 1;
                nums[K][N] = Math.min(nums[K][N], notBroken + 1);
            }
        }
        return nums[K][N];
    }


    //动态规划，超时
    public int superEggDrop1(int K, int N) {
        nums = new int[K + 1][N + 1];
        return dp1(K, N);
    }

    public int dp1(int K, int N) {
        if (nums[K][N] != 0) {
            return nums[K][N];
        }
        if (K == 1 || N <= 2) {
            nums[K][N] = N;
            return N;
        }
        nums[K][N] = N;
        for (int i = 1; i <= N; i++) {
            nums[K][N] = Math.min(nums[K][N], Math.max(dp1(K, N - i), dp1(K - 1, i - 1)) + 1);
        }
        return nums[K][N];
    }
}
