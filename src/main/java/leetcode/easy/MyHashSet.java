package leetcode.easy;


import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Author long
 * @Date 2021/3/13 9:40
 * @Title
 * @Description //TODO
 **/

public class MyHashSet {

    LinkedList<Integer>[] set;
    int mod = 769;

    public MyHashSet() {
        set = new LinkedList[mod];
    }

    public void add(int key) {
        int hash = hash(key);
        if (set[hash] == null) {
            set[hash] = new LinkedList<>();
        }
        if (!contains(key)) {
            set[hash].add(key);
        }
    }

    public void remove(int key) {
        int hash = hash(key);
        if (set[hash] == null) {
            return;
        }
        LinkedList<Integer> list = set[hash];
        for (Integer e : list) {
            if (e == key) {
                list.remove(e);
                return;
            }
        }
    }

    private int hash(int key) {
        return key % mod;
    }

    public boolean contains(int key) {
        int hash = hash(key);
        if (set[hash] == null) {
            return false;
        }
        for (int e : set[hash]) {
            if (key == e) {
                return true;
            }
        }
        return false;
    }
}
