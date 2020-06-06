package tomcat;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author long
 * @Date 2020/4/16 17:23
 * @Title
 * @Description //TODO
 **/

public class HttpServer {
    public static final String WEB_ROOT =
            System.getProperty("user.dir") + File.separator + "webroot";

    // 关闭命令
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    // 是否关闭
    private boolean shutdown = false;

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();
    }

    public void await() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            // 创建一个socket服务器
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // 循环等待http请求
        while (!shutdown) {
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;
            try {
                // 阻塞等待http请求
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();

                // 创建一个Request对象用于解析http请求内容
                Request request = new Request(input);
                request.parse();

                // 创建一个Response 对象，用于发送静态文本
                Response response = new Response(output);
                response.setRequest(request);
                response.sendStaticResource();

                // 关闭流
                socket.close();

                //检查URI中是否有关闭命令
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}
