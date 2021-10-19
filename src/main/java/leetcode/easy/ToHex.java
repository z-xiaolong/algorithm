package leetcode.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author long
 * @Date 2021/10/2 14:14
 * @Title
 * @Description //TODO
 **/

public class ToHex {

    public static void main(String[] args) {
        int num = -1;
        System.out.println(0xf);
        System.out.println(Integer.toBinaryString(num));
        while (num != 0) {
            if ((num & 1) == 1) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
            num >>>= 1;
        }
        /*System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toBinaryString(~num));
        System.out.println(num);
        System.out.println(~num);
        System.out.println(~1);
        System.out.println(Integer.toBinaryString(~1));*/
    }

    String[] map = new String[]{"a", "b", "c", "d", "e", "f"};

    public String toHex(int num) {
        StringBuilder builder = new StringBuilder();
        while (num != 0) {
            builder.append(toString(num & 0xf));
            num >>>= 4;
        }
        return builder.reverse().toString();
    }


    public String toString(int num) {
        if (num >= 0 && num <= 9) {
            return String.valueOf(num);
        } else {
            return map[num - 10];
        }
    }

    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for (List<String> path : paths) {
            set.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!set.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
