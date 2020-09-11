package designMode.structure.proxy.reflect;

/**
 * @Author: long
 * @Date: 2020/8/28 11:33
 * @Title
 * @Description:
 */
public class HelloServiceImpl implements HelloService {

    private String name;

    public HelloServiceImpl(String name) {
        this.name = name;
    }

    @Override
    public void sayHello(String name) {
        System.out.println("我叫" + this.name + ",您好：" + name);
    }

    @Override
    public String sayBye() {
        System.out.println("Bye!");
        return name;
    }
}
