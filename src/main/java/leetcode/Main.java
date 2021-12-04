package leetcode;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[1024];
        Arrays.fill(nums, 1);
        Thread thread1 = new Thread(() -> {
            long start = System.currentTimeMillis();
            Random random = new Random();
            for (int i = 1; i < 10 * 1024 * 1024; i++) {
                nums[0] = random.nextInt(i);
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        });
        Thread thread2 = new Thread(() -> {
            long start = System.currentTimeMillis();
            Random random = new Random();
            for (int i = 1; i < 10 * 1024 * 1024; i++) {
                nums[1] = random.nextInt(i);
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        });
        thread1.start();
        thread2.start();
    }

    public static void main1(String[] args) {
        int n = 128 * 1024 * 1024;
        int[] nums = new int[n];
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i += 32) {
            nums[i] *= i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i += 2) {
            nums[i] *= i;
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] res = new int[2];
        int xor = 0;
        for (int i = 1; i <= n; i++) {
            xor ^= nums[i - 1];
            xor ^= i;
        }
        int i = 0;
        int dup = 1;
        while (i < n) {
            if (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    dup = nums[i];
                    break;
                }
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            } else {
                i++;
            }
        }
        res[0] = dup;
        res[1] = xor ^ dup;
        return res;
    }

    public static int solution(int N, int k, int[] goods) {
        Arrays.sort(goods);
        int index = 0;
        int count = 0;
        int n = goods.length;
        while (index + k <= n) {
            if (goods[index] > 0) {
                goods[index]--;
                for (int i = n - 1; i > n - k; i--) {
                    goods[i]--;
                }
                Arrays.sort(goods);
                count++;
            }
            if (goods[index] == 0) {
                index++;
            }
        }
        return count;
    }
}
