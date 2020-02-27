package network.nio;

/**
 * @Author long
 * @Date 2020/1/26 20:21
 * @Title
 * @Description //TODO
 **/

public class TImeClient {
    public static void main(String[] args) {
        int port = 18181;
        String ip = "127.0.0.1";
        TimeClientHandle timeClientHandle = new TimeClientHandle(ip, port);
        new Thread(timeClientHandle, "TimeClient-001").start();
    }
}
