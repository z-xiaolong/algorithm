package leetcode.medium;

/**
 * @Author long
 * @Date 2021/10/5 18:55
 * @Title
 * @Description //TODO
 **/

public class SkipList {

    private static final int MAX_LEVEL = 31; //最大层数
    private static final double P = 0.25; //随机层数概率

    private final Node head; //头结点

    private int level;

    public SkipList() {
        this.head = new Node(null, MAX_LEVEL);
        level = 0;
    }

    public boolean search(int target) {
        Node node = head;
        int level = this.level;
        while (level >= 0) {
            node = findLeast(node, level, target);
            if (node.next[level] != null && node.next[level].val == target) {
                return true;
            }
            level--;
        }
        return false;
    }

    public void add(int num) {
        int level = randomLevel();
        Node newNode = new Node(num, level);
        Node node = head;
        for (int i = level; i >= 0; i--) {
            node = findLeast(node, i, num);
            if (node.next[i] == null) {
                node.next[i] = newNode;
            } else {
                Node tmp = node.next[i];
                node.next[i] = newNode;
                newNode.next[i] = tmp;
            }
        }
        if (level > this.level) {
            this.level = level;
        }
    }

    //删除节点
    public boolean erase(int num) {
        Node node = head;
        boolean isExist = false;
        for (int i = level; i >= 0; i--) {
            node = findLeast(node, i, num);
            if (node.next[i] != null && node.next[i].val == num) {
                node.next[i] = node.next[i].next[i];
                isExist = true;
            }
        }
        return isExist;
    }

    private Node findLeast(Node head, int level, int val) {
        while (head.next[level] != null && head.next[level].val < val) {
            head = head.next[level];
        }
        return head;
    }

    //随机返回一个层数
    private int randomLevel() {
        int level = 0;
        while (Math.random() < P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    class Node {
        Integer val;
        Node[] next;

        public Node(Integer val, int high) {
            this.val = val;
            next = new Node[high + 1];
        }
    }

}
