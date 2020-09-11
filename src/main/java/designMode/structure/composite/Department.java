package designMode.structure.composite;

/**
 * @Author: long
 * @Date: 2020/8/27 14:53
 * @Title
 * @Description:
 */
public class Department extends OrganizationComponent {


    public Department(String name, String des) {
        super(name, des);
    }

    @Override
    void print() {
        System.out.println(getName());
    }
}
