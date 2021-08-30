package dataStructure;

import java.util.Random;

/**
 * @Author: long
 * @Date: 2020/9/13 11:04
 * @Title
 * @Description:
 */
public class SkipList<T extends Comparable<? super T>> {

    private static final int MAX_LEVEL = 1 << 6;


    //跳跃表数据结构
    private SkipNode<T> top;
    private int level = 0;
    //用于产生随机数的Random对象
    private Random random = new Random();

    public SkipList() {
        //创建默认初始高度的跳跃表
        this(4);
    }

    //跳跃表的初始化
    public SkipList(int level) {
        this.level = level;
        int i = level;
        SkipNode<T> temp = null;
        SkipNode<T> prev = null;
        while (i-- != 0) {
            temp = new SkipNode<T>(null, Double.MIN_VALUE);
            temp.down = prev;
            prev = temp;
        }
        top = temp;//头节点
    }

    /**
     * 产生节点的高度。使用抛硬币
     *
     * @return
     */
    private int getRandomLevel() {
        int lev = 1;
        while (random.nextInt() % 2 == 0)
            lev++;
        return Math.min(lev, MAX_LEVEL);
    }


    /**
     * 查找跳跃表中的一个值
     *
     * @param score
     * @return
     */
    public T get(double score) {
        SkipNode<T> t = top;
        while (t != null) {
            if (t.score == score)
                return t.val;
            if (t.next == null) {
                if (t.down != null) {
                    t = t.down;
                    continue;
                } else
                    return null;
            }
            if (t.next.score > score) {
                t = t.down;
            } else
                t = t.next;
        }
        return null;
    }


    private static class SkipNode<E> {
        E val;//存储的数据
        double score;//跳跃表按照这个分数值进行从小到大排序。
        SkipNode<E> next;  //next指针
        SkipNode<E> down; //指向下一层的指针

        SkipNode() {
        }

        SkipNode(E val, double score) {
            this.val = val;
            this.score = score;
        }
    }
}
