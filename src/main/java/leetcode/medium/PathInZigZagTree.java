package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author long
 * @Date 2021/9/22 20:50
 * @Title
 * @Description //TODO
 **/

public class PathInZigZagTree {

    public static void main(String[] args) {
        PathInZigZagTree pathInZigZagTree = new PathInZigZagTree();
        pathInZigZagTree.pathInZigZagTree(18);
    }

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        int len = bitCount(label) - 1;
        int num = label ^ ((1 << len) - 1);
        for (int i = 0; i < len; i++) {
            if ((i & 1) == 1) {
                ans.add(label >> (len - i));
            } else {
                ans.add(num >> (len - i));
            }
        }

        return ans;
    }

    public int bitCount(int label) {
        int count = 0;
        while (label > 0) {
            count++;
            label >>= 1;
        }
        return count;
    }
}
