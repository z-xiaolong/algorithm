package test.distribution;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Example4ConnectionAcceptor {
    static int port = 8080;
    static String message = "hello word";
    public static void main(String[] args) {
        try {
            //int portNo = Integer.parseInt(args[0]);
            //String message = args[1];
            ServerSocket connectionSocket = new ServerSocket(port);
            System.out.println("now ready accept a connection");
            Socket dataSocket = connectionSocket.accept();
            System.out.println("connection accepted");
            OutputStream outStream = dataSocket.getOutputStream();
            PrintWriter socketOutput = new PrintWriter(new OutputStreamWriter(outStream));
            Thread.sleep(5000);
            socketOutput.print('w');
            socketOutput.println(message);
            socketOutput.flush();
            System.out.println("message sent");
            dataSocket.close();
            System.out.println("connection socket closed");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
