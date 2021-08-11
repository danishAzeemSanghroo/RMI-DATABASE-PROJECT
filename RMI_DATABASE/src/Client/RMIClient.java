/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;


import Interfaces.Save;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Danish
 */
public class RMIClient {
    public static void main(String args[])throws RemoteException
    {
        Scanner sc=new Scanner(System.in);
        try
        {
            Registry reg=LocateRegistry.getRegistry("localhost",4444);
            Save ob=(Save) reg.lookup("hi_server");
            System.out.print("Enter your Name: ");
                String name=sc.next();
            System.out.print("Enter your Father's name");
                String fname=sc.next();
            System.out.print("Enter your Surname: ");
                String surname=sc.next();
            if(ob.save(name,fname ,surname)>=1){
                
                System.out.println("Record added");
                
                JOptionPane.showMessageDialog(null,"Record Added");
            }
            
        }catch(Exception e)
        {
            System.out.println("Exception "+e);
        }
    }
    
}
