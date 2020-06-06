package leetcode.hard;

/**
 * @Author long
 * @Date 2020/4/29 9:50
 * @Title 1095. 山脉数组中查找目标值
 * @Description //TODO
 **/

public class FindInMountainArray {

    public static void main(String[] args) {
        FindInMountainArray array = new FindInMountainArray();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int right = mountainArr.length() - 1;
        int left = 0;
        int peak = findPeak(mountainArr, left, right);
        if (mountainArr.get(left) <= target) {
            int index = binarySearch(mountainArr, target, left, peak);
            if (index >= 0) return index;
        }
        if (mountainArr.get(right) <= target) {
            int index = binarySearchReverse(mountainArr, target, peak, right);
            if (index >= 0) return index;
        }
        return -1;
    }

    public int findPeak(MountainArray mountainArr, int left, int right) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            int a = mountainArr.get(mid);
            int b = mountainArr.get(mid + 1);
            if (a > b) {
                right = mid;
            } else if (a < b) {
                left = mid + 1;
            }
        }
        return left;
    }

    public int binarySearchReverse(MountainArray mountainArray, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            int midValue = mountainArray.get(mid);
            if (target == midValue) {
                return mid;
            } else if (target < midValue) {
                left = mid + 1;
            } else if (target > midValue) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearch(MountainArray mountainArray, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            int midValue = mountainArray.get(mid);
            if (target == midValue) {
                return mid;
            } else if (target > midValue) {
                left = mid + 1;
            } else if (target < midValue) {
                right = mid - 1;
            }
        }
        return -1;
    }


    //超时
    public int findIndex(MountainArray mountainArray, int target, int left, int right) {
        if (left > right) return -1;
        if (left == right) {
            int value = mountainArray.get(left);
            if (value == target) return left;
            else return -1;
        }
        int mid = (left + right) >> 1;
        int leftValue = mountainArray.get(left);
        if (leftValue == target) return left;
        int midValue = mountainArray.get(mid);
        if (midValue == target) {
            if (leftValue < target) {
                int index = findIndex(mountainArray, target, left, mid - 1);
                if (index >= 0) return index;
                else return mid;
            }
        }

        if (leftValue < target) {
            if (midValue > target) {
                int index = binarySearch(mountainArray, target, left + 1, mid - 1);
                if (index >= 0) return index;
            }
            int index = findIndex(mountainArray, target, left + 1, mid - 1);
            if (index >= 0) return index;
        } else if (midValue < target) {
            int index = findIndex(mountainArray, target, left + 1, mid - 1);
            if (index >= 0) return index;
        }

        int rightValue = mountainArray.get(right);
        if (midValue > target && rightValue < target) {
            int index = binarySearchReverse(mountainArray, target, mid + 1, right - 1);
            if (index >= 0) return index;
        } else if (midValue < target) {
            int index = findIndex(mountainArray, target, mid + 1, right - 1);
            if (index >= 0) return index;
        }
        if (rightValue == target) return right;
        return -1;
    }




    interface MountainArray {
        public int get(int index);

        public int length();
    }
}
