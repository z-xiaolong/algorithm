package leetcode.contest;

import java.util.*;

/**
 * @Author long
 * @Date 2020/3/8 10:16
 * @Title
 * @Description //TODO
 **/

public class Contest179 {

    /**
     * create by long on 2020/3/8
     *
     * @description //5352. 生成每种字符都是奇数个的字符串
     * 给你一个整数 n，请你返回一个含 n 个字符的字符串，
     * 其中每种字符在该字符串中都恰好出现 奇数次 。
     * 返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，
     * 则返回其中任意一个即可。
     */
    public String generateTheString(int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, 'a');
        if (n % 2 == 0) {
            chars[n - 1] = 'b';
        }
        return new String(chars);
    }

    /**
     * create by long on 2020/3/8
     *
     * @description 5353. 灯泡开关 III
     * 房间中有 n 枚灯泡，编号从 1 到 n，自左向右排成一排。最初，所有的灯都是关着的。
     * 在 k  时刻（ k 的取值范围是 0 到 n - 1），我们打开 light[k] 这个灯。
     * 灯的颜色要想 变成蓝色 就必须同时满足下面两个条件：
     * 灯处于打开状态。
     * 排在它之前（左侧）的所有灯也都处于打开状态。
     * 请返回能够让 所有开着的 灯都 变成蓝色 的时刻 数目 。
     */
    public static int numTimesAllBlue(int[] light) {
        int[] nums = new int[light.length + 1];
        int on = 0;
        int off = 1;
        int count = 0;
        for (int value : light) {
            nums[value]++;
            if (value > on) {
                on = value;
            }
            if (value == off) {
                off = on;
                for (int j = 1; j <= on; j++) {
                    if (nums[j] != 1) {
                        off = j;
                        break;
                    }
                }
            }
            if (on == off) {
                count++;
                off++;
            }
        }
        return count;
    }

    /**
     * create by long on 2020/3/8
     *
     * @return
     * @param: null
     * @description 5354. 通知所有员工所需的时间
     */

    //超时
    public int numOfMinutesI(int n, int headID, int[] manager, int[] informTime) {
        if (informTime[headID] == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (manager[i] == headID) {
                int temp = numOfMinutesI(n, i, manager, informTime) + informTime[headID];
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    //执行用时 :130 ms, 在所有 Java 提交中击败了100.00%的用户
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, LinkedList<Integer>> hashMap = new HashMap<>(manager.length);
        for (int i = 0; i < manager.length; i++) {
            LinkedList<Integer> linkedList = hashMap.get(manager[i]);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
            }
            linkedList.add(i);
            hashMap.put(manager[i], linkedList);
        }
        return recursion(headID, informTime, hashMap);
    }

    public int recursion(int headID, int[] informTime, Map<Integer, LinkedList<Integer>> hashMap) {
        if (informTime[headID] == 0) {
            return 0;
        }
        int max = 0;
        LinkedList<Integer> linkedList = hashMap.get(headID);
        for (int num : linkedList) {
            int temp = recursion(num, informTime, hashMap) + informTime[headID];
            max = Math.max(temp, max);
        }
        return max;
    }

    //别人的解法  执行用时 :286 ms, 在所有 Java 提交中击败了100.00%的用户
    public int numOfMinutesII(int n, int headID, int[] manager, int[] informTime) {
        //最终结果
        int res = 0;
        for (int i = 0; i < manager.length; i++) {
            //判断是否为结束点，剪枝
            if (informTime[i] == 0) {
                //临时值
                int temp = 0;
                int index = i;
                //向上遍历
                while (index != -1) {
                    temp += informTime[index];
                    index = manager[index];
                }
                res = Math.max(res, temp);
            }
        }
        return res;
    }


    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (target == 1 && t >= 0) {
            return 1;
        } else if (target == 1 && t < 0) {
            return 0;
        }
        double p = 1;
        int targetIndex = 0;
        double count = 0;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][1] == target || edges[i][0] == target) {
                targetIndex = i;
                break;
            }
        }
        int subTarget = edges[targetIndex][0];
        if (subTarget == target) {
            subTarget = edges[targetIndex][1];
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == subTarget || edges[i][1] == subTarget) {
                count++;
            }
        }

        p = (1 / count) * frogPosition(n, edges, t - 1, subTarget);
        return p;
    }

/*    public double recursion(int index, int n, int[][] edges, int t, int target) {

    }*/


    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 3, 5, 4};
        numTimesAllBlue(nums);
    }
}
