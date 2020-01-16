package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 20:34 2019/11/11
 * @Title 13. 罗马数字转整数
 * @Description 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 **/
public class RomanToInt {
    public int romanToInt(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        int sum = 0;
        int prev = 1000;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int value = hashMap.get(c);
            if (value > prev) {
                value = value - 2 * prev;
            }
            prev = value;
            sum = sum + value;
        }
        return sum;
    }

    public int romanToInt_two(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

}
