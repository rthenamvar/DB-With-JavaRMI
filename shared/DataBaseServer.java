package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;


public interface DataBaseServer extends Remote {
    String showData(String tableName) throws RemoteException;
    void deleteRow(String tableName, int pKey) throws RemoteException;
}