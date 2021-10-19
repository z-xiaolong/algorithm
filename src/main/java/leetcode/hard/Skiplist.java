package leetcode.hard;

/**
 * @Author long
 * @Date 2021/10/5 16:28
 * @Title
 * @Description //TODO
 **/

public class Skiplist {

    private static final double DEFAULT_P_FACTOR = 0.25; //随机层数概率
    private static final int DEFAULT_MAX_LEVEL = 32; //最大层数

    private final Node head; //头结点

    private int currentLevel = 1; //表示当前nodes的实际层数，从1开始

    public Skiplist() {
        this.head = new Node(null, DEFAULT_MAX_LEVEL);
    }

    //随机返回一个层数
    private int randomLevel() {
        int level = 1;
        while (Math.random() < DEFAULT_P_FACTOR && level < DEFAULT_MAX_LEVEL) {
            level++;
        }
        return level;
    }

    // 返回target是否存在于跳表中
    public boolean search(int target) {
        Node node = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            node = findClosest(node, i, target);
            if (node.next[i] != null && node.next[i].value == target) {
                return true;
            }
        }
        return false;
    }

    //找到 level 层 value 大于 node.value
    private Node findClosest(Node node, int level, int value) {
        while (node.next[level] != null && value > node.next[level].value) {
            node = node.next[level];
        }
        return node;
    }

    //插入一个元素到跳表
    public void add(int num) {
        int level = randomLevel();
        Node updateNode = head;
        Node newNode = new Node(num, level);
        //计算出当前num索引的实际层数，从该层开始添加索引
        for (int i = level - 1; i >= 0; i--) {
            //从上到下，找到当前层最近离num最近的节点
            updateNode = findClosest(updateNode, i, num);
            if (updateNode.next[i] == null) {
                updateNode.next[i] = newNode;
            } else {
                Node temp = updateNode.next[i];
                updateNode.next[i] = newNode;
                newNode.next[i] = temp;
            }
        }
        //如果随机层数比当前层数大，那么超过currentLevel的head直接指向newNode
        if (level > currentLevel) {
            currentLevel = level;
        }
    }

    //在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。
    public boolean erase(int num) {
        boolean flag = false;
        Node searchNode = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            //找到该层中该节点的前置节点
            searchNode = findClosest(searchNode, i, num);
            if (searchNode.next[i] != null && searchNode.next[i].value == num) {
                searchNode.next[i] = searchNode.next[i].next[i];
                flag = true;
            }
        }
        return flag;
    }


    static class Node {
        Integer value; //节点值
        Node[] next; // 节点在不同层的下一个节点

        public Node(Integer value, int size) { // 用size表示当前节点在跳表中索引几层
            this.value = value;
            this.next = new Node[size];
        }
    }
}
