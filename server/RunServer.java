package server;

import shared.DataBaseServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RunServer {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        DataBaseServer TheServer = new ServerImpl();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("TheServer", TheServer);
        System.out.println("Server started");
    }
}
