package designMode.structure.proxy.dynamicProxy.Test;

/**
 * @Author: long
 * @Date: 2020/8/28 15:01
 * @Title
 * @Description:
 */
public class InterfaceServiceImpl implements InterfaceService {

    private String name = "default";

    @Override
    public void service(String name) {
        this.name = name;
        System.out.println(name);
    }

    @Override
    public String getName() {
        return name;
    }
}
