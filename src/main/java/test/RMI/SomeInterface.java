package test.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SomeInterface extends Remote {
    String sayHello(String name) throws RemoteException;
}
