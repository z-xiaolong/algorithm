package dataStructure;

/**
 * @Author: long
 * @Date: 2020/9/13 11:04
 * @Title
 * @Description:
 */
public class SkipList<T extends Comparable<T>> {

    private static final int DEFAULT_LEVEL = 32;
    private final int maxLevel;
    private static final double P = 0.25;

    //跳跃表数据结构
    private final SkipNode<T> head;
    private int high;

    public SkipList() {
        //创建默认初始高度的跳跃表
        this(DEFAULT_LEVEL);
    }

    //跳跃表的初始化
    public SkipList(int high) {
        this.maxLevel = high;
        this.head = new SkipNode<>(null, high);
        this.high = 0;
    }

    // 随机产生节点的高度
    private int getRandomLevel() {
        int h = 0;
        while (Math.random() < P && h < maxLevel)
            h++;
        return h;
    }

    public void add(T val) {
        int h = getRandomLevel();
        SkipNode<T> newNode = new SkipNode<>(val, h);
        SkipNode<T> node = head;
        for (int i = h; i >= 0; i--) {
            node = findLeast(node, i, val);
            if (node.next[i] == null) {
                node.next[i] = newNode;
            } else {
                SkipNode<T> tmp = node.next[i];
                node.next[i] = newNode;
                newNode.next[i] = tmp;
            }
        }
        if (h > this.high) {
            this.high = h;
        }
    }

    //删除节点
    public boolean remove(T val) {
        boolean isExist = false;
        SkipNode<T> node = head;
        for (int i = high; i >= 0; i--) {
            node = findLeast(node, i, val);
            if (node.next[i] != null && node.next[i].val == val) {
                node.next[i] = node.next[i].next[i];
                isExist = true;
            }
        }
        return isExist;
    }

    //查找跳跃表中的一个值
    public boolean search(T val) {
        SkipNode<T> node = head;
        for (int i = high; i >= 0; i--) {
            node = findLeast(node, i, val);
            if (node.next[i] != null && val.compareTo(node.next[i].val) == 0) {
                return true;
            }
        }
        return false;
    }

    private SkipNode<T> findLeast(SkipNode<T> head, int level, T val) {
        while (head.next[level] != null && val.compareTo(head.next[level].val) > 0) {
            head = head.next[level];
        }
        return head;
    }


    private static class SkipNode<T> {
        T val;//存储的数据
        SkipNode<T>[] next;  //next指针

        public SkipNode(T val, int high) {
            this.val = val;
            this.next = new SkipNode[high + 1];
        }
    }
}
