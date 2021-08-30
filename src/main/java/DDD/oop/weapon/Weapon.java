package DDD.oop.weapon;

import lombok.Data;

/**
 * @Author long
 * @Date 2021/5/18 12:01
 * @Title
 * @Description //TODO
 **/
@Data
public abstract class Weapon {
    int damage;
    int damageType; //物理类型（0），火（1），冰（2）
    String name;

    public Weapon(String name, int damage, int damageType) {
        this.damage = damage;
        this.name = name;
        this.damageType = damageType;
    }
}
