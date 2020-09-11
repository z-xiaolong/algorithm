package designMode.behavior.chain.demo;

/**
 * @Author: long
 * @Date: 2020/9/2 14:56
 * @Title
 * @Description:
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
