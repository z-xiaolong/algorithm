package algorithm.chapter10;

/**
 * @Author long
 * @Date 17:34 2019/10/18
 * @Title
 * @Description
 **/

public class Test {
    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("a");
        myStack.push("b");
        myStack.push("c");
        myStack.push("d");
        myStack.push("e");
        myStack.pop();
        myStack.print();
    }
}
