package Practice2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Equation extends Remote{
    void CalcEquation(int a, int b, int c) throws RemoteException;
}
