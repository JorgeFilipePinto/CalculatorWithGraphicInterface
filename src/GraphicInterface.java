import java.awt.*;
import java.awt.event.ActionListener;
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

    void init(){
        sizeFrameCalculator(map);
        setDisplay();
        setKeys();
        frame.setSize(sizeX, sizeY);
        frame.setLayout(null);
        draw();
    }

    void sizeFrameCalculator(String[][] map){
        this.sizeX = (map[0].length + 2) * buttonOffsetX + (map[0].length) * sizeButtonX;
        this.sizeY = (map.length + 2) * buttonOffsetY + ((map.length) * sizeButtonY + 80 + buttonOffsetY);
    }

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

    void SetOperator(String operator) {
        display.setText("");
        if (!tempNumber.isEmpty()) {
            calculator.operation = operator;
            calculator.setFirstValue(Double.parseDouble(tempNumber));
            tempNumber = "";
            System.out.println("Pressed: " + operator);
        }
    }

    void sqrtFunction() {
        System.out.println("Pressed: SQRT");
        if (!tempNumber.isEmpty()) {
            display.setText("");
            calculator.setFirstValue(Double.parseDouble(tempNumber));
            tempNumber = "";
            calculator.sqrtFunction();
            display.setText(String.valueOf(calculator.result));
            System.out.println(String.valueOf(calculator.result));
        }
    }

    void dividePerOne() {
        System.out.println("Pressed: 1/x");
        if (!tempNumber.isEmpty()) {
            display.setText("");
            calculator.setFirstValue(Double.parseDouble(tempNumber));
            tempNumber = "";
            calculator.dividePerOne();
            display.setText(String.valueOf(calculator.result));
            System.out.println(String.valueOf(calculator.result));
        }
    }

    void Equal() {
        System.out.println("Pressed: =");
        if (!tempNumber.isEmpty()) {
            display.setText("");
            calculator.setSecondValue(Double.parseDouble(tempNumber));
            calculator.setOperation();
            display.setText(String.valueOf(calculator.result));
            System.out.println(String.valueOf(calculator.result));
            tempNumber = "";
            calculator.result = 0.0;
        }
    }

    boolean keyIsNumber (String buttonName) {
        try{
            Integer.parseInt(buttonName);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    void NumberClick(String buttonName) {
        if (buttonName.isEmpty() && buttonName != "0") {
            tempNumber = buttonName;
        } else if (!buttonName.isEmpty()) {
            tempNumber += buttonName;
        }
        display.setText(tempNumber);
        System.out.println("Pressed: " + buttonName);
    }

    void Delete(){
        System.out.println("Pressed: C");
        if(!tempNumber.isEmpty()){
            tempNumber = tempNumber.substring(0, tempNumber.length() - 1);
            displayText = tempNumber;
            setText(displayText);
            setText(displayText);
        }
    }

    void EmptyButton() {
        System.out.println("EmptyButton");
    }

    void DeleteAll() {
        System.out.println("Pressed: CE");
        tempNumber = "";
        displayText = "";
        setText(displayText);
        firstNumber = 0.0;
        secondNumber = 0.0;
    }

    void draw() {
        frame.setVisible(true);
    }

    void setText(String text) {
        display.setText(text);
    }

}


