package test.distribution;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class MyStreamSocket extends Socket{
    private final Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public MyStreamSocket(String acceptorHost, int acceptorPort) throws SocketException, IOException {
        socket = new Socket(acceptorHost, acceptorPort);
        setStreams();
    }

    public MyStreamSocket(Socket socket) throws IOException {
        this.socket = socket;
        setStreams();
    }


    private void setStreams() throws IOException {
        InputStream inStream = socket.getInputStream();
        input = new BufferedReader(new InputStreamReader(inStream));
        OutputStream outStream = socket.getOutputStream();
        output = new PrintWriter(new OutputStreamWriter(outStream));
    }

    public void sendMessage(String message) throws IOException {
        output.println(message);
        output.flush();
    }

    public String receiveMessage() throws IOException {
        String message = input.readLine();
        return message;
    }

    public void closeAll() {
        try {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
