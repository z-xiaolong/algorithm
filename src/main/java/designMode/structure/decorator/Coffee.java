package designMode.structure.decorator;

/**
 * @Author: long
 * @Date: 2020/8/26 20:48
 * @Title
 * @Description:
 */
public class Coffee extends Drink {


    @Override
    public float cost() {
        return super.getPrice();
    }
}
