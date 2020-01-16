package algorithm.chapter10;

/**
 * @Author long
 * @Date 20:19 2019/10/19
 * @Title
 * @Description
 **/

public class LinkedList<E> {
    private LinkedNode head = new LinkedNode();


    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        LinkedList<Integer> linkedList = new LinkedList<>(nums);
        linkedList.print();
        linkedList.linkedReversal();
        linkedList.print();

    }

    public LinkedList(E[] nums) {
        LinkedNode node = head;
        for (E e : nums) {
            LinkedNode newNode = new LinkedNode(e);
            node.next = newNode;
            node = newNode;
        }
    }

    public void print() {
        System.out.println();
        LinkedNode node = head.next;
        while (node != null) {
            System.out.print(node.value);
            node = node.next;
            if (node != null) {
                System.out.print("->");
            }
        }
    }

    public void linkedReversal() {
        if (head.next == null) {
            return;
        }
        LinkedNode node = head.next;
        LinkedNode prev = null;
        LinkedNode next = head.next.next;
        while (next != null) {
            node.next = prev;
            prev = node;
            node = next;
            next = next.next;
        }
        node.next = prev;
        head.next = node;
    }

    private class LinkedNode {
        E value;
        LinkedNode next;

        public LinkedNode(E value) {
            this.value = value;
        }

        private LinkedNode() {
        }

        @Override
        public String toString() {
            return "LinkedNode{" +
                    "value=" + value +
                    '}';
        }
    }
}
