package leetcode.byteDance;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author long
 * @Date 2020/6/21 9:21
 * @Title 简化路径
 * @Description //TODO
 **/

public class SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> queue = new LinkedList<>();
        int left;
        int right = 0;
        int length = path.length();
        while (right < length) {
            while (right < length && path.charAt(right) == '/') {
                right++;
            }
            left = right;
            while (right < length && path.charAt(right) != '/') {
                right++;
            }
            if (left == right) continue;
            String p = path.substring(left, right);
            if ("..".equals(p)) {
                if (queue.size() > 0) queue.poll();
            } else if (!".".equals(p)) {
                queue.addFirst(p);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            builder.append("/").append(queue.pollLast());
        }
        if (builder.length() == 0) return "/";
        return builder.toString();
    }
}
