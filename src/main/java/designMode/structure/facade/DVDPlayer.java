package designMode.structure.facade;

/**
 * @Author: long
 * @Date: 2020/8/27 15:39
 * @Title
 * @Description:
 */
public class DVDPlayer {

    private static DVDPlayer instance = new DVDPlayer();

    public static DVDPlayer getInstance() {
        return instance;
    }

    public void on(){
        System.out.println(" DVD on");
    }

    public void off(){
        System.out.println("DVD off");
    }

    public void play(){
        System.out.println("DVD playing");
    }

    public void pause(){
        System.out.println("DVD pause");
    }
}
