

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Calculator");
        System.out.println("Will create a new calculator for you Please Wait.");
        Calculator calculator = newCalculator("Jorge");
        System.out.println("Will create a new calculator for: " + newCalculator("Jorge"));
        System.out.println("First operation ADD 1 + 1 is: " + calculator.getOperation(1,1,"+"));


    }

    public static Calculator newCalculator(String name) {
        Calculator calculator = new Calculator(name);
        return calculator;
    }
}