package leetcode.easy;

/**
 * @Author long
 * @Date 2020/2/27 11:29
 * @Title 58. 最后一个单词的长度
 * @Description 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
 * 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指仅由字母组成、不包含任何空格的 最大子字符串。
 **/

public class LengthOfLastWord {

    //遍历
    public int lengthOfLastWord(String s) {
        int count = 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }

    //使用API
    public int lengthOfLastWordI(String s) {
        String[] strs = s.split(" ");
        if (strs.length == 0) {
            return 0;
        }
        String end = strs[strs.length - 1];
        return end.length();
    }
}
