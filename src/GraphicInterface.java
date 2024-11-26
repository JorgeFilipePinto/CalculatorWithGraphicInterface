import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class GraphicInterface {
    String name;
    int sizeX;
    int sizeY;


    GraphicInterface(String name, int sizeX, int sizeY) {
        this.name = name;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    void draw() {
        JFrame myCalculatorFrame = new JFrame("Calculator " + this.name);
        myCalculatorFrame.setSize(700, 700);
        myCalculatorFrame.setLayout(new GridBagLayout());
        myCalculatorFrame.setVisible(true);
    }

    void setNumKeys() {
        JButton key0 = new JButton("0");
        JButton key1 = new JButton("1");
        JButton key2 = new JButton("2");
        JButton key3 = new JButton("3");
        JButton key4= new JButton("4");
        JButton key5 = new JButton("5");
        JButton key6 = new JButton("6");
        JButton key7 = new JButton("7");
        JButton key8 = new JButton("8");
        JButton key9 = new JButton("9");
    }

    void setOperatorKeys() {
        JButton keyDivide = new JButton("/");
        JButton keyMultiply = new JButton("*");
        JButton keySubtract = new JButton("-");
        JButton keyAdd = new JButton("+");
        JButton keyEqual = new JButton("=");
        JButton keyPow = new JButton("**");
        JButton keyModule = new JButton("%");
    }
}


