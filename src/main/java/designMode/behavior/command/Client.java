package designMode.behavior.command;

/**
 * @Author: long
 * @Date: 2020/8/30 10:49
 * @Title
 * @Description:
 */
public class Client {
    public static void main(String[] args) {

        //创建电灯的对象（接受者）,命令执行者
        LightReceiver lightReceiver = new LightReceiver();

        //创建电灯相关的开关命令
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);

        //需要一个遥控器
        RemoteController remoteController = new RemoteController();


        remoteController.setCommand(0, lightOnCommand, lightOffCommand);

        System.out.println("开灯");
        remoteController.onButtonWasPushed(0);

        System.out.println("关灯");
        remoteController.offButtonWasPushed(0);

        System.out.println("撤销");
        remoteController.undoButtonWasPushed();
    }
}
