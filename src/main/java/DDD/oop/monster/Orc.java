package DDD.oop.monster;

import DDD.oop.player.Player;
import DDD.oop.weapon.Weapon;

/**
 * @Author long
 * @Date 2021/5/18 12:53
 * @Title
 * @Description //兽人
 **/

public class Orc extends Monster {

    public Orc(String name, int health) {
        super(name, health);
    }

    @Override
    public void receiveDamageBy(Weapon weapon, Player player) {
        if (weapon.getDamageType() == 0) {
            this.setHealth(this.getHealth() - weapon.getDamage() / 2); // Orc的物理防御规则
        } else {
            super.receiveDamageBy(weapon, player);
        }
    }
}
