package test.distribution;

import java.io.IOException;
import java.net.ServerSocket;

public class Example5ConnectionAcceptor {

    static int port = 8081;
    static String message = "hello word";

    public static void main(String[] args) {
        try {

            //String message = args[1];
            ServerSocket connectionSocket = new ServerSocket(port);
            System.out.println("now ready accept a connection");
            MyStreamSocket dataSocket = new MyStreamSocket(connectionSocket.accept());
            System.out.println("connection accepted");
            dataSocket.sendMessage(message);
            System.out.println("message sent");

            System.out.println("receiveMessage...");
            String msg = dataSocket.receiveMessage();
            System.out.println("Message: " + msg);

            dataSocket.close();
            System.out.println("data socket closed");
            connectionSocket.close();
            System.out.println("connection socket closed");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
