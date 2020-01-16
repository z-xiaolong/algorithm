package leetcode.easy;

/**
 * @author long
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(height));
    }
    public  static int maxArea1(int[] height) {
        int result = 0;
        int length = height.length;
        for (int tail = length - 1; tail >= 0; tail--){
            for (int head = 0; head < tail; head++){
                int k = min(height[head],height[tail])*(tail-head);
                if (k > result){
                    result = k;
                }
            }
        }
        return result;
    }

    public static int min(int num1, int num2){
        return num1 > num2 ? num2 : num1;
    }

    public static int maxArea2(int[] height){
        int result = 0;
        int i = 0;
        int j = height.length - 1;
        int k;
        while (i < j){
            if(height[i] > height[j]){
                k = height[j]*(j-i);
                result = Math.max(k, result);
                j--;
            }
            else{
                k = height[i]*(j-i);
                result = Math.max(k, result);
                i++;
            }
        }
        return result;
    }
}
