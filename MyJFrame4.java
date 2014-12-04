import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJFrame4 extends JFrame implements ActionListener{
    // private instance variables
    JButton button1;
	JButton button2;
	
    public static void main (String [] args) {
		MyJFrame4 mine = new MyJFrame4();
        mine.setVisible(true);
    }

    public MyJFrame4 () {
        setTitle ("This is a \"MyJFrame4\" object (V4)");
        setSize (300, 500);
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        // get the content pane and set properties
        Container contentPane = getContentPane();
        contentPane.setBackground (Color.blue);
        contentPane.setLayout(null); // so that we can use absolute positioning

        // construct a button and make this MyJFrame3 listen for
        // and  handle button events
        button1 = new JButton(new Integer(0).toString());
        button2 = new JButton(new Integer(0).toString());
        
        button1.setBounds(110,130,80,40);
        button2.setBounds(110,230,80,40);
	    button1.addActionListener(this);
	    button2.addActionListener(this);
        contentPane.add(button1);
        contentPane.add(button2);
    }

    public void actionPerformed(ActionEvent event) {
        // add code to increment the buttonCount and display it on the button

    }
}
