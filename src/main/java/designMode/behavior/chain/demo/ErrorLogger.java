package designMode.behavior.chain.demo;

/**
 * @Author: long
 * @Date: 2020/9/2 14:56
 * @Title
 * @Description:
 */
public class ErrorLogger extends AbstractLogger{
    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
