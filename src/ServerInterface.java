/**
 * Created by alan on 08/05/2017.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {
    public String getMenu() throws RemoteException;
}