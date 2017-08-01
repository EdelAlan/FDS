/**
 * Created by alan on 08/05/2017.
 */

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements ServerInterface {
    private static final String MENU = "login successful\n" +
            "1. order western food\n" +
            "2. order northern food\n" +
            "3. order southern food\n" +
            "4. track order\n" +
            "5. logout";
    public static final String NAME = "root";
    public static final String PASSWORD = "root";
    public static ArrayList<User> users = new ArrayList<>();

    public Server() throws RemoteException {
        super(0);    // required to avoid the 'rmic' step
    }

    @Override
    public String getMenu() throws RemoteException {
        return MENU;
    }

    public static void main(String args[]) throws Exception {
        System.out.println("RMI server started");

        try { //special exception handler for registry creation
            LocateRegistry.createRegistry(1099);
            System.out.println("java RMI registry created.");
        } catch (RemoteException e) {
            //do nothing, error means registry already exists
            System.out.println("java RMI registry already exists.");
        }

        //Instantiate Server

        Server obj = new Server();

        // Bind this object instance to the name "Server"
        Naming.rebind("//localhost/Server", obj);
        System.out.println("PeerServer bound in registry");
    }
}