package designMode.structure.decorator;

/**
 * @Author: long
 * @Date: 2020/8/26 20:57
 * @Title
 * @Description:
 */
public class Soy extends Decorator {
    public Soy(Drink drink) {
        super(drink);
        setDes("豆浆");
        setPrice(1.5f);
    }
}
