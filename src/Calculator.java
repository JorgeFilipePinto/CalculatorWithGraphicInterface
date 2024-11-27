public class Calculator {
    double firstValue;
    double secondValue;
    String operation;
    String name;

    Calculator (String name) {
        this.name = name;
    }

    public void getFirstValue(double num) {
        this.firstValue = num;
    }

    public void getSecondValue(double num) {
        this.secondValue = num;
    }

    double madeOperation(int firstValue, int secondValue, String operation) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.operation = operation;
        double result = 0;
        switch (this.operation) {
            case "+":
                result = addFunction();
                break;
            case "-":
                result = subtractFunction();
                break;
            case "*":
                result = multiplyFunction();
                break;
            case "/":
                result = divideFunction();
                break;
            case "%":
                result = moduleFunction();
                break;
            case "**":
                result = powFunction();
                break;
            default:
                System.out.println("Invalid operation\nPlease try again");
                break;
        }
        return result;
    }

    double addFunction() {
        return this.firstValue + this.secondValue;
    }

    double subtractFunction() {
        return this.firstValue - this.secondValue;
    }

    double divideFunction() {
        return this.firstValue / this.secondValue;
    }

    double multiplyFunction() {
        return this.firstValue * this.secondValue;
    }

    double powFunction() {
        return Math.pow(this.firstValue, this.secondValue);
    }

    double moduleFunction() {
        return this.firstValue % this.secondValue;
    }

}
