package designMode.behavior.command;

/**
 * @Author: long
 * @Date: 2020/8/30 10:47
 * @Title
 * @Description:
 */
public class LightOffCommand implements Command {

    private final LightReceiver receiver;

    public LightOffCommand(LightReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.off();
    }

    @Override
    public void undo() {
        receiver.on();
    }
}
