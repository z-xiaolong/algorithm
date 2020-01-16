package leetcode.easy;

/**
 * @author long
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,3,4};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++){
            System.out.print(nums[i]+",");
        }
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int k = 0;
        for (int i = 1; i < nums.length; i++){
            if(nums[i] != nums[k]){
                nums[++k] = nums[i];
            }
        }
        return k+1;
    }
}
