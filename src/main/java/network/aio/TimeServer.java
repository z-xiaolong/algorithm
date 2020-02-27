package network.aio;

/**
 * @Author long
 * @Date 2020/1/29 16:29
 * @Title
 * @Description //TODO
 **/

public class TimeServer {
    public static void main(String[] args) {
        int port = 18080;
        AsyncTimeServerHandler timeServerHandler = new AsyncTimeServerHandler(port);
        new Thread(timeServerHandler, "AIO-AsyncTimeServerHandler-001").start();
    }
}
