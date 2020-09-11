package designMode.behavior.command;

/**
 * @Author: long
 * @Date: 2020/8/30 10:45
 * @Title
 * @Description:
 */
public interface Command {

    //执行动作
    void execute();

    //撤销动作
    void undo();
}
