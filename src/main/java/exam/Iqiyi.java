package exam;

import java.util.*;

/**
 * @Author: long
 * @Date: 2020/8/23 14:29
 * @Title
 * @Description:
 */
public class Iqiyi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        System.out.println(count);
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c))
                    return false;
            } else stack.push(c);
        }
        return stack.isEmpty();
    }

    public static boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        set.add("0,0");
        for (int i = 0; i < path.length(); i++) {
            String p = getPath(path, i);
            if (set.contains(p)) return true;
            set.add(p);
        }
        return false;
    }

    static int x = 0;
    static int y = 0;

    public static String getPath(String path, int index) {
        char c = path.charAt(index);
        switch (c) {
            case 'N':
                x--;
                break;
            case 'S':
                x++;
                break;
            case 'E':
                y++;
                break;
            case 'W':
                y--;
                break;
        }
        return x + "," + y;
    }


    public static int CountZero(int n) {
        int count = 0;
        int remain = 1;
        for (int i = 2; i <= n; i++) {

        }

        return count;
    }
}


