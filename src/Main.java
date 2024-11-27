import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> numKeys = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numKeys.add("" + i);
        }
        ArrayList<String> operatorKeys = new ArrayList<>();
        operatorKeys.add("+");
        operatorKeys.add("-");
        operatorKeys.add("*");
        operatorKeys.add("%");
        operatorKeys.add("^");
        operatorKeys.add("/");
        operatorKeys.add("=");

        System.out.println("Welcome to Calculator");
        System.out.println("Will create a new calculator for you Please Wait.");
        Calculator calculator = newCalculator("Jorge");

        GraphicInterface graphicInterface = new GraphicInterface("Jorge Calculator", 310, 450, 50, 50);
        graphicInterface.setDisplay();
        graphicInterface.setKeys(numKeys, operatorKeys);
        graphicInterface.draw();

        System.out.println("Will create a new calculator for: " + newCalculator("Jorge"));
        System.out.println("First operation ADD 1 + 1 is: " + calculator.madeOperation(1,1,"+"));

    }

    public static Calculator newCalculator(String name) {
        Calculator calculator = new Calculator(name);
        return calculator;
    }
}