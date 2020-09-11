package spring.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: long
 * @Date: 2020/9/4 15:54
 * @Title
 * @Description:
 */
public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        return new User(18, "Long");
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
