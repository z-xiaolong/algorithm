package designMode.structure.decorator;

/**
 * @Author: long
 * @Date: 2020/8/26 20:57
 * @Title
 * @Description:
 */
public class Milk extends Decorator{

    public Milk(Drink drink) {
        super(drink);
        setDes("牛奶");
        setPrice(2.0f);
    }
}
