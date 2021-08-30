package test.distribution;

public class Example5ConnectionRequestor {
    static int port = 8081;
    static String ip = "localhost";

    public static void main(String[] args) {
        try {
            //String acceptorHost = args[0];
            //int acceptorPort = Integer.parseInt(args[1]);
            MyStreamSocket mySocket = new MyStreamSocket(ip, port);
            System.out.println("Connection request granted");
            String message = mySocket.receiveMessage();
            System.out.println("Message received:");
            System.out.println("\t" + message);
            mySocket.sendMessage("reply");
            mySocket.close();
            System.out.println("data socket closed");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
