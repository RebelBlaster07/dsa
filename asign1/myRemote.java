package asign1;

import java.rmi.*;

public interface myRemote extends Remote {
    String message() throws RemoteException;
}
