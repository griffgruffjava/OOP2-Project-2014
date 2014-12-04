import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJFrame5 extends JFrame implements ActionListener{
    // private instance variables
    JButton button;
    JTextField jtf;
    int buttoncount=0;

    public static void main (String [] args) {
		MyJFrame5 mine = new MyJFrame5();
        mine.setVisible(true);
    }

    public MyJFrame5 () {
        setTitle ("This is a \"MyJFrame5\" object (V3)");
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
        
        jtf=new JTextField();
        jtf.setBounds(110,130,80,40);
        jtf.addActionListener(this);
        contentPane.add(jtf);
        
        
    }

    public void actionPerformed(ActionEvent event) {
        // add code to increment the buttonCount and display it on the button
		buttoncount++;
		System.out.println(jtf.getText());
		button.setText(buttoncount+"");
    }
}
