package leetcode.swordOffer.medium;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author long
 * @Date 2020/3/21 9:22
 * @Title 365. 水壶问题
 * @Description //TODO
 **/

public class CanMeasureWater {

    public static void main(String[] args) {
        //System.out.println(canMeasureWater(22003, 31237, 1));

    }

    //数学，最大公约数
    //贝祖定理: ax+by=z 有解当且仅当 z 是 x, y的最大公约数的倍数。
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        return z % gcd(x, y) == 0;
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    //超时
    public static boolean canMeasureWaterI(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x + y == z || z == 0) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        set.add(x);
        set.add(y);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int num = queue.poll();
                List<Integer> list = new ArrayList<>();
                for (int n : set) {
                    int abs = Math.abs(n - num);
                    if (abs > 0 && !set.contains(abs)) {
                        queue.add(abs);
                        list.add(abs);
                    }
                    int sum = num + n;
                    if (sum < x + y && !set.contains(sum)) {
                        queue.add(sum);
                        list.add(sum);
                    }
                }
                set.addAll(list);
                size--;
            }
        }
        for (int n : set) {
            if (n == z) {
                return true;
            }
        }
        return false;
    }
}
