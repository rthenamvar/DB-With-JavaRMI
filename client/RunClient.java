package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.ResultSetMetaData;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RunClient {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        RMIClient client = new RMIClient();
        client.startClient();
        //client.deleteRow("test", 2);
        System.err.println(client.showData("test"));
    }
}
