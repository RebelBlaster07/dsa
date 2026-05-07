package asign1;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class server extends UnicastRemoteObject implements myRemote {
    server() throws RemoteException {
        super();
    }

    public String message() {
        return "Hello client, RMI working!!";
    }

    public static void main(String args[]) {
        try {
            server obj = new server();
            Naming.rebind("rmi://localhost/Test", obj);

            System.out.println("Server started");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
