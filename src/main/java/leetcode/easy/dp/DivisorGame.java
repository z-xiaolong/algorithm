package leetcode.easy.dp;

/**
 * @Author long
 * @Date 2020/2/18 17:01
 * @Title 1025. 除数博弈
 * @Description 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。
 * 假设两个玩家都以最佳状态参与游戏。
 **/

public class DivisorGame {

    public static void main(String[] args) {
        //System.out.println(divisorGame(7));
    }

    //数学
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

    //递归，超时
    public boolean divisorGame2(int N) {
        if (N == 1) {
            return false;
        }
        for (int i = 1; i <= N / 2; i++) {
            if (N % i == 0) {
                if (!divisorGame2(N - i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean divisorGame1(int N) {
        if (N < 4) {
            return N == 2;
        }
        boolean[] result = new boolean[N + 1];
        result[1] = false;
        result[2] = true;
        result[3] = false;
        for (int i = 4; i <= N; i++) {
            result[i] = false;
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0 && !result[i - j]) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[N];
    }

}
