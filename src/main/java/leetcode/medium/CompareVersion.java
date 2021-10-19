package leetcode.medium;

/**
 * @Author long
 * @Date 2021/9/1 10:27
 * @Title
 * @Description //TODO
 **/

public class CompareVersion {

    public static void main(String[] args) {
        String str = "13.323.1321.43.43";
        String[] s = str.split("\\.");
        for (String v : s) {
            System.out.println(v);
        }
    }

    public int compareVersion(String v1, String v2) {
        int i = 0;
        int j = 0;
        while (i < v1.length() || j < v2.length()) {
            int num1 = 0;
            int num2 = 0;
            while (i < v1.length() && v1.charAt(i) != '.') {
                num1 = num1 * 10 + v1.charAt(i) - '0';
                i++;
            }
            while (j < v2.length() && v2.charAt(j) != '.') {
                num2 = num2 * 10 + v2.charAt(j) - '0';
                j++;
            }
            if (num1 != num2) {
                return num1 > num2 ? 1 : -1;
            }
            i++;
            j++;
        }
        return 0;
    }

    public int getVersion(String v) {
        int i = 0;
        int num = 0;
        while (i < v.length()) {
            num = num * 10 + (v.charAt(i) - '0');
            i--;
        }
        return num;
    }
}
