package leetcode.swordOffer.medium;

import java.util.Stack;

/**
 * @Author long
 * @Date 2020/3/31 11:04
 * @Title 面试题33. 二叉搜索树的后序遍历序列
 * @Description //TODO
 **/

public class VerifyPostorder {

    public static void main(String[] args) {
        VerifyPostorder verifyPostorder = new VerifyPostorder();
        verifyPostorder.verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10});
    }

    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            Stack<Integer> stack = new Stack<>();
            int root = Integer.MAX_VALUE;
            for (int i = postorder.length - 1; i >= 0; i--) {
                if (postorder[i] > root) return false;
                while (!stack.isEmpty() && stack.peek() > postorder[i])
                    root = stack.pop();
                stack.add(postorder[i]);
            }
            return true;
        }
    }

    //分治：执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int left, int right) {
        if (left >= right) return true;
        int leftTree = left;
        while (leftTree < right && postorder[leftTree] < postorder[right]) {
            leftTree++;
        }
        boolean res = verifyPostorder(postorder, left, leftTree - 1);
        int rightTree = leftTree;
        while (rightTree < right && postorder[rightTree] > postorder[right]) {
            rightTree++;
        }
        if (rightTree != right) return false;
        return res && verifyPostorder(postorder, leftTree, right - 1);
    }
}
