import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Calculator extends Remote  {
    double addFunction(double firstValue, double secondValue) throws RemoteException;
    double subFunction(double firstValue, double secondValue) throws RemoteException;
    double multiplyFunction(double firstValue, double secondValue) throws RemoteException;
    double divideFunction(double firstValue, double secondValue) throws RemoteException;
    double powFunction(double firstValue, double secondValue) throws RemoteException;
    double moduleFunction(double firstValue, double secondValue) throws RemoteException;
    double dividePerOne(double firstValue) throws RemoteException;
    double sqrtFunction(double firstValue) throws RemoteException;
}
