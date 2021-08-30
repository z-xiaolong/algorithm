package leetcode.contest;

import java.util.*;

/**
 * @Author long
 * @Date 2021/3/28 10:06
 * @Title
 * @Description //TODO
 **/

public class Contest234 {

    public static void main(String[] args) {
        Integer c = new Integer(5);
        Integer d = Integer.valueOf(5);
        Integer a = 5;
        Integer b = 5;
        System.out.println(a == b);
        System.out.println(d == a);
        System.out.println(c == d);


    }




    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c != '(') {
                builder.append(c);
            } else {
                int j = i + 1;
                while (s.charAt(j) != ')') {
                    j++;
                }
                String word = s.substring(i + 1, j);
                builder.append(map.getOrDefault(word, "?"));
                i = j;
            }
            i++;
        }
        return builder.toString();
    }


    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        int[] arr = new int[n];
        swap(perm, arr, n);
        int[] tmp = arr;
        arr = perm;
        perm = tmp;
        int cnt = 1;
        while (perm[1] != 1) {
            swap(perm, arr, n);
            cnt++;
            int[] t = arr;
            arr = perm;
            perm = t;
        }
        return cnt;
    }

    public void swap(int[] perm, int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] = perm[i / 2];
            } else {
                arr[i] = perm[n / 2 + (i - 1) / 2];
            }
        }
    }


    public int numDifferentIntegers(String word) {
        Set<Integer> set = new HashSet<>();
        int num = 0;
        boolean flag = false;
        for (char c : word.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
                flag = true;
            } else {
                if (flag) {
                    set.add(num);
                }
                num = 0;
                flag = false;
            }
        }
        if (flag) {
            set.add(num);
        }
        return set.size();
    }


}
