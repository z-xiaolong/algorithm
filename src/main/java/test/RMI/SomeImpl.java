package test.RMI;

import java.rmi.*;
import java.rmi.server.*;

public class SomeImpl extends UnicastRemoteObject implements SomeInterface{
    public SomeImpl() throws RemoteException{
        super();
    }
    @Override
    public String sayHello(String name) throws RemoteException{
        return "Hello," + name + ";";
    }
}
