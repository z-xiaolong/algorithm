package algorithm.chapter10;

/**
 * @Author long
 * @Date 16:56 2019/10/18
 * @Title
 * @Description 栈
 **/

public class Stack<T> {

    private int length = 0;
    private Node bottom = new Node();
    private Node top = bottom;

    public Stack() {
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void push(T t){
        Node newNode = new Node(t);
        top.next = newNode;
        newNode.prev = top;
        top = newNode;
        length++;
    }

    public T pop(){
        T value = top.value;
        top = top.prev;
        length--;
        return value;
    }

    public int getSize(){
        return length;
    }

    public void print(){
        Node node = top;
        while (node != bottom){
            System.out.println(node);
            node = node.prev;
        }
    }

    private class Node{
        private T value;
        private Node next;
        private Node prev;

        private Node(T value) {
            this.value = value;
        }

        private Node(){}

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

}
