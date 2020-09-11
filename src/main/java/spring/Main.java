package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.bean.User;

/**
 * @Author: long
 * @Date: 2020/9/4 10:59
 * @Title
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/bean.xml");
        User user = (User) context.getBean("user");
        System.out.println(user);

        User user1 = context.getBean("userFactory", User.class);

        user.setAge(40);
        User user2 = (User) context.getBean("user");
        System.out.println(user2);
        System.out.println(user == user2);
        System.out.println(user1);
    }

}



