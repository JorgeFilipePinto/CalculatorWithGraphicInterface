import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
public class ServidorRMI {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            Calculator calculator = new CalculatorImpl();
            Naming.rebind("rmi://localhost:1099/Calculator",
                    calculator);
            System.out.println("Servidor RMI em execução...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
