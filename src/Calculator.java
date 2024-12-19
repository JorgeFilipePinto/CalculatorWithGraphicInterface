public class Calculator {
    double firstValue;
    double secondValue;
    double result;
    String operation;

    Calculator () {

    }

    void setOperation () {
        double calc = 0.0;
        switch (operation) {
            case "+":
                addFunction();
                break;
            case "-":
                subtractFunction();
                break;
            case "*":
                multiplyFunction();
                break;
            case "/":
                divideFunction();
                break;
            case "%":
                moduleFunction();
                break;
            case "^":
                powFunction();
                break;
            default:
              break;
        }
    }

    void setFirstValue(double num) {
        firstValue = num;
    }

    void setSecondValue(double num) {
        secondValue = num;
    }

    void addFunction() {
        result = firstValue + secondValue;
    }

    void subtractFunction() {
        result = firstValue - secondValue;
    }

    void divideFunction() {
        result = firstValue / secondValue;
    }

    void multiplyFunction() {
        result = firstValue * secondValue;
    }

    void powFunction() {
        result = Math.pow(firstValue, secondValue);
    }

    void moduleFunction() {
        result = firstValue % secondValue;
    }

    void sqrtFunction() {
        result = Math.sqrt(firstValue);
    }

    void dividePerOne() {
        result = 1 / firstValue;
    }

}
