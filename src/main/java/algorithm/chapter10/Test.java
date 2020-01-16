package algorithm.chapter10;

/**
 * @Author long
 * @Date 17:34 2019/10/18
 * @Title
 * @Description
 **/

public class Test {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.pop();
        stack.print();
    }
}
