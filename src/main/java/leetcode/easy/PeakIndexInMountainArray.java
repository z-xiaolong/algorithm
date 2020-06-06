package leetcode.easy;

/**
 * @Author long
 * @Date 2020/5/5 16:02
 * @Title 山脉数组的峰顶索引
 * @Description //TODO
 **/

public class PeakIndexInMountainArray {

    //执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (A[mid] > A[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
