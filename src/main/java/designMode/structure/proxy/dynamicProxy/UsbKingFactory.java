package designMode.structure.proxy.dynamicProxy;

/**
 * @Author: long
 * @Date: 2020/8/28 14:40
 * @Title
 * @Description:
 */
public class UsbKingFactory implements UsbSell {

    @Override
    public float sell(int amount) {
        System.out.println("目标类中，执行sell目标方法");
        float price = 3.0f;
        return price * amount;
    }
}
