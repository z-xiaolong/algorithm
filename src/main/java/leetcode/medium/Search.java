package leetcode.medium;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/2/23 22:51
 * @Title 33. 搜索旋转排序数组
 * @Description //TODO
 **/

public class Search {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 3};
        Search search = new Search();
        search.search(nums, 5);
    }

    //最佳答案
    public int searchIII(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l + 1) >> 1);
            if (nums[mid] < nums[r]) {
                if (nums[mid] <= target && target <= nums[r]) l = mid;
                else r = mid - 1;
            } else {
                if (nums[l] <= target && target <= nums[mid - 1]) r = mid - 1;
                else l = mid;
            }
        }
        if (nums[l] == target) return l;
        return -1;
    }

    //执行用时 :1 ms, 在所有 Java 提交中击败了72.11%的用户
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (right < 0) {
            return -1;
        }
        while (left <= right) {
            if (nums[left] < nums[right]) {
                return binarySearch(nums, left, right, target);
            }
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] <= nums[right]) {
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    if (target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            } else {
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    if (target >= nums[left]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }


    public int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    //先找最小值，再二分搜索: 执行用时 :1 ms, 在所有 Java 提交中击败了72.11%的用户
    public int searchII(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (right < 0) {
            return -1;
        }
        int min = findMin(nums);
        if (nums[min] == target) {
            return min;
        }
        if (min == 0) {
            return binarySearch(nums, left, right, target);
        }
        if (nums[left] > target) {
            return binarySearch(nums, min, right, target);
        } else {
            return binarySearch(nums, left, min - 1, target);
        }
    }


    public int findMin(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        if (nums[left] < nums[right]) {
            return left;
        }
        while (left < right && nums[left] >= nums[right]) {
            int mid = (left + right) / 2;
            if (nums[left] >= nums[right]) {
                if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                    left++;
                    right--;
                } else if (nums[mid] >= nums[left]) {
                    left = mid + 1;
                } else if (nums[mid] <= nums[right]) {
                    right = mid;
                }
            }
        }
        return left;
    }


    public static int searchI(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (right == -1) {
            return -1;
        }
        if (nums[right] > nums[left]) {
            while (right >= left) {
                int mid = (left + right) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
        if (nums[right] > target) {
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target) {
                    if (nums[mid] < nums[left]) {
                        right = mid;
                    } else if (nums[mid] > nums[right]) {
                        left = mid;
                    }
                } else if (nums[mid] < target) {
                    left = mid;
                } else {
                    return mid;
                }
            }
        } else if (nums[left] < target) {
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    if (nums[mid] < nums[right]) {
                        right = mid;
                    } else if (nums[mid] > nums[right]) {
                        left = mid;
                    }
                } else {
                    return mid;
                }
            }
        } else if (nums[right] == target) {
            return right;
        } else if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
