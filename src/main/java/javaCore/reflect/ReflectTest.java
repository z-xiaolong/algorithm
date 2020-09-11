package javaCore.reflect;


/**
 * @Author: long
 * @Date: 2020/9/2 15:38
 * @Title
 * @Description:
 */
public class ReflectTest {
    public static void main(String[] args) {
        Person person = new Person("tom");
        Class personClass = person.getClass();
        Class p = Person.class;
        p.getInterfaces();
    }


    public void test() {
        Person person = new Person("tom");
    }

    static class Person {

        private String name;

        public Person(String name) {
            this.name = name;
        }
    }
}


class outer {

    public void getName() {
        //ReflectTest.Person person = new ReflectTest.Person("tom");

    }
}
