package designMode.structure.decorator;

/**
 * @Author: long
 * @Date: 2020/8/26 20:55
 * @Title
 * @Description:
 */
public class Chocolate extends Decorator {

    public Chocolate(Drink drink) {
        super(drink);
        setDes("巧克力");
        setPrice(3.0f);//调味品价格
    }
}
