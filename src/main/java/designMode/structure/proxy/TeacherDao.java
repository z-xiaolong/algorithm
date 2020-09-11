package designMode.structure.proxy;

/**
 * @Author: long
 * @Date: 2020/8/28 10:33
 * @Title
 * @Description:
 */
public class TeacherDao implements ITeacherDao {
    @Override
    public void teacher() {
        System.out.println("老师授课中...");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("hello:" + name);
    }
}
