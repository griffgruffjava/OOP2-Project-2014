
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class testDriver extends JFrame implements ActionListener
{
	JMenu playMenu;
	JMenu adminMenu;
	
	
	public static void main(String[] args)
	{
		testDriver myFrame = new testDriver();
		myFrame.setVisible(true);
	}
	
	
	public testDriver()
	{
		setTitle("Please work");
		setSize(200,450);
		setLocation(300,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createPlayMenu();
		
		
	}
	
	
}