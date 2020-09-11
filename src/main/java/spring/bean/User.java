package spring.bean;

/**
 * @Author: long
 * @Date: 2020/9/4 15:24
 * @Title
 * @Description:
 */
public class User {

    private int age;
    private String name;


    public int getAge() {
        return age;
    }

    public void initMethod(){
        System.out.println("init");
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
