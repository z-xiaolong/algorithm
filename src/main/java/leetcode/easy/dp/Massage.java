package leetcode.easy.dp;

/**
 * @Author long
 * @Date 2020/2/19 11:00
 * @Title 面试题 17.16. 按摩师
 * @Description 一个有名的按摩师会收到源源不断的预约请求，
 * 每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * 注意：本题相对原题稍作改动
 **/

public class Massage {

    //动态规划，f(k) = max(f(k – 2) + A[k] , f(k – 1))
    public int recursion(int[] nums, int max, int index){
        int prevMax = 0;
        int currMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
