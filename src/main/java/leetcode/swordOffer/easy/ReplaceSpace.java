package leetcode.swordOffer.easy;

/**
 * @Author long
 * @Date 2020/3/1 20:01
 * @Title 面试题05. 替换空格
 * @Description 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 **/

public class ReplaceSpace {
    public String replaceSpace(String s) {
        //s = s.replaceAll(" ", "%20");
        // s = s.replace(" " , "%20");
        StringBuilder builder = new StringBuilder(3 * s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '\b') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
