package leetcode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author long
 * @Date 2021/3/23 10:15
 * @Title
 * @Description //TODO
 **/

public class NestedIterator implements Iterator<Integer> {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for(int i=0 ;i<list.size();i++){
            if (i==2) {
                list.remove(i);
            }
        }
        System.out.println(list);  //[1, 2, 4]

        list.clear();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);



        for (Integer integer : list) {
            if (integer==1) {
                list.remove(integer); //这个地方会报错
            }
        }
        System.out.println(list);
    }

    private final LinkedList<Iterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<>();
        stack.iterator();
        stack.add(nestedList.iterator());
    }


    @Override
    public Integer next() {
        return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                continue;
            }
            NestedInteger num = iterator.next();
            if (num.isInteger()) {
                List<NestedInteger> list = new ArrayList<>();
                list.add(num);
                stack.push(list.iterator());
                return true;
            }
            stack.push(num.getList().iterator());
        }
        return false;
    }


}
