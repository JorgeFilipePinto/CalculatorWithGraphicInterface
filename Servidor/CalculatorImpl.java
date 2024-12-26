import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    public CalculatorImpl() throws RemoteException {
        super();
    }

    //Função para somar os valores
    public double addFunction(double firstValue, double secondValue) throws RemoteException {
        return firstValue + secondValue;
    }

    //Função para substrair os valores
    public double subFunction(double firstValue, double secondValue) throws RemoteException {
        return firstValue - secondValue;
    }

    //Função para dividir os valores
    public double divideFunction(double firstValue, double secondValue) throws RemoteException {
        return firstValue / secondValue;
    }

    //Função para multiplicar os valores
    public double multiplyFunction(double firstValue, double secondValue) throws RemoteException  {
        return firstValue * secondValue;
    }

    //Função para realizar cálculos com potências
    public double powFunction(double firstValue, double secondValue) throws RemoteException  {
        return Math.pow(firstValue, secondValue);
    }

    //Função para cálculo o módular
    public double moduleFunction(double firstValue, double secondValue) throws RemoteException  {
        return firstValue % secondValue;
    }

    //Cálculo com raíz quadrada
    public double sqrtFunction(double firstValue) throws RemoteException {
        return Math.sqrt(firstValue);
    }

    //Operação 1 dividir por o primeiro valor
    public double dividePerOne(double firstValue) throws RemoteException {
        return 1 / firstValue;
    }
}
