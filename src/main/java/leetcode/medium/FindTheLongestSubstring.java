package leetcode.medium;

/**
 * @Author long
 * @Date 2020/5/20 10:05
 * @Title 1371. 每个元音包含偶数次的最长子字符串
 * @Description //TODO
 **/

public class FindTheLongestSubstring {

    public int findTheLongestSubstring(String s) {
        return 0;
    }


    public int heightChecker(int[] heights) {
        int[] bucket = new int[101];
        for (int height : heights) {
            bucket[height]++;
        }
        int count = 0;
        for (int i = 1; i < bucket.length; i++) {

        }
        return count;
    }
}
