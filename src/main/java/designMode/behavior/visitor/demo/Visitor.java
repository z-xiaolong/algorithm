package designMode.behavior.visitor.demo;

/**
 * @Author: long
 * @Date: 2020/8/31 11:18
 * @Title
 * @Description:
 */
public interface Visitor {

    // 访问工程师类型
    void visit(Engineer engineer);

    // 访问经理类型
    void visit(Manager manager);
}
