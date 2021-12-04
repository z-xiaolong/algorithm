package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 2021/10/22 10:30
 * @Title
 * @Description //TODO
 **/

public class MajorityElement {

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int e1 = 0;
        int e2 = 0;
        int vote1 = 0;
        int vote2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == e1) {
                vote1++;
            } else if (vote2 > 0 && num == e2) {
                vote2++;
            } else if (vote1 == 0) {
                e1 = num;
                vote1++;
            } else if (vote2 == 0) {
                e2 = num;
                vote2++;
            } else {
                vote1--;
                vote2--;
            }
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : nums) {
            if (e1 == num) cnt1++;
            if (e2 == num) cnt2++;
        }
        List<Integer> ans = new ArrayList<>();
        if (cnt1 > n / 3) ans.add(e1);
        if (cnt2 > n / 3 && e1 != e2) ans.add(e2);
        return ans;
    }
}
