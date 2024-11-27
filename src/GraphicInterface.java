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
    String name;
    String operator;
    Double firstNumber;
    Double secondNumber;
    String tempNumber;
    String[][] map;


    GraphicInterface(String[][] map, String name, int sizeButtonX, int sizeButtonY, int offsetX, int offsetY) {
        this.map = map;
        this.name = name;
        this.frame = new JFrame(this.name);
        this.displayText = "";
        this.sizeButtonX = sizeButtonX;
        this.sizeButtonY = sizeButtonY;
        this.buttonOffsetX = offsetX;
        this.buttonOffsetY = offsetY;
        this.tempNumber = "";
        this.operator = "";
        this.firstNumber = 0.0;
        this.secondNumber = 0.0;
    }

    void init(){
        sizeFrameCalculator(this.map);
        setDisplay();
        setKeys();
        frame.setSize(this.sizeX, this.sizeY);
        frame.setLayout(null);
        draw();
    }

    void sizeFrameCalculator(String[][] map){
        this.sizeX = (map[0].length + 2) * buttonOffsetX + (map[0].length) * this.sizeButtonX;
        this.sizeY = (map.length + 2) * buttonOffsetY + ((map.length) * this.sizeButtonY + 80 + buttonOffsetY);
    }

    void setDisplay(){
        display = new JLabel("",SwingConstants.CENTER);
        display.setBounds(0, 0, this.sizeX, 80);
        display.setOpaque(true);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setBackground(Color.BLACK);
        display.setForeground(Color.RED);
        display.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        lastItemInsert = display.getY() + display.getHeight();
        display.setText(this.name);
        frame.add(display);
    }

    void setKeys() {
        for(int i = 0; i < this.map.length; i++){
            int posY = buttonOffsetY + lastItemInsert;
            int posX = buttonOffsetX;
            for(int j = 0; j < this.map[i].length; j++){
                JButton newButton = new JButton(this.map[i][j]);
                newButton.setBounds(posX, posY, this.sizeButtonX, this.sizeButtonY);
                newButton.setFont(new Font("Arial", Font.BOLD, 20));
                frame.add(newButton);
                lastItemInsert = newButton.getY() + newButton.getHeight();
                posX = newButton.getX() + newButton.getHeight() + buttonOffsetX;
                buttonsCalculator.add(newButton);

                if (keyIsNumber(newButton.getText())) {
                    newButton.addActionListener(e -> NumberClick(newButton.getText()));
                } else if(newButton.getText() == "C"){
                    newButton.addActionListener(e -> Delete());
                } else if(newButton.getText() == "CE"){
                    newButton.addActionListener(e -> DeleteAll());
                } else if(newButton.getText() == "") {
                    newButton.addActionListener(e -> EmptyButton());
                }else {
                    newButton.addActionListener(e -> OperatorClick(newButton.getText()));
                }
            }
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
        if(this.operator == "") {
            this.tempNumber += buttonName;
            this.displayText = this.tempNumber;
            setText(this.displayText);
            System.out.println("Key" + buttonName);
        } else if(!(this.operator == "")) {
            this.tempNumber += buttonName;
            this.displayText = this.tempNumber;
            setText(this.displayText);
            System.out.println("Key" + buttonName);
        }
    }

    void OperatorClick(String buttonOperator) {
        if(this.operator == "") {
            this.firstNumber = Double.parseDouble(this.tempNumber);
            this.displayText = this.tempNumber + buttonOperator;
            setText(this.displayText);
            this.tempNumber = "";
            this.operator = buttonOperator;
        } else if(!(this.operator == "")) {
            this.operator = buttonOperator;
            this.displayText = this.firstNumber + buttonOperator;
            setText(this.displayText);
        }
    }

    void Delete(){
        if(!this.tempNumber.isEmpty()){
            this.tempNumber = this.tempNumber.substring(0, this.tempNumber.length() - 1);
            this.displayText = this.tempNumber;
            setText(this.displayText);
            setText(this.displayText);
        }
    }

    void EmptyButton() {
        System.out.println("EmptyButton");
    }

    void DeleteAll() {
        this.tempNumber = "";
        this.displayText = this.tempNumber;
        setText(this.displayText);
        setText(this.displayText);
    }

    void draw() {
        frame.setVisible(true);
    }

    void setText(String text) {
        this.display.setText(text);
    }

}


