package test.distribution;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Example4ConnectionRequestor {

    static String ip = "127.0.0.1";
    static int port = 8080;

    public static void main(String[] args) {
        try {
            Socket mySocket = new Socket(ip, port);

            //InetAddress acceptorHost = InetAddress.getByName(args[0]);
            //int acceptorPort = Integer.parseInt(args[1]);
            //Socket mySocket = new Socket(acceptorHost, acceptorPort);
            System.out.println("Connection request granted");
            InputStream inStream = mySocket.getInputStream();
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(inStream));
            System.out.println("waiting to read");
            String message = socketInput.readLine();
            System.out.println("Message received:");
            System.out.println("\t" + message);
            mySocket.close();
            System.out.println("data socket closed");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
