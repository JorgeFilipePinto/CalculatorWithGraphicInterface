public class Calculator {
    double firstValue;
    double secondValue;
    String operation;

    //Construtor da calculadora
    Calculator () {
    }

    //Identifica qual o operador enviado pela interface gráfica e devolve o valor do cálculo da respetiva função
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

    //Setter para o primeiro valor
    void setFirstValue(double num) {
        firstValue = num;
    }

    //Setter para o segundo valor
    void setSecondValue(double num) {
        secondValue = num;
    }

    //Função para somar os valores
    double addFunction() {
        return firstValue + secondValue;
    }

    //Função para substrair os valores
    double subtractFunction() {
        return firstValue - secondValue;
    }

    //Função para dividir os valores
    double divideFunction() {
        return firstValue / secondValue;
    }

    //Função para multiplicar os valores
    double multiplyFunction() {
        return firstValue * secondValue;
    }

    //Função para realizar cálculos com potências
    double powFunction() {
        return Math.pow(firstValue, secondValue);
    }

    //Função para cálculo o módular
    double moduleFunction() {
        return firstValue % secondValue;
    }

    //Cálculo com raíz quadrada
    double sqrtFunction() {
        return Math.sqrt(firstValue);
    }

    //Operação 1 dividir por o primeiro valor
    double dividePerOne() {
        return 1 / firstValue;
    }
}
