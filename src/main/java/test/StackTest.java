package test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author long
 * @Date 16:55 2019/11/2
 * @Title
 * @Description
 **/

public class StackTest {
    private static int count = 0;

    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.get(2);

        recursion();
    }

    public static void recursion() {
        count++;
        try {
            recursion();
        } catch (StackOverflowError error) {
            System.out.println(count);
        }

    }
}
