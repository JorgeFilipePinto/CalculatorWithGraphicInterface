import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Mapa para a criação do design gráfico da calculadora
        String[][] calculatormatrix = {
                {"%", "CE", "C", ""},
                {"1/x", "^", "SQRT", "/"},
                {"7", "8", "9", "*"},
                {"4", "5", "6", "-"},
                {"1", "2", "3", "+"},
                {"", "0", ",", "="}
        };
        
        //Criação dos objetos e inicialização da interface gráfica
        GraphicInterface graphicInterface = new GraphicInterface(calculatormatrix, sizeButtonX, sizeButtonY, offsetX, offsetY);
        graphicInterface.init();
    }

}
