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
    int lastItemInsert = 0;


    GraphicInterface(String name, int sizeX, int sizeY, int sizeButtonX, int sizeButtonY) {
        this.name = name;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.frame = new JFrame(this.name);
        this.sizeButtonX = sizeButtonX;
        this.sizeButtonY = sizeButtonY;
        this.buttonOffsetX = 20;
        this.buttonOffsetY = 20;
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
        lastItemInsert = display.getY() + display.getHeight();
        display.setText(this.name);
        frame.add(display);
    }

    void setKeys(String[][] matrix) {

        for(int i = 0; i < matrix.length; i++){
            int posY = buttonOffsetY + lastItemInsert;
            int posX = buttonOffsetX;
            for(int j = 0; j < matrix[i].length; j++){
                JButton newButton = new JButton(matrix[i][j]);
                newButton.setBounds(posX, posY, this.sizeButtonX, this.sizeButtonY);
                newButton.setFont(new Font("Arial", Font.BOLD, 20));
                frame.add(newButton);
                lastItemInsert = newButton.getY() + newButton.getHeight();
                posX = newButton.getX() + newButton.getHeight() + buttonOffsetX;
            }
        }
    }

    void draw() {
        frame.setVisible(true);
    }

}


