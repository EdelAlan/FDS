/**
 * Created by alan on 08/05/2017.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Client {
    public static void main(String args[]) throws Exception {
        ServerInterface obj = (ServerInterface)Naming.lookup("//localhost/Server");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        String password;
        try {
            System.out.println("enter 0 to register");
            System.out.println("login: ");
            name = reader.readLine();
            if (name.equals("0")) {
                register();
                return;
            }
            System.out.println("password: ");
            password = reader.readLine();
            for (int i = 0; i < Server.users.size(); i++) {
                if (name.equals(Server.users.get(i).name) && password.equals(Server.users.get(i).password)) {
                    System.out.println(obj.getMenu());
                } else if (name.equals(Server.NAME) && password.equals(Server.PASSWORD)) {
                    System.out.println(obj.getMenu());
                } else {
                    System.out.println("wrong name or password");
                    Client.main(args);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("wrong name or password");
            Client.main(args);
        }
    }

    public static void register() throws RemoteException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        String password;
        String email;
        String phoneNumber;

        try {
            System.out.println("enter name: ");
            name = reader.readLine();
            System.out.println("enter password: ");
            password = reader.readLine();
            System.out.println("enter email: ");
            email = reader.readLine();
            System.out.println("enter phone number: ");
            phoneNumber = reader.readLine();

            Server.users.add(new User(name, password, email, phoneNumber));
            System.out.println("User with name – '" + name + "' was saved");
            String[] args = {};
            Client.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}