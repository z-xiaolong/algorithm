package designMode.behavior.visitor.demo;

/**
 * @Author: long
 * @Date: 2020/8/31 11:20
 * @Title
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        // 构建报表
        BusinessReport report = new BusinessReport();
        System.out.println("=========== CEO看报表 ===========");
        report.showReport(new CEOVisitor());
        System.out.println("=========== CTO看报表 ===========");
        report.showReport(new CTOVisitor());
    }
}
