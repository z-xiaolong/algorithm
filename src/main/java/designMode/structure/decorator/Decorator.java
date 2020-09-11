package designMode.structure.decorator;

/**
 * @Author: long
 * @Date: 2020/8/26 20:51
 * @Title
 * @Description:
 */
public class Decorator extends Drink {
    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        return super.getPrice() + drink.cost();
    }

    @Override
    public String getDes() {
        return super.getDes() + " " + super.getPrice() + "&&" + drink.getDes();
    }
}
