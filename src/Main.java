import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String[][] calculatormatrix = {
                {"%", "CE", "C", "del"},
                {"1/x", "^", "SQRT", "/"},
                {"7", "8", "9", "*"},
                {"4", "5", "6", "-"},
                {"1", "2", "3", "+"},
                {"", "0", ",", "="}
        };


        System.out.println("Welcome to Calculator");
        System.out.println("Will create a new calculator for you Please Wait.");
        Calculator calculator = newCalculator("Jorge");

        GraphicInterface graphicInterface = new GraphicInterface("Jorge Calculator", 520, 860, 100, 100);
        graphicInterface.setDisplay();
        graphicInterface.setKeys(calculatormatrix);
        graphicInterface.draw();

        System.out.println("Will create a new calculator for: " + newCalculator("Jorge"));
        System.out.println("First operation ADD 1 + 1 is: " + calculator.madeOperation(1,1,"+"));

    }

    public static Calculator newCalculator(String name) {
        Calculator calculator = new Calculator(name);
        return calculator;
    }
}