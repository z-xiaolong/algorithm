package test;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author long
 * @Date 2021/3/26 20:30
 * @Title
 * @Description CPU 分支预测实验
 * 分支预测就是针对这种 if 指令，不等它执行完毕，
 * 先预测一下执行的结果可能是 true 还是 false，然后将对应条件的指令放进流水线。
 * 一个 if 现在被判为 true，下次，会更高概率的判为 true。
 * CPU 执行步骤：获取指令（fetch），解码指令（decode)，执行指令（execute），写回数据（write-back）
 **/

public class BranchPrediction {
    public static void main(String[] args) {
        int size = 32768;
        int[] data = new int[size];
        Random random = new Random(0);
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt() % 256;
        }


        int i = 0;
        int j = 0;
        j = ++i;
        System.out.println(j);
        test2(data);
        test1(data);
        test4(data);
        test3(data);
    }

    public static void test1(int[] nums) {
        long startTime = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >= 128) {
                    sum += nums[j];
                }
            }
        }
        System.out.println("test1 耗时：" + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("sum=" + sum);
    }

    public static void test2(int[] nums) {
        long startTime = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < 100000; i++) {
            for (int num : nums) {
                if (num >= 128) {
                    sum += num;
                }
            }
        }
        System.out.println("test2 耗时：" + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("sum=" + sum);
    }

    public static void test3(int[] nums) {
        Arrays.sort(nums);
        long startTime = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < 100000; i++) {
            for (int num : nums) {
                if (num >= 128) {
                    sum += num;
                }
            }
        }
        System.out.println("test3 耗时：" + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("sum=" + sum);
    }

    public static void test4(int[] nums) {
        long startTime = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < 100000; i++) {
            for (int num : nums) {
                int t = (num - 128) >> 31;
                sum += ~t & num;
            }
        }
        System.out.println("test4 耗时：" + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("sum=" + sum);
    }
}
