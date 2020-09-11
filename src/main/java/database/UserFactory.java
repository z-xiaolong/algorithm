package database;

import java.util.Random;

/**
 * @Author: long
 * @Date: 2020/8/13 10:00
 * @Title
 * @Description:
 */
public class UserFactory {

    public static User getUser() {
        String name = Names.getName();
        String email = Email.getEmail(5, 30);
        String phone = Phone.getTelephone();
        String job = Job.getJob();
        String address = Address.getAddress();
        int age = Age.getAge();
        int sex = getNum(0, 1);
        return new User(age, sex, name, address, email, job, phone);
    }


    public static int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }
}
