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
        //Atribuição dos valores para redimenssionamento da calculadora
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Button Size X(100): ");
        int sizeButtonX = scanner.nextInt();
        System.out.println("Enter the Button Size Y (100): ");
        int sizeButtonY = scanner.nextInt();
        System.out.println("Enter the offset X (20): ");
        int offsetX = scanner.nextInt();
        System.out.println("Enter the offset Y (20): ");
        int offsetY = scanner.nextInt();

        //Criação dos objetos e inicialização da interface gráfica
        GraphicInterface graphicInterface = new GraphicInterface(calculatormatrix, sizeButtonX, sizeButtonY, offsetX, offsetY);
        graphicInterface.init();
    }

}
