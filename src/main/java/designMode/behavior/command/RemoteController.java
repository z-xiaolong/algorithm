package designMode.behavior.command;

/**
 * @Author: long
 * @Date: 2020/8/30 10:48
 * @Title
 * @Description:
 */
public class RemoteController {
    //开按钮命令数组
    private Command[] onCommands;
    //关 按钮命令数组
    private Command[] offCommands;

    private Command undoCommand;

    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];
        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NullCommand();
            offCommands[i] = new NullCommand();
        }
    }


    public void setCommand(int no, Command onCommand, Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    public void onButtonWasPushed(int no) {
        onCommands[no].execute();
        undoCommand = onCommands[no];
    }

    public void offButtonWasPushed(int no) {
        offCommands[no].execute();
        undoCommand = offCommands[no];
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }
}
