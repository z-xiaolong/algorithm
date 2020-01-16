package leetcode.easy;

/**
 * @author long
 */
public class Palindrome {

    public static void main(String[] args) {
        int x = 12331;
        System.out.println(isPalindrome(x));
    }
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int result = 0;
        int temp = x;
        while(temp != 0){
            int pop = temp%10;
            temp = temp/10;
            result = result*10 + pop;
        }
        if(result == x){
            return true;
        }
        return false;
    }
}
