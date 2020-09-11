package leetcode.easy;

/**
 * @Author: long
 * @Date: 2020/7/30 10:05
 * @Title 面试题 05.06. 整数转换
 * @Description:
 */
public class ConvertInteger {


    public static void main(String[] args) {
        ConvertInteger convert = new ConvertInteger();
        convert.convertInteger(-25,15);
    }

    public int convertInteger(int A, int B) {
        int count = 0;
        while(A != 0 || B != 0){
            if(((A ^ B) & 1) == 1){
                count++;
            }
            if(A != 0) A = A >>> 1;
            if(B != 0) B = B >>> 1;
        }
        return count;
    }

}
