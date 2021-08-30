package DDD.oop;

import DDD.oop.monster.Dragon;
import DDD.oop.monster.Orc;
import DDD.oop.player.Dragoon;
import DDD.oop.player.Fighter;
import DDD.oop.player.Mage;
import DDD.oop.weapon.Staff;
import DDD.oop.weapon.Sword;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


/**
 * @Author long
 * @Date 2021/5/18 13:07
 * @Title
 * @Description //TODO
 **/

public class BattleTest {
    @Test
    @DisplayName("Dragon is immune to attacks")
    public void testDragonImmunity() {
        // Given
        Fighter fighter = new Fighter("Hero");
        Sword sword = new Sword("Excalibur", 10, 0);
        fighter.setWeapon(sword);
        Dragon dragon = new Dragon("Dragon", 100);

        // When
        fighter.attack(dragon);

        // Then
        assertThat(dragon.getHealth()).isEqualTo(100);
    }


    @Test
    @DisplayName("Dragoon attack dragon doubles damage")
    public void testDragoonSpecial() {
        // Given
        Dragoon dragoon = new Dragoon("Dragoon");
        Sword sword = new Sword("Excalibur", 10, 0);
        dragoon.setWeapon(sword);
        Dragon dragon = new Dragon("Dragon", 100);

        // When
        dragoon.attack(dragon);

        // Then
        assertThat(dragon.getHealth()).isEqualTo(100 - 10 * 2);
    }

    @Test
    @DisplayName("Orc should receive half damage from physical weapons")
    public void testFighterOrc() {
        // Given
        Fighter fighter = new Fighter("Hero");
        Sword sword = new Sword("Excalibur", 10, 0);
        fighter.setWeapon(sword);
        Orc orc = new Orc("Orc", 100);

        // When
        fighter.attack(orc);

        // Then
        assertThat(orc.getHealth()).isEqualTo(100 - 10 / 2);
    }

    @Test
    @DisplayName("Orc receive full damage from magic attacks")
    public void testMageOrc() {
        // Given
        Mage mage = new Mage("Mage"); //法师
        Staff staff = new Staff("Fire Staff", 10, 1); //法杖
        mage.setWeapon(staff);
        Orc orc = new Orc("Orc", 100);

        // When
        mage.attack(orc);

        // Then
        assertThat(orc.getHealth()).isEqualTo(100 - 10);
    }
}
