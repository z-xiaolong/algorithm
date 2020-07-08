package leetcode.byteDance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author long
 * @Date 2020/6/21 9:46
 * @Title 93. 复原IP地址
 * @Description //TODO
 **/

public class RestoreIpAddresses {

    public static void main(String[] args) {
        RestoreIpAddresses ipAddresses = new RestoreIpAddresses();
        ipAddresses.restoreIpAddresses("25525511135");
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> output = new LinkedList<>();
        Stack<String> ip = new Stack<>();
        dfs(output, 0, s, ip);
        return output;
    }

    public void dfs(List<String> output, int index, String s, Stack<String> ip) {
        int needed = 4 - ip.size();
        int remain = s.length() - index;
        if (remain < needed || remain > needed * 3) return;
        if (remain == 0 && needed == 0) {
            output.add(getString(ip));
            return;
        }
        for (int i = index + 1; i <= index + 3 && i <= s.length(); i++) {
            String sub = s.substring(index, i);
            int num = parseInt(sub);
            if (num > 255) continue;
            ip.push(sub);
            dfs(output, i, s, ip);
            ip.pop();
            if (num == 0) break;
        }
    }

    public int parseInt(String str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            num = num * 10 + str.charAt(i) - '0';
        }
        return num;
    }

    public String getString(Stack<String> list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            builder.append(list.get(i)).append('.');
        }
        builder.append(list.get(list.size() - 1));
        return builder.toString();
    }
}
