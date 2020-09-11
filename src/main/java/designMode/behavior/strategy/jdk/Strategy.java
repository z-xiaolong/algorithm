package designMode.behavior.strategy.jdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: long
 * @Date: 2020/9/2 11:32
 * @Title
 * @Description:
 */
public class Strategy {

    public static void main(String[] args) {
        Integer[] data = new Integer[]{4, 3, 6, 1, 7, 8, 3, 1, 0, 9};

        Comparator comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        //Arrays.sort(data);
        Arrays.sort(data, comparator);
        System.out.println(Arrays.toString(data));
    }
}
