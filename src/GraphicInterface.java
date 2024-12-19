import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GraphicInterface {
    private int sizeX;
    private int sizeY;
    private JFrame frame;
    private int sizeButtonX;
    private int sizeButtonY;
    private int buttonOffsetX;
    private int buttonOffsetY;
    private int lastItemInsert = 0;
    private JLabel display;
    private String displayText;
    private ArrayList<JButton> buttonsCalculator = new ArrayList<>();
    String operator;
    Double firstNumber;
    Double secondNumber;
    String tempNumber;
    String[][] map;
    Calculator calculator;

    //Construtor da interface gráfica
    GraphicInterface(String[][] map, int sizeButtonX, int sizeButtonY, int offsetX, int offsetY, Calculator calculator) {
        this.map = map;
        this.frame = new JFrame("Calculator");
        this.displayText = "";
        this.sizeButtonX = sizeButtonX;
        this.sizeButtonY = sizeButtonY;
        this.buttonOffsetX = offsetX;
        this.buttonOffsetY = offsetY;
        this.tempNumber = "";
        this.operator = "";
        this.firstNumber = 0.0;
        this.secondNumber = 0.0;
        this.calculator = calculator;
    }
    //Inicializador da interface gráfica
    void init(){
        sizeFrameCalculator(map);
        setDisplay();
        setKeys();
        frame.setSize(sizeX, sizeY);
        frame.setLayout(null);
        draw();
    }

    //Claculadora de tamnhanho do frame, consoante as medidas fornecidas na criação do objeto irá se redimensionar automaticamente
    void sizeFrameCalculator(String[][] map){
        this.sizeX = (map[0].length + 2) * buttonOffsetX + (map[0].length) * sizeButtonX;
        this.sizeY = (map.length + 2) * buttonOffsetY + ((map.length) * sizeButtonY + 80 + buttonOffsetY);
    }

    //Criação do display para apresentação dos digitos
    void setDisplay(){
        display = new JLabel("",SwingConstants.CENTER);
        display.setBounds(0, 0, sizeX, 80);
        display.setOpaque(true);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setBackground(Color.BLACK);
        display.setForeground(Color.RED);
        display.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        lastItemInsert = display.getY() + display.getHeight();
        display.setText("Calculator");
        frame.add(display);
    }

    //Criação de um array para armazenamento dos butões da calculadora, permitindo assim a criação dos butões mais rápido e reaproveitamento de código
    void setKeys() {
        for (int i = 0; i < map.length; i++) {
            int posY = buttonOffsetY + lastItemInsert;
            int posX = buttonOffsetX;
            for (int j = 0; j < map[i].length; j++) {
                JButton newButton = new JButton(map[i][j]);
                newButton.setBounds(posX, posY, sizeButtonX, sizeButtonY);
                newButton.setFont(new Font("Arial", Font.BOLD, 20));
                frame.add(newButton);
                lastItemInsert = newButton.getY() + newButton.getHeight();
                posX = newButton.getX() + newButton.getHeight() + buttonOffsetX;
                buttonsCalculator.add(newButton);

                //Verificação se é digito ou não para atribuição atribuição dos respetivos eventos
                if (keyIsNumber(newButton.getText())) {
                    newButton.addActionListener(e -> NumberClick(newButton.getText()));
                } else {
                    switch (newButton.getText()) {
                        case "C":
                            newButton.addActionListener(e -> Delete());
                            break;
                        case "CE":
                            newButton.addActionListener(e -> DeleteAll());
                            break;
                        case "+":
                            newButton.addActionListener(e -> SetOperator(newButton.getText()));
                            break;
                        case "-":
                            newButton.addActionListener(e -> SetOperator(newButton.getText()));
                            break;
                        case "/":
                            newButton.addActionListener(e -> SetOperator(newButton.getText()));
                            break;
                        case "*":
                            newButton.addActionListener(e -> SetOperator(newButton.getText()));
                            break;
                        case "=":
                            newButton.addActionListener(e -> Equal());
                            break;
                        case "%":
                            newButton.addActionListener(e -> SetOperator(newButton.getText()));
                            break;
                        case "^":
                            newButton.addActionListener(e -> SetOperator(newButton.getText()));
                            break;
                        case "SQRT":
                            newButton.addActionListener(e -> sqrtFunction());
                            break;
                        case "1/x":
                            newButton.addActionListener(e -> dividePerOne());
                            break;
                        case "":
                            newButton.addActionListener(e -> EmptyButton());
                            break;
                    }
                }
            }
        }
    }

    //Envia o caracter da tecla de um dos operadores para a calculadora armazenar na sua memória
    void SetOperator(String operator) {
        setText("");
        if (!tempNumber.isEmpty()) {
            calculator.operation = operator;
            calculator.setFirstValue(Double.parseDouble(tempNumber));
            tempNumber = "";
            System.out.println("Pressed: " + operator);
        }
    }

    //Função de raíz quadrada
    void sqrtFunction() {
        System.out.println("Pressed: SQRT");
        if (!tempNumber.isEmpty()) {
            setText("");
            calculator.setFirstValue(Double.parseDouble(tempNumber));
            tempNumber = "";
            setText(String.valueOf(calculator.sqrtFunction()));
            System.out.println(String.valueOf(calculator.sqrtFunction()));
        }
    }

    //Função de divisor por 1
    void dividePerOne() {
        System.out.println("Pressed: 1/x");
        if (!tempNumber.isEmpty()) {
            setText("");
            calculator.setFirstValue(Double.parseDouble(tempNumber));
            tempNumber = "";
            setText(String.valueOf(calculator.dividePerOne()));
            System.out.println(String.valueOf(calculator.dividePerOne()));
        }
    }

    //Função equal, chamada quando a tecla = é pressionada
    void Equal() {
        System.out.println("Pressed: =");
        if (!tempNumber.isEmpty()) {
            setText("");
            calculator.setSecondValue(Double.parseDouble(tempNumber));
            setText(String.valueOf(calculator.setOperation()));
            System.out.println(String.valueOf(calculator.setOperation()));
            tempNumber = "";
        }
    }

    //Verificação se é número
    boolean keyIsNumber (String buttonName) {
        try{
            Integer.parseInt(buttonName);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    //Ação cada vez que um número é presionado
    void NumberClick(String buttonName) {
        if (buttonName.isEmpty() && buttonName != "0") {
            tempNumber = buttonName;
        } else if (!buttonName.isEmpty()) {
            tempNumber += buttonName;
        }
        setText(tempNumber);
        System.out.println("Pressed: " + buttonName);
    }

    //Para limpar um digito do display
    void Delete(){
        System.out.println("Pressed: C");
        if(!tempNumber.isEmpty()){
            tempNumber = tempNumber.substring(0, tempNumber.length() - 1);
            displayText = tempNumber;
            setText(displayText);
        }
    }

    //Função chamada quando os botões são vazios
    void EmptyButton() {
        System.out.println("EmptyButton");
    }

    //Elimina todos os digitos e operadores inseridos na calculadora
    void DeleteAll() {
        System.out.println("Pressed: CE");
        tempNumber = "";
        displayText = "";
        setText(displayText);
        firstNumber = 0.0;
        secondNumber = 0.0;
    }

    //Coloca o meu frame visible
    void draw() {
        frame.setVisible(true);
    }

    //Envia o texto para o display
    void setText(String text) {
        display.setText(text);
    }

}


