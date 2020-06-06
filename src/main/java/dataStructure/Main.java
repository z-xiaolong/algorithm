package dataStructure;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author long
 * @Date 2020/5/1 16:43
 * @Title
 * @Description //TODO
 **/

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        AVLTree<Integer> tree = new AVLTree(nums);
        tree.levelOrderTraversal();
        System.out.println();
        if (tree.isCompleteTree()) System.out.println("YES");
        else System.out.println("NO");

    }
}
