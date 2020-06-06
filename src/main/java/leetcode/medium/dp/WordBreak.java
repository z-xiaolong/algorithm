package leetcode.medium.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author long
 * @Date 2020/4/27 23:07
 * @Title 139. 单词拆分
 * @Description //TODO
 **/

public class WordBreak {

    public static void main(String[] args) {

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> set = new HashSet<>(wordDict);//没想到用hash
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
