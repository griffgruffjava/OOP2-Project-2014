import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJFrame3 extends JFrame implements ActionListener{
    // private instance variables
    JButton button;

    public static void main (String [] args) {
		MyJFrame3 mine = new MyJFrame3();
        mine.setVisible(true);
    }

    public MyJFrame3 () {
        setTitle ("This is a \"MyJFrame3\" object (V3)");
        setSize (300, 500);
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        // get the content pane and set properties
        Container contentPane = getContentPane();
        contentPane.setBackground (Color.blue);
        contentPane.setLayout(null); // so that we can use absolute positioning

        // construct a button and make this MyJFrame3 listen for
        // and  handle button events
        button = new JButton(new Integer(0).toString());
        button.setBounds(110,230,80,40);
	    button.addActionListener(this);
        contentPane.add(button);
    }

    public void actionPerformed(ActionEvent event) {
        // add code to increment the buttonCount and display it on the button

    }
}
