package javaCore.multithread;

/**
 * @Author long
 * @Date 2020/3/15 21:00
 * @Title
 * @Description //TODO
 **/

//仓库类
public class Storage {
    private Product[] products = new Product[10];
    private int top = 0;

    public synchronized void push(Product product) {
        while (top == products.length) {
            try {
                System.out.println("仓库已满，请等待！");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products[top++] = product;
        System.out.println(Thread.currentThread().getName() + "生产了产品：" + product);
        notifyAll();
    }

    public synchronized Product pop() {
        while (top == 0) {
            try {
                System.out.println("仓库空，请等待！");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        top--;
        Product p = new Product(products[top].getId(), products[top].getName());
        products[top] = null;
        System.out.println(Thread.currentThread().getName() + "消费了产品" + p);
        notifyAll();
        return p;
    }


}
