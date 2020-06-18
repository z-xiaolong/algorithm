package leetcode.easy;

/**
 * @Author long
 * @Date 2020/6/10 10:05
 * @Title 面试题 01.02. 判定是否互为字符重排
 * @Description //TODO
 **/

public class CheckPermutation {

    public boolean CheckPermutation(String s1, String s2) {
        int[] hash = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            hash[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            hash[s2.charAt(i)]--;
        }
        for (int i : hash) {
            if (i != 0) return false;
        }
        return true;
    }
}
