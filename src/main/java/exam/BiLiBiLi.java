package exam;

import java.util.*;

/**
 * @Author: long
 * @Date: 2020/8/13 19:43
 * @Title
 * @Description:
 */
public class BiLiBiLi {
    public static void main(String[] args) {

    }


    public boolean Game24Points(int[] arr) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add((double) arr[i]);
        }
        return dfs(list);
    }

    public boolean dfs(List<Double> list) {
        if (list.size() == 0) return false;
        if (list.size() == 1) return Math.abs(list.get(0) - 24) < 1e-6;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    List<Double> temp = new ArrayList<>();
                    for (int k = 0; k < list.size(); k++) {
                        if (k != i && k != j) {
                            temp.add(list.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) continue;
                        if (k == 0) temp.add(list.get(i) + list.get(j));
                        if (k == 1) temp.add(list.get(i) * list.get(j));
                        if (k == 2) temp.add(list.get(i) - list.get(j));
                        if (k == 3) {
                            if (list.get(j) != 0) {
                                temp.add(list.get(i) / list.get(j));
                            } else {
                                continue;
                            }
                        }
                        if (dfs(temp)) return true;
                        temp.remove(temp.size() - 1);
                    }
                }
            }
        }
        return false;
    }


    public boolean IsValidExp(String s) {
        if ("".equals(s) || s.length() == 0) return true;
        Map<Character, Character> hashMap = new HashMap<>();
        hashMap.put('}', '{');
        hashMap.put(']', '[');
        hashMap.put(')', '(');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                if (stack.isEmpty() || hashMap.get(c) != stack.pop()) return false;
            } else stack.push(c);
        }
        return stack.isEmpty();
    }


    public int GetCoinCount(int N) {
        N = 1024 - N;
        int cnt = 0;
        while (N > 0) {
            if (N >= 64) N -= 64;
            else if (N >= 16) N -= 16;
            else if (N >= 4) N -= 4;
            else N--;
            cnt++;
        }
        return cnt;
    }

}
