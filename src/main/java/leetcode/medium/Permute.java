package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 2019/12/29 14:28
 * @Title 46. 全排列
 * @Description 给定一个没有重复数字的序列，返回其所有可能的全排列。
 **/

public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        int amount = (nums.length + 1) * nums.length / 2;
        List<List<Integer>> lists = new ArrayList<>(amount);

        for (int i = 0; i < nums.length; i++) {
            //TODO
        }
        return lists;
    }
}
