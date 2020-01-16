package algorithm.chapter4;


/**
 * @author long
 */
//最大子数组问题,时间复杂度：nlgn
public class MaximumSubArray {

    public static void main(String[] args) {
        //int[] array = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] array = {-66, -1, -5, -5, -20};
        SubArray subArray = findMaximumSubArray(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = subArray.low; i <= subArray.high; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("sum:" + subArray.sum + " low:" + subArray.low + " high:" + subArray.high);
    }


    public static SubArray findMaximumSubArray(int[] array, int low, int high) {
        SubArray sub = new SubArray();
        if (low == high) {
            sub.low = sub.high = low;
            sub.sum = array[low];
            return sub;
        }
        int mid = (low + high) / 2;
        SubArray leftSubArray = findMaximumSubArray(array, low, mid);
        SubArray rightSubArray = findMaximumSubArray(array, mid + 1, high);
        SubArray midSubArray = findCrossSubArray(array, low, high);
        if (leftSubArray.sum >= rightSubArray.sum && leftSubArray.sum >= midSubArray.sum) {
            return leftSubArray;
        } else if (rightSubArray.sum >= leftSubArray.sum && rightSubArray.sum >= midSubArray.sum) {
            return rightSubArray;
        } else {
            return midSubArray;
        }
    }


    public static SubArray findCrossSubArray(int[] array, int low, int high) {
        SubArray sub = new SubArray();
        int mid = (low + high) / 2;
        sub.low = sub.high = mid;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum = sum + array[i];
            if (sub.sum < sum) {
                sub.sum = sum;
                sub.low = i;
            }
        }
        sum = sub.sum;
        for (int j = mid + 1; j <= high; j++) {
            sum = sum + array[j];
            if (sub.sum < sum) {
                sub.sum = sum;
                sub.high = j;
            }
        }
        return sub;
    }

}


class SubArray {
    public int low = 0;
    public int high = 0;
    public int sum = Integer.MIN_VALUE;  //负无穷大，需要考虑全是负数的情况，不能设置为0
}