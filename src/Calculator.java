


public class Calculator {
    double firstValue;
    double secondValue;
    String operation;

    Calculator () {

    }

    double setOperation () {
        double calc = 0.0;
        switch (operation) {
            case "+":
                calc = addFunction();
                break;
            case "-":
                calc = subtractFunction();
                break;
            case "*":
                calc = multiplyFunction();
                break;
            case "/":
                calc = divideFunction();
                break;
            case "%":
                calc = moduleFunction();
                break;
            case "^":
                calc = powFunction();
                break;
            default:
              break;
        }
        return calc;
    }

    void setFirstValue(double num) {
        firstValue = num;
    }

    void setSecondValue(double num) {
        secondValue = num;
    }

    double addFunction() {
        return firstValue + secondValue;
    }

    double subtractFunction() {
        return firstValue - secondValue;
    }

    double divideFunction() {
        return firstValue / secondValue;
    }

    double multiplyFunction() {
        return firstValue * secondValue;
    }

    double powFunction() {
        return Math.pow(firstValue, secondValue);
    }

    double moduleFunction() {
        return firstValue % secondValue;
    }

    double sqrtFunction() {
        return Math.sqrt(firstValue);
    }

    double dividePerOne() {
        return 1 / firstValue;
    }

}
