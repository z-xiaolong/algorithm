package network.aio;

/**
 * @Author long
 * @Date 2020/1/29 16:26
 * @Title
 * @Description //TODO
 **/

public class TimeClient {
    public static void main(String[] args) {
        int port = 18080;
        new Thread(new AsyncTimeClientHandler("127.0.0.1", port), "AIO-AsyncTimeClientHandler-001").start();
    }


}
