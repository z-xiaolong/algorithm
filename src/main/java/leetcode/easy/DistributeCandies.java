package leetcode.easy;

/**
 * @Author long
 * @Date 2020/3/5 11:23
 * @Title 1103. 分糖果 II
 * @Description //TODO
 **/

public class DistributeCandies {
    public static void main(String[] args) {
        distributeCandies(7, 4);
    }

    public static int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int index = 0;
        while (candies > 0) {
            ans[index % num_people] += Math.min(candies, index + 1);
            candies -= Math.min(candies, index + 1);
            index++;
        }
        return ans;
    }

    public int[] distributeCandiesI(int candies, int num_people) {
        int[] ans = new int[num_people];
        int index = 0;
        int currentCandy = 1;
        while (candies > 0) {
            if (index >= num_people) {
                index = 0;
            }
            if (candies - currentCandy < 0) {
                currentCandy = candies;
            }
            ans[index] += currentCandy;
            candies -= currentCandy;
            index++;
            currentCandy++;
        }
        return ans;
    }
}
