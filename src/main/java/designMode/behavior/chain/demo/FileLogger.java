package designMode.behavior.chain.demo;

/**
 * @Author: long
 * @Date: 2020/9/2 14:57
 * @Title
 * @Description:
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
