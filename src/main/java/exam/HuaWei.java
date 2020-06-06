package exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/5/6 18:53
 * @Title
 * @Description //TODO
 **/

public class HuaWei {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] servers = new int[m];
        for (int i = 0; i < servers.length; i++) {
            servers[i] = in.nextInt();
        }
        int[][] requests = new int[n][2];
        for (int i = 0; i < requests.length; i++) {
            requests[i][0] = in.nextInt();
            requests[i][1] = in.nextInt();
        }
        int max = 0;
        boolean[] flag = new boolean[servers.length];
        Arrays.sort(servers);
        Arrays.sort(requests, (o1, o2) -> o2[1] - o1[1]);
        for (int[] request : requests) {
            int subMax = 0;
            for (int i = 0; i < servers.length; i++) {
                if (request[0] <= servers[i] && !flag[i]) {
                    subMax = request[1];
                    flag[i] = true;
                    break;
                }
            }
            max += subMax;
        }
        System.out.println(max);
    }


    ////////////////

    static int maxValue = Integer.MIN_VALUE;

    public static int maxValue(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE / 2;
        int left = maxValue(root.left);
        int right = maxValue(root.right);
        int max = Math.max(left, right);
        max = Math.max(root.val, max + root.val);
        maxValue = Math.max(maxValue, max);
        return max;
    }

    public static TreeNode buildSubTree(String str, int left, int right) {
        if (left > right) return null;
        int index = left;
        while (index < right && str.charAt(index) != '(') {
            index++;
        }
        if (right > left && str.charAt(index) == '(' && str.charAt(right) == ')') {
            right--;
        }
        int val;
        if (left == index || str.charAt(index) != '(') {
            val = Integer.parseInt(str.substring(left, index + 1));
        } else {
            val = Integer.parseInt(str.substring(left, index));
        }
        TreeNode node = new TreeNode(val);
        index++;
        left = index;
        while (index < right && str.charAt(index) != ',') {
            index++;
        }
        node.left = buildSubTree(str, left, index - 1);
        node.right = buildSubTree(str, index + 1, right);
        return node;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
