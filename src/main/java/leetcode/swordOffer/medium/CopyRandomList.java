package leetcode.swordOffer.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/3/6 20:38
 * @Title 面试题35. 复杂链表的复制
 * @Description //TODO
 **/

public class CopyRandomList {


    //Hash 优化: 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    HashMap<Node, Node> hashMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp != null) {
            Node node = temp;
            Node copy = copyNode(node);
            copy.next = copyNode(node.next);
            copy.random = copyNode(node.random);
            temp = temp.next;
        }
        return hashMap.get(head);
    }

    public Node copyNode(Node node) {
        if (node == null) {
            return null;
        }
        Node copy = hashMap.get(node);
        if (copy == null) {
            copy = new Node(node.val);
            hashMap.put(node, copy);
        }
        return copy;
    }


    //Hash: 执行用时 :1 ms, 在所有 Java 提交中击败了27.24%的用户
    public Node copyRandomListI(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> hashMap = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            Node node = temp;
            Node copy = new Node(node.val);
            hashMap.put(node, copy);
            temp = temp.next;
        }
        for (Map.Entry<Node, Node> node : hashMap.entrySet()) {
            Node key = node.getKey();
            Node value = node.getValue();
            value.next = hashMap.get(key.next);
            value.random = hashMap.get(key.random);
        }
        temp = hashMap.get(head);
        return temp;
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
