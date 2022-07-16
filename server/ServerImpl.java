package server;

import shared.DataBaseServer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServerImpl implements DataBaseServer {

    String user = "root";
    String password = "";
    String databaseName = "test";

    public ServerImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public String showData(String tableName) {
        String user = "root";
        String password = "";
        String databaseName = "test";
        String Result = "";

        ResultSet res = null;
        try {

            String url = "jdbc:mysql://localhost:3306/" + databaseName + "?autoReconnect=true&useSSL=false";
            Connection con = DriverManager.getConnection(url, user, password);
            String query = "select * from " + tableName;
            Statement stm = con.createStatement();
            res = stm.executeQuery(query);
            ResultSetMetaData rsmd = res.getMetaData();

            int columnsNumber = rsmd.getColumnCount();
            Result += columnsNumber + ",";
            while (res.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = res.getString(i);
                    Result += columnValue + ",";
                }
                System.out.println("");
            }
            Result += ";";

        } catch (SQLException ex) {
            Logger.getLogger(ServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Result;

    }

    @Override
    public void deleteRow(String tableName, int pKey) {
        try {
            String url = "jdbc:mysql://localhost:3306/" + this.databaseName + "?autoReconnect=true&useSSL=false";
            String user = "root";
            String password = "";
            Connection con = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM " + tableName + " WHERE " + " a " + "='" + pKey + "'";
            System.out.println(query);
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
