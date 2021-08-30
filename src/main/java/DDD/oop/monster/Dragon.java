package DDD.oop.monster;

import DDD.oop.player.Dragoon;
import DDD.oop.player.Player;
import DDD.oop.weapon.Weapon;

/**
 * @Author long
 * @Date 2021/5/18 12:55
 * @Title
 * @Description //TODO
 **/

public class Dragon extends Monster {
    public Dragon(String name, int health) {
        super(name, health);
    }

    @Override
    public void receiveDamageBy(Weapon weapon, Player player) {
        if (player instanceof Dragoon) {
            this.setHealth(this.getHealth() - weapon.getDamage() * 2); // 龙骑伤害规则
        }
        // else no damage, 龙免疫力规则
    }
}
