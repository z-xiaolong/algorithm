package designMode.behavior.command;

/**
 * @Author: long
 * @Date: 2020/8/30 10:50
 * @Title
 * @Description: 空命令，用于初始化按钮，调用空命令时，对象不执行命令，即空命令
 */
public class NullCommand implements Command {

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
