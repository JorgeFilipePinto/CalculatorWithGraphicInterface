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

}
