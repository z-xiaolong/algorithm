package leetcode.medium;

import java.util.Iterator;

/**
 * @Author long
 * @Date 2021/10/5 16:10
 * @Title
 * @Description //TODO
 **/

class PeekingIterator implements Iterator<Integer> {

    private Integer nextElement;
    private final Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.nextElement = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer tmp = nextElement;
        if (iterator.hasNext())
            nextElement = iterator.next();
        else
            nextElement = null;
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }
}