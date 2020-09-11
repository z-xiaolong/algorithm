package designMode.structure.composite;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: long
 * @Date: 2020/8/27 15:07
 * @Title
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        OrganizationComponent swu = new University("西南大学", "双一流 211");
        OrganizationComponent computer = new College("计算机与信息科学学院", "25教学楼");
        OrganizationComponent engineer = new College("信息工程技术", "32教");

        computer.add(new Department("软件工程", "java c++"));
        computer.add(new Department("计算机科学与技术", "编译原理"));
        computer.add(new Department("网络工程", "计算机网络"));

        engineer.add(new Department("通信工程", "通信原理"));


        swu.add(computer);
        swu.add(engineer);

        swu.print();

        Map<String, String> map = new HashMap<>();

        HashMap<String, String> hashMap = new HashMap<>();
    }
}
