package leetcode.easy;

/**
 * @Author long
 * @Date 2020/5/19 10:18
 * @Title 657. 机器人能否返回原点
 * @Description //TODO
 **/

public class JudgeCircle {

    public static void main(String[] args) {
        judgeCircle("LLRRUD");
    }

    public static boolean judgeCircle(String moves) {
        int left = 0;
        int up = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') left++;
            else if (c == 'R') left--;
            else if (c == 'U') up++;
            else if (c == 'D') up--;
        }
        return left == 0 && up == 0;
    }
}
