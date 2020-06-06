package exam;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author long
 * @Date 2020/3/29 20:01
 * @Title
 * @Description //TODO
 **/

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            System.out.print(in.nextInt());
        }

    }

    public static void operate(Stack<Integer> prevStack, Stack<Integer> nextStack, String str) {
        if (str.contains("add")) {
            int num = Integer.parseInt(str.split(" ")[1]);
            prevStack.push(num);
        } else if (str.contains("peek")) {
            if (nextStack.isEmpty()) {
                while (!prevStack.isEmpty()) {
                    nextStack.push(prevStack.pop());
                }
            }
            System.out.println(nextStack.peek());
        } else if (str.contains("poll")) {
            if (nextStack.isEmpty()) {
                while (!prevStack.isEmpty()) {
                    nextStack.push(prevStack.pop());
                }
            }
            nextStack.pop();
        }
    }


}
