package leetcode.easy;

/**
 * @Author long
 * @Date 2020/6/10 9:58
 * @Title 面试题 01.01. 判定字符是否唯一
 * @Description //TODO
 **/

public class IsUnique {

    public boolean isUnique(String astr) {
        int[] hash = new int[128];
        for (char c : astr.toCharArray()) {
            hash[c]++;
        }
        for (int i : hash) {
            if (i > 1) return false;
        }
        return true;
    }
}
