package DDD.oop.player;

import DDD.oop.monster.Monster;
import DDD.oop.weapon.Weapon;
import lombok.Data;

/**
 * @Author long
 * @Date 2021/5/18 12:01
 * @Title
 * @Description //TODO
 **/
@Data
public abstract class Player {

    String name;
    Weapon weapon;

    public Player(String name) {
        this.name = name;
    }

    public void attack(Monster monster) {
        monster.receiveDamageBy(weapon, this);
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
