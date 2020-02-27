package leetcode.easy;

/**
 * @Author long
 * @Date 2020/2/27 9:49
 * @Title 38. 外观数列
 * @Description 「外观数列」是一个整数序列，
 * 从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 **/

public class CountAndSay {

    public static void main(String[] args) {
        String s = "1211";
        System.out.println(transform(s));
    }

    public String countAndSay(int n) {
        String[] strs = new String[n];
        strs[0] = "1";
        for (int i = 1; i < n; i++) {
            strs[i] = transform(strs[i - 1]);
        }
        return strs[n - 1];
    }

    public static String transform(String str) {
        int length = str.length();
        StringBuilder builder = new StringBuilder(length * 2);
        int count = 1;
        char c = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            } else {
                builder.append(count).append(c);
                count = 1;
                c = str.charAt(i);
            }
        }
        builder.append(count).append(c);
        return builder.toString();
    }
}
