package designMode.structure.facade;

/**
 * @Author: long
 * @Date: 2020/8/27 15:49
 * @Title
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        homeTheaterFacade.ready();
        homeTheaterFacade.play();
        homeTheaterFacade.end();

    }
}
