package exam;

import java.util.*;

/**
 * @Author long
 * @Date 2020/3/22 18:50
 * @Title 快手公司题
 * @Description //TODO
 **/

public class QuickHand {

    //1.
    public int[] DistanceToHigher(int[] height) {
        int[] distance = new int[height.length];
        distance[0] = 0;
        for (int i = 1; i < distance.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (height[i] < height[j]) {
                    distance[i] = i - j;
                    break;
                }
            }
        }
        return distance;
    }

    //2.数组寻址
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        int[] nums = new int[strs.length];
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        int max = nums[0];
        int secondMax = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= secondMax && nums[i] < max) {
                res.add(i);
                secondMax = nums[i];
            } else if (nums[i] >= max) {
                secondMax = max;
                max = nums[i];
            }
        }
        if (res.isEmpty()) {
            System.out.print(-1);
        } else {
            for (int i : res) {
                System.out.print(i + " ");
            }
        }
    }*/

    //手机号价值
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(",");
        boolean flag = false;
        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                int res = comparator(strs[i], strs[j]);
                if (res > 0) {
                    String t = strs[i];
                    strs[i] = strs[j];
                    strs[j] = t;
                }
            }
        }
        for (int i = strs.length - 1; i >= 0; i--) {
            if(findOrder(strs[i]) + findDup(strs[i]) > 0){
                if(i != strs.length - 1){
                    System.out.print(",");
                }
                System.out.print(strs[i]);
                flag = true;

            }
        }

        if (!flag) {
            System.out.println("null");
        }
    }


    public static int comparator(String o1, String o2) {
        int order1 = findOrder(o1);
        int order2 = findOrder(o2);
        int dup1 = findDup(o1);
        int dup2 = findDup(o2);
        if (order1 + dup1 == 0 && order2 + dup2 == 0) {
            return 0;
        } else if (order1 == order2 && dup1 == dup2) {
            return 0;
        } else if (order1 + dup1 > order2 + dup2) {
            return 1;
        } else if (order1 + dup1 < order2 + dup2) {
            return -1;
        } else if (order1 + dup1 == order2 + dup2) {
            return dup1 - dup2;
        }
        return 0;
    }


    public static int findOrder(String str) {
        int value = 1;
        int count = 1;
        for (int i = 4; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c - str.charAt(i - 1) == 1) {
                count++;
                value = Math.max(count, value);
            } else {
                count = 0;
            }
        }
        if (value < 3) {
            return 0;
        }
        return value;
    }

    public static int findDup(String str) {
        int value = 1;
        int count = 1;
        for (int i = 4; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == str.charAt(i - 1)) {
                count++;
                value = Math.max(count, value);
            } else {
                count = 0;
            }
        }
        if (value < 3) {
            return 0;
        }
        return value;
    }

    //3.
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String[] str1 = line1.split(" ");
        int n = Integer.parseInt(str1[0]);
        int m = Integer.parseInt(str1[1]);
        int a = Integer.parseInt(str1[2]);
        int b = Integer.parseInt(str1[3]);
        int[][] value = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            String[] v = s.split(" ");
            for (int j = 0; j < m; j++) {
                value[i][j] = Integer.parseInt(v[j]);
            }
        }


    }*/


    //4.


}
