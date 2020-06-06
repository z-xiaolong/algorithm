package leetcode.hard;

/**
 * @Author long
 * @Date 2020/3/22 14:52
 * @Title KMP算法
 * @Description 字符串匹配 KMP: https://zhuanlan.zhihu.com/p/83334559
 **/

public class KMP {

    public static void main(String[] args) {
        KMP kmp = new KMP();
        int i = kmp.kmp("abcbabcdabde", "abcdab");
        System.out.println(i);
    }

    public int kmp(String S, String P) {
        int sLen = S.length();
        int pLen = P.length();
        int[] next = next(P);
        int i = 0;
        int j = 0;
        while (i < sLen && j < pLen) {
            if (S.charAt(i) == P.charAt(j)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j - 1]; //最大相同前缀后缀
            }
        }
        if (j == pLen) return i - j;
        else return -1;
    }

    //双指针
    public int[] next(String target) {
        int length = target.length();
        int[] next = new int[length];
        int left = 0;
        int right = 1;
        while (left < length && right < length) {
            if (target.charAt(left) == target.charAt(right)) {
                next[right] = left + 1; //算法精髓的一步，left 的值是最大前缀的值
                left++;
                right++;
            } else if (left == 0) {
                next[right] = 0;
                right++;
            } else {
                left = next[left - 1];  //回溯，当前字符不匹配，更新left为上个next的值
            }
        }
        return next;
    }
}
