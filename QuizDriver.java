
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizDriver extends JFrame implements ActionListener
{
	JMenu playMenu;
	JMenu adminMenu;
	Container cPane;
	
	
	public static void main(String[] args)
	{
		QuizDriver runBox = new QuizDriver();
		runBox.setVisible(true);
	}//end main	
		
	public QuizDriver()
	{
		setTitle("Networking Quiz");
		setSize(500,500);
		setLocation(300,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	/*	cPane = getContentPane();
		cPane.setLayout(new FlowLayout());*/
		
		createPlayMenu();
		createAdminMenu();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(playMenu);
		menuBar.add(adminMenu);
		
	}//end constructor	
	
	public void actionPerformed(ActionEvent event)
	{
		String menuName;
		menuName = event.getActionCommand();
		
		if(menuName.equals("10 Questions"))
		{
			JOptionPane.showMessageDialog(null,"you picked 10 quesitons","test response",JOptionPane.PLAIN_MESSAGE);
		}
		else if(menuName.equals("25 Questions"))
		{
			JOptionPane.showMessageDialog(null,"you picked 25 quesitons","test response",JOptionPane.PLAIN_MESSAGE);
		}
		else if(menuName.equals("50 Questions"))
		{
			JOptionPane.showMessageDialog(null,"you picked 50 quesitons","test response",JOptionPane.PLAIN_MESSAGE);
		}
		else if(menuName.equals("Add Question"))
		{
			JOptionPane.showMessageDialog(null,"you picked to add a question","test response",JOptionPane.PLAIN_MESSAGE);
			addQuestion();
		}
		else if(menuName.equals("Edit Question"))
		{
			JOptionPane.showMessageDialog(null,"you picked to edit a question","test response",JOptionPane.PLAIN_MESSAGE);
		}
		else
		{
			System.exit(0);
		}
	}//end action handler
	
	private void createPlayMenu()
	{
		JMenuItem item;
		playMenu = new JMenu("Play");
		
		item = new JMenuItem("10 Questions");
		item.addActionListener(this);
		playMenu.add(item);
		
		item = new JMenuItem("25 Questions");
		item.addActionListener(this);
		playMenu.add(item);
		
		item = new JMenuItem("50 Questions");
		item.addActionListener(this);
		playMenu.add(item);
		
		playMenu.addSeparator();
		
		item = new JMenuItem("Quit");
		item.addActionListener(this);
		playMenu.add(item);	
		
	} // end createPlayMenu method 
	
	private void createAdminMenu()
	{
		JMenuItem item;
		adminMenu = new JMenu("Admin");
		
		item = new JMenuItem("Add Question");
		item.addActionListener(this);
		adminMenu.add(item);
		
		item = new JMenuItem("Edit Question");
		item.addActionListener(this);
		adminMenu.add(item);
		
	}// end createAdminMenu method 
	
	
	private Question addQuestion()
	{
		JLabel question,a,b,c,d,e,f;
		JTextField txtQues,txtA,txtB,txtC,txtD,txtE,txtF;
		JButton btnAdd;
		JPanel p1;
		GridLayout grid;
		
		question = new JLabel("Enter Question:");
		a= new JLabel("Option A");
		b= new JLabel("Option B");
		c= new JLabel("Option C");
		d= new JLabel("Option D");
		e= new JLabel("Option E");
		f= new JLabel("Option F");
		
		txtQues = new JTextField(100);
		txtA = new JTextField(50);
		txtB = new JTextField(50);
		txtC = new JTextField(50);
		txtD = new JTextField(50);
		txtE = new JTextField(50);
		txtF = new JTextField(50);
		
		btnAdd = new JButton("Add Question");  //http://www.codingmagazine.net/2013/01/how-to-create-simple-form-using-java-swing.html
		
		p1 = new JPanel();
		grid = new GridLayout(4,2);
		FlowLayout f1 = new FlowLayout();
		
		
		
		
		
	}
		
	
}//end class