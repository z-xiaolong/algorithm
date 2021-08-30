package DDD.oop.monster;

import DDD.oop.player.Player;
import DDD.oop.weapon.Weapon;

/**
 * @Author long
 * @Date 2021/5/18 12:52
 * @Title
 * @Description //TODO
 **/

public abstract class Monster {


    int health;
    String name;

    public Monster(String name,int health) {
        this.health = health;
        this.name = name;
    }

    public void receiveDamageBy(Weapon weapon, Player player) {
        this.health -= weapon.getDamage(); // 基础规则
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Integer getHealth() {
        return health;
    }
}
