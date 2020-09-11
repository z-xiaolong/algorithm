package designMode.behavior.command;

/**
 * @Author: long
 * @Date: 2020/8/30 10:46
 * @Title
 * @Description:
 */
public class LightOnCommand implements Command {

    private final LightReceiver light;

    public LightOnCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
