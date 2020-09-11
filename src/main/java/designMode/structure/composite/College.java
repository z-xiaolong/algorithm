package designMode.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: long
 * @Date: 2020/8/27 14:53
 * @Title
 * @Description:
 */
public class College extends OrganizationComponent {
    List<OrganizationComponent> components = new ArrayList<>();

    public College(String name, String des) {
        super(name, des);
    }

    @Override
    public void add(OrganizationComponent organizationComponent) {
        components.add(organizationComponent);
    }

    @Override
    public void remove(OrganizationComponent organizationComponent) {
        components.remove(organizationComponent);
    }

    @Override
    void print() {
        System.out.println("--------------" + getName() + "---------------");
        for (OrganizationComponent component : components) {
            component.print();
        }
    }
}
