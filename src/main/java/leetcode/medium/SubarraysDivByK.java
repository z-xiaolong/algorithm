package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/5/15 11:31
 * @Title 974. 和可被 K 整除的子数组
 * @Description //TODO
 **/

public class SubarraysDivByK {

    public static void main(String[] args) {
        System.out.println(-6 % 5);
    }

    public int subarraysDivByK(int[] A, int K) {
        int[] map = new int[K];
        map[0] = 1;
        int count = 0;
        int sum = 0;
        for (int num : A) {
            sum += num;
            int mod = (sum % K + K) % K;
            count += map[mod];
            map[mod]++;
        }
        return count;
    }

    public int subarraysDivByKI(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            int mod = sum % K;
            if (map.containsKey(mod)) {
                count += map.get(mod);
            }
            if (mod > 0 && map.containsKey(mod - K)) {
                count += map.get(mod - K);
            }
            if (mod < 0 && map.containsKey(mod + K)) {
                count += map.get(mod + K);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return count;
    }
}
