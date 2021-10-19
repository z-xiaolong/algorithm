package leetcode.hard;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author long
 * @Date 2021/10/16 19:12
 * @Title
 * @Description //TODO
 **/

public class AddOperators {

    private List<String> ans = new ArrayList<>();
    private int n;
    private int target;
    String num;

    public List<String> addOperators(String num, int target) {
        this.n = num.length();
        this.target = target;
        this.num = num;
        dfs("", 0, 0, 0);
        return ans;
    }

    public void dfs(String nums, long res, long prev, int index) {
        if (index == n) {
            if (target == res) {
                ans.add(nums);
            }
            return;
        }
        for (int i = index; i < n; i++) {
            if (i != index && num.charAt(index) == '0') break;
            long cur = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                dfs(nums + cur, res + cur, cur, index + 1);
            } else {
                dfs(nums + "+" + cur, res + cur, cur, index + 1);
                dfs(nums + "-" + cur, res - cur, -cur, index + 1);
                dfs(nums + '*' + cur, res - prev + prev * cur, prev * cur, index + 1);
            }
        }
    }


    private String toString(Character[] nums) {
        StringBuilder builder = new StringBuilder();
        for (Character c : nums) {
            if (c != null) builder.append(c);
        }
        return builder.toString();
    }

    public int sum(Character[] nums) {
        int sum = 0;
        Deque<Integer> stack = new LinkedList<>();
        Deque<Character> opt = new LinkedList<>();
        int num = 0;
        for (Character e : nums) {
            if (e != null) {
                if (e >= '0' && e <= '9') {
                    num = num * 10 + e - '0';
                } else {
                    if (!opt.isEmpty()) {
                        if (opt.peek() == '*') {
                            stack.add(stack.pop() * num);
                        } else if (opt.peek() == '-') {
                            stack.add(-num);
                        } else {
                            stack.add(num);
                        }
                    } else {
                        stack.add(num);
                    }
                    num = 0;
                    opt.add(e);
                }
            }
        }
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
