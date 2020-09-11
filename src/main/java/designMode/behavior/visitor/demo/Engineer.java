package designMode.behavior.visitor.demo;

import java.util.Random;

/**
 * @Author: long
 * @Date: 2020/8/31 11:18
 * @Title
 * @Description:
 */
// 工程师
public class Engineer extends Staff {

    public Engineer(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // 工程师一年的代码数量
    public int getCodeLines() {
        return new Random().nextInt(10 * 10000);
    }
}
