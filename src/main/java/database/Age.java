package database;

import java.util.Random;

/**
 * @Author: long
 * @Date: 2020/8/13 10:26
 * @Title
 * @Description:
 */
public class Age {

    static Random random = new Random();

    public static int getAge() {
        int age = random.nextInt(65);
        while (age < 18) {
            age = random.nextInt(65);
        }
        return age;
    }
}
