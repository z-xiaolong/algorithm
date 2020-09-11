package designMode.behavior.visitor.demo;

import java.util.Random;

/**
 * @Author: long
 * @Date: 2020/8/31 11:18
 * @Title
 * @Description:
 */
// 经理
public class Manager extends Staff {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // 一年做的产品数量
    public int getProducts() {
        return new Random().nextInt(10);
    }
}
