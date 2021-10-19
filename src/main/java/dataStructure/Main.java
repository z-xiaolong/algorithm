package dataStructure;

/**
 * @Author long
 * @Date 2020/5/1 16:43
 * @Title
 * @Description //TODO
 **/

public class Main {

    public static void main(String[] args) {
        SkipList<Integer> skipList = new SkipList<>();
        skipList.add(1);
        skipList.add(2);
        skipList.add(3);
        System.out.println(skipList.search(0));
        skipList.add(4);
        System.out.println(skipList.search(1));
        System.out.println(skipList.remove(0));
        System.out.println(skipList.remove(1));
        System.out.println(skipList.search(1));

    }
}
