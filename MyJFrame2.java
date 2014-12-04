import javax.swing.*;
import java.awt.*;
public class MyJFrame2 extends JFrame {
    // private instance variables
    JButton oneButton;
    /** driver */
    public static void main (String [] args) {  
		MyJFrame2 mine = new MyJFrame2();
        mine.setVisible(true);
    }

    public MyJFrame2 () {
        setTitle ("This is a \"MyJFrame2\" object (V2)");
        setSize (300, 500);
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        // get the content pane and set properties
        Container contentPane = getContentPane();
        contentPane.setBackground (Color.blue);
        contentPane.setLayout(null); // so that we can use absolute positioning

        // construct two buttons
        oneButton = new JButton("One");
        oneButton.setBounds(250,100,80,50);
        contentPane.add(oneButton);
    }
}
