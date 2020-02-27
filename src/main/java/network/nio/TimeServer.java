package network.nio;

import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;

/**
 * @Author long
 * @Date 2020/1/17 21:07
 * @Title
 * @Description //TODO
 **/

public class TimeServer {
    public static void main(String[] args) throws InterruptedException {
        int port = 18181;
        String ip = "127.0.0.1";
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(ip, port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
        //Thread.sleep(1000000);
    }
}
