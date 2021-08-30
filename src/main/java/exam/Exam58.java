package exam;

import leetcode.entity.TreeNode;

import java.util.*;

/**
 * @Author: long
 * @Date: 2020/9/14 20:39
 * @Title
 * @Description:
 */
public class Exam58 {


    static int count = 0;

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
            }
        }
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !flag[i][j]) {
                    dfs(map, flag, i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(int[][] map, boolean[][] flag, int i, int j) {
        int m = map.length;
        int n = map[0].length;
        flag[i][j] = true;
        if (i + 1 < m && !flag[i + 1][j] && map[i + 1][j] == 1) {
            dfs(map, flag, i + 1, j);
        }
        if (j + 1 < n && !flag[i][j + 1] && map[i][j + 1] == 1) {
            dfs(map, flag, i, j + 1);
        }
        if (j - 1 >= 0 && !flag[i][j - 1] && map[i][j - 1] == 1) {
            dfs(map, flag, i, j - 1);
        }
        if (i - 1 >= 0 && !flag[i - 1][j] && map[i - 1][j] == 1) {
            dfs(map, flag, i - 1, j);
        }
    }


    public ArrayList<ArrayList<Integer>> printNode(TreeNode node) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode temp = queue.poll();
                assert temp != null;
                list.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
                size--;
            }
            output.add(list);
        }
        return output;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 4, 4};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) return i;
        }
        return n + 1;
    }
}
