package algorithm;

/**
 * @Author: long
 * @Date: 2020/8/19 19:50
 * @Title
 * @Description:
 */

import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int num = Integer.MAX_VALUE; //11
        System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        int bit = 30;
        while ((num & (1 << bit)) == 0) bit--;
        num = num ^ (1<<(bit + 1));
        System.out.println(num);
        System.out.println(Integer.toBinaryString(num));
    }
}



/*
1995265320
746292446
false
*/

class HashCodeTest {

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }
}



