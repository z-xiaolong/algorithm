package designMode.structure.facade;

/**
 * @Author: long
 * @Date: 2020/8/27 15:46
 * @Title
 * @Description:
 */
public class Stereo {
    private static Stereo instance = new Stereo();

    public static Stereo getInstance() {
        return instance;
    }

    public void on(){
        System.out.println(" Stereo on");
    }

    public void off(){
        System.out.println("Stereo off");
    }

    public void up() {
        System.out.println(" Stereo up");
    }

    public void down() {
        System.out.println("Stereo down");
    }
}
