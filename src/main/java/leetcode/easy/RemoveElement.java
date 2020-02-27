package leetcode.easy;

/**
 * @Author long
 * @Date 2020/2/26 20:06
 * @Title 27. 移除元素
 * @Description 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，
 * 返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 **/

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        RemoveElement removeElement = new RemoveElement();
        removeElement.removeElement(nums, 2);
    }

    //联想到快排的思想，前后双指针
    public int removeElement(int[] nums, int val) {
        int right = nums.length - 1;
        int left = 0;
        while (left <= right) {
            while (left < right && nums[left] != val) {
                left++;
            }
            while (left < right && nums[right] == val) {
                right--;
            }
            if (left == right) {
                if (nums[left] == val) {
                    return left;
                } else {
                    return left + 1;
                }
            }
            nums[left] = nums[right];
            nums[right] = val;
        }
        return left;
    }

    //快慢指针
    public int removeElementI(int[] nums, int val) {
        int idx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }

    //前后双指针，官方解，更加简洁优雅
    public int removeElementII(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
