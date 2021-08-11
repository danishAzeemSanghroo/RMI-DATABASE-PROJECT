/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DatabaseManager.DatabaseManager;
import Interfaces.Save;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Danish
 */
public class RMIServer extends UnicastRemoteObject implements Save{

    public RMIServer()throws RemoteException
    {
        super();
    }
    @Override
    public int save(String name,String fname,String surname){
       int rows=0;
        try {
            rows += DatabaseManager.add(name, fname, surname);
        } catch (Exception ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rows;
     }
    public static void main(String args[]){
    try
    {
        Registry reg=LocateRegistry.createRegistry(4444);
        reg.bind("hi_server", new RMIServer());
        System.out.println("Server is ready");
    }catch(Exception e)
    {
        System.out.println("Exception " + e);
    }
    
    }
}
