package leetcode.easy;

/**
 * @Author long
 * @Date 2020/2/26 22:27
 * @Title 28. 实现 strStr()
 * @Description 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 **/

public class StrStr {

    public static void main(String[] args) {
        String str1 = "mississippi";
        String str2 = "issip";
        StrStr strStr = new StrStr();
        strStr.strStr(str1, str2);
    }

    //执行用时 :1 ms, 在所有 Java 提交中击败了78.60%的用户
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int length = haystack.length();
        int subLength = needle.length();
        char first = needle.charAt(0);
        for (int i = 0; i < length; i++) {
            if (haystack.charAt(i) == first) {
                if (i + subLength > length) {
                    return -1;
                }
                if (check(needle, haystack.substring(i, i + subLength))) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean check(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }


    // 执行用时 :2775 ms, 在所有 Java 提交中击败了5.02%的用户
    public int strStrI(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        int length = haystack.length();
        int subLength = needle.length();
        int index = 0;
        int subIndex = 0;
        while (index < length) {
            while (index < length && subIndex < subLength && needle.charAt(subIndex) == haystack.charAt(index)) {
                index++;
                subIndex++;
            }
            if (subIndex == subLength) {
                return index - subIndex;
            } else {
                index = index - subIndex + 1;
            }
            subIndex = 0;
        }
        return -1;
    }
}
