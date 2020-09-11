package designMode.structure.decorator;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: long
 * @Date: 2020/8/26 20:58
 * @Title
 * @Description:
 */
public class CoffeeBar {
    public static void main(String[] args) {

        //点一份LongBlack
        Drink order = new LongBlack();
        System.out.println("费用=" + order.cost());
        System.out.println("描述=" + order.getDes());

        //加入牛奶
        order = new Milk(order);
        System.out.println("加入牛奶费用=" + order.cost());
        System.out.println("加入牛奶描述=" + order.getDes());

        //加巧克力
        order = new Chocolate(order);
        System.out.println("加巧克力费用=" + order.cost());
        System.out.println("加巧克力描述=" + order.getDes());

        //加巧克力
        order = new Chocolate(order);
        order.getDes();
        order.cost();
        System.out.println("再加巧克力费用=" + order.cost());
        System.out.println("再加巧克力描述=" + order.getDes());

        InputStream in = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };
        FilterInputStream stream = new BufferedInputStream(in);
    }
}
