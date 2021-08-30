package designMode.structure.composite;



/**
 * @Author: long
 * @Date: 2020/8/27 14:51
 * @Title
 * @Description:
 */
public abstract class OrganizationComponent {
    private String name; //名字
    private String des; //说明

    public OrganizationComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    protected void add(OrganizationComponent organizationComponent) {
        throw new UnsupportedOperationException();
    }

    protected void remove(OrganizationComponent organizationComponent) {
        throw new UnsupportedOperationException();
    }

    abstract void print();

    @Override
    public String toString() {
        return "OrganizationComponent{" +
                "name='" + name + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
