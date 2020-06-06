package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/5/10 10:15
 * @Title 1431. 拥有最多糖果的孩子
 * @Description //TODO
 **/

public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        List<Boolean> res = new ArrayList<>(candies.length);
        for (int candy : candies) {
            if (candy + extraCandies >= max) res.add(true);
            else res.add(false);
        }
        return res;
    }


    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}
