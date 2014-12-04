import javax.swing.*;
import java.awt.*;
/** demonstrates a subclass of JFrame */
public class MyJFrame1 extends JFrame {

    public static void main (String [] args) {
       	MyJFrame1 mine = new MyJFrame1();
        mine.setVisible(true);
    }

    public MyJFrame1 () {
        setTitle ("This is a \"MyJFrame1\" object");
        setSize (300, 500);

        setDefaultCloseOperation( EXIT_ON_CLOSE );
        Container contentPane = getContentPane();
        contentPane.setBackground (Color.BLUE);
    }
}
