package designMode.behavior.visitor.demo;

import java.util.Random;

/**
 * @Author: long
 * @Date: 2020/8/31 11:17
 * @Title
 * @Description:
 */
// 员工基类
public abstract class Staff {

    public String name;
    public int kpi;// 员工KPI

    public Staff(String name) {
        this.name = name;
        kpi = new Random().nextInt(10);
    }

    // 核心方法，接受 Visitor的访问
    public abstract void accept(Visitor visitor);
}