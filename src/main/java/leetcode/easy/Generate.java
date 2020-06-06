package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author long
 * @Date 2020/4/27 11:38
 * @Title 118. 杨辉三角
 * @Description //TODO
 **/

public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>(numRows);
        if(numRows == 0) return output;
        List<Integer> prev = new ArrayList<>(1);
        prev.add(1);
        output.add(prev);
        if (numRows == 1) return output;
        int i = 1;
        while (i < numRows) {
            i++;
            List<Integer> list = new ArrayList<>(i);
            list.add(1);
            for (int j = 0; j < prev.size() - 1; j++) {
                list.add(prev.get(j) + prev.get(j + 1));
            }
            list.add(1);
            output.add(list);
            prev = list;
        }
        return output;
    }
}
