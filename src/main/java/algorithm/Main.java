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
        Scanner in = new Scanner(System.in);


        Object o = new Object();
        Object o1 = new Object();
        o.equals(o);
        System.out.println(o.hashCode());
        System.out.println(o1.hashCode());

        HashCodeTest code1 = new HashCodeTest();
        HashCodeTest code2 = new HashCodeTest();
        System.out.println(code1.equals(code2));
        HashMap<HashCodeTest, String> map = new HashMap<>();
        map.put(code1, "f");
        map.put(code2, "code2");
        System.out.println(map.size());
        System.out.println(map.get(code1));
        String str = "fds";
        str.hashCode();
        str.equals("fsdf");
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



