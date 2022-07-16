package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import shared.DataBaseServer;
import java.sql.ResultSet;


public class RMIClient {

    private DataBaseServer server;

    public RMIClient() {
    }

    public void startClient() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        server = (DataBaseServer) registry.lookup("TheServer");
    }

    public String showData(String tableName) {
        String result = null;
        try {
            result = server.showData(tableName);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not contact server");
        }
        return result;
    }
    public void deleteRow(String tableName, int pKey) {
        
        try {
            server.deleteRow(tableName,pKey);
            System.err.println("Successful from deleteRow's client!");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not contact server");
        }
    }
}
