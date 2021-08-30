package test.RMI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;

public class SomeClient {
    public static void main(String[] args) {
        try {
            int RMIPort;
            String hostName;
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            System.out.println("Enter the RMIRegistry hos name:");
            hostName = br.readLine();
            System.out.println("Enter the RMI registry port number:");
            String portNum = br.readLine();
            RMIPort = Integer.parseInt(portNum);
            String registryURL = "rmi://" + hostName + ":" + RMIPort + "/hello";
            SomeInterface h = (SomeInterface) Naming.lookup(registryURL);
            System.out.println("Lookup completed");
            String message = h.sayHello("Donald Duck");
            System.out.println("HelloClient:" + message);
        } catch (Exception e) {
            System.out.println("Exception in HelloClient:" + e);
        }
    }
}
