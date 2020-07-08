package leetcode.easy;

/**
 * @Author long
 * @Date 2020/7/8 9:43
 * @Title 1114. 按序打印
 * @Description //TODO
 **/

public class Foo {

    private volatile int cnt = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        cnt++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (cnt != 1) {

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        cnt++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (cnt != 2) {

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();

    }
}
