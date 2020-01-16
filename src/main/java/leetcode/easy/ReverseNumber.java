package leetcode.easy;

//给出一个 32 位的有符号整数，将这个整数中每位上的数字进行反转。
public class ReverseNumber {

    public static void main(String[] args) {
        int x = 12345;

        System.out.println(x);
        System.out.println(reverseS(x));
        System.out.println(Integer.MAX_VALUE);
    }

    public static int reverse(int x) {
        int length = 0;
        double result = 0;
        String number = Integer.toString(x);
        if(x < 0 ){
            length = number.length() - 2;

        }else {
            length = number.length() - 1;
        }

        while(length >= 0){
            result = result + (x%10)*Math.pow(10,length);
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
                return 0;
            }
            x = x/10;
            length--;
        }
        if(x < 0){
            result = -result;
        }
        return (int)result;
    }

    public static int reverseS(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
