import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GraphicInterface {
    String name;
    int sizeX;
    int sizeY;
    char operator;
    int firstNumber;
    int secondNumber;
    JFrame frame;
    int sizeButtonX;
    int sizeButtonY;
    int buttonOffsetX;
    int buttonOffsetY;


    GraphicInterface(String name, int sizeX, int sizeY, int sizeButtonX, int sizeButtonY) {
        this.name = name;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.frame = new JFrame(this.name);
        this.sizeButtonX = sizeButtonX;
        this.sizeButtonY = sizeButtonY;
        this.buttonOffsetX = 50;
        this.buttonOffsetY = 100;
        frame.setSize(this.sizeX, this.sizeY);
        frame.setLayout(null);
    }

    void setDisplay(){
        JLabel display = new JLabel("",SwingConstants.CENTER);
        display.setBounds(0, 0, this.sizeX, 80);
        display.setOpaque(true);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setBackground(Color.BLACK);
        display.setForeground(Color.RED);
        display.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        display.setText(this.name);
        frame.add(display);
    }

    void setKeys(ArrayList<String> numbers, ArrayList<String> operators) {
        ArrayList<JButton> allButtons = new ArrayList<>();
        int posY = buttonOffsetY;
        int posX = buttonOffsetX;
        int opCounter = operators.size() - 1;
        for(int i = 0; i < numbers.size(); i++) {
            JButton newButton = new JButton(numbers.get(i));
            newButton.setBounds(posX, posY, this.sizeButtonX, this.sizeButtonY);
            allButtons.add(newButton);
            frame.add(newButton);
            if(((i+1) % 3) == 0) {
                if(opCounter > 0){
                    posX += this.sizeButtonX;
                    newButton = new JButton(operators.get(opCounter));
                    newButton.setBounds(posX, posY, this.sizeButtonX, this.sizeButtonY);
                    allButtons.add(newButton);
                    frame.add(newButton);
                    opCounter--;
                }
                posX = buttonOffsetX;
                posY += this.sizeButtonY + 20;
            } else {
                posX += this.sizeButtonX;
            }
        }
    }

    void draw() {
        frame.setVisible(true);
    }

}


