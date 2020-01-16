package leetcode.easy;

/**
 * @Author long
 * @Date 21:28 2019/10/17
 * @Title 136.只出现一次的数字
 * @Description 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 如果我们对 0 和二进制位做 XOR 运算，得到的仍然是这个二进制位
 * a⊕0=a
 * 如果我们对相同的二进制位做 XOR 运算，返回的结果是 0
 * a⊕a=0
 * XOR 满足交换律和结合律
 * a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
 * 所以我们只需要将所有的数进行 XOR 操作，得到那个唯一的数字。
 * 异或操作
 **/

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    /*给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。*/
    public int singleNumberII(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for (int num : nums) {
            twos |= ones & num; //二进制某位出现1次时twos = 0，出现2, 3次时twos = 1；
            ones ^= num;  //二进制某位出现2次时ones = 0，出现1, 3次时ones = 1；
            threes = ones & twos; //二进制某位出现3次时（即twos = ones = 1时）three = 1，其余即出现1, 2次时three = 0；
            ones &= ~threes; //将二进制下出现3次的位置零，实现`三进制下不考虑进位的加法；
            twos &= ~threes;
        }
        return ones;
    }
}
