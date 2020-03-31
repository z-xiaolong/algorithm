package leetcode.contest;

import leetcode.medium.Trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/3/29 10:10
 * @Title
 * @Description //TODO
 **/

public class Contest182 {


    //5368. 找出数组中的幸运数
    public int findLucky(int[] arr) {
        int[] nums = new int[501];
        for (int i : arr) {
            nums[i]++;
        }
        int max = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == i) {
                max = Math.max(max, i);
            }
        }
        return max;
    }

    //5369. 统计作战单位数
    int sum = 0;

    public int numTeams(int[] rating) {
        int n = rating.length;
        for (int i = 0; i < n; i++) {
            backtrackUp(rating, i, 1);
            backtrackDown(rating, i, 1);
        }
        return sum;
    }

    public void backtrackDown(int[] rating, int index, int count) {
        if (index >= rating.length) {
            return;
        }
        if (count == 3) {
            sum++;
            return;
        }
        for (int i = index + 1; i < rating.length; i++) {
            if (rating[i] < rating[index]) {
                backtrackDown(rating, i, count + 1);
            }
        }
    }

    public void backtrackUp(int[] rating, int index, int count) {
        if (index >= rating.length) {
            return;
        }
        if (count == 3) {
            sum++;
            return;
        }
        for (int i = index + 1; i < rating.length; i++) {
            if (rating[i] > rating[index]) {
                backtrackUp(rating, i, count + 1);
            }
        }
    }


    //5370. 设计地铁系统


    //5371. 找到所有好字符串
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        return 0;
    }

    class TrieNode {
        char value;
        TrieNode[] children = new TrieNode[26];



        public TrieNode(char value) {
            this.value = value;
        }

        public TrieNode getChild(char c) {
            if (children[c - 'a'] == null) {
                TrieNode node = new TrieNode(c);
                children[c - 'a'] = node;
                return node;
            }
            return children[c - 'a'];
        }
    }


    public static void main(String[] args) {
        /*Contest182 contest182 = new Contest182();
        int[] nums = new int[]{2, 5, 3, 4, 1};
        contest182.numTeams(nums);*/

        UndergroundSystem system = new UndergroundSystem();
    }
}
