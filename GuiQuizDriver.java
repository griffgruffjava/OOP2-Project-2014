//this is the driver for the quiz gui

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GuiQuizDriver extends JFrame implements ActionListener
{
	//global attributes needed for methods and driver
	JPanel kingPanel, blank, holdAllPanel, questionPanel, aPanel, bPanel, cPanel, dPanel, ePanel, fPanel;
	JMenu playMenu, adminMenu;
	CardLayout c1 = new CardLayout();
	Container cPane;
	int i=0;
	JLabel questionLabel,aLabel,bLabel,cLabel,dLabel,eLabel,fLabel;
	JTextField questionField,aField,bField,cField,dField,eField,fField;
	boolean isCorrect,addMore=true;
	String answer="start", question, isCorrectString, addMoreString, choice, answerKey;
	ArrayList<Answer> answers;
	Answer ans;
	Question q1;
	ArrayList<Question> questions= new ArrayList();
	
	
	//main start
	public static void main(String[] args)
	{	
		GuiQuizDriver runBox1 = new GuiQuizDriver();
		runBox1.setVisible(true);
	}//end main	
	
	
	//start of driver constructor
	public GuiQuizDriver()
	{
		
		setTitle("Networking Quiz");
		setSize(500,500);
		setLocation(500,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		cPane = getContentPane();
		
		//methods to add menu items
		createPlayMenu();
		createAdminMenu();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(playMenu);
		menuBar.add(adminMenu);
		
		//my panels
		kingPanel= new JPanel();
		kingPanel.setLayout(c1);
		
		questionPanel = new JPanel();
		aPanel = new JPanel();
		bPanel = new JPanel();
		cPanel = new JPanel();
		dPanel = new JPanel();
		ePanel = new JPanel();
		fPanel = new JPanel();
		
		questionLabel = new JLabel("Please enter the question");
		questionField = new JTextField(null,20);
		questionPanel.add(questionLabel);
		questionPanel.add(questionField);
		
		aLabel = new JLabel("Option A");
		aField = new JTextField(null,20);
		aPanel.add(aLabel);
		aPanel.add(aField);
		
		bLabel = new JLabel("Option B");
		bField = new JTextField(null,20);
		bPanel.add(bLabel);
		bPanel.add(bField);
		
		cLabel = new JLabel("Option C");
		cField = new JTextField(null,20);
		cPanel.add(cLabel);
		cPanel.add(cField);
		
		dLabel = new JLabel("Option D");
		dField = new JTextField(null,20);
		dPanel.add(dLabel);
		dPanel.add(dField);
		
		eLabel = new JLabel("Option E");
		eField = new JTextField(null,20);
		ePanel.add(eLabel);
		ePanel.add(eField);
		
		fLabel = new JLabel("Option F");
		fField = new JTextField(null,20);
		fPanel.add(fLabel);
		fPanel.add(fField);
		
		holdAllPanel = new JPanel();
		holdAllPanel.add(questionPanel);
		holdAllPanel.add(aPanel);
		holdAllPanel.add(bPanel);
		holdAllPanel.add(cPanel);
		holdAllPanel.add(dPanel);
		holdAllPanel.add(ePanel);
		holdAllPanel.add(fPanel);
		holdAllPanel.setBackground(Color.BLUE);
		
		blank = new JPanel();
		blank.add(new JButton("click here"));
		blank.setBackground(Color.GREEN);
		

		kingPanel.add(blank, "2");
		kingPanel.add(holdAllPanel, "1");
		cPane.add(kingPanel, BorderLayout.PAGE_START);
	//	c1.show(kingPanel,"blank"); //don't think i need this here
		
		this.add(kingPanel);
		
	}//end constructor
	
	
	//my event handler method for menu items
	public void actionPerformed(ActionEvent event)
	{
		String menuName;
		menuName = event.getActionCommand();
		
		if(menuName.equals("10 Questions"))
		{
			JOptionPane.showMessageDialog(null,"you picked 10 quesitons","test response",JOptionPane.PLAIN_MESSAGE);
		//	takeQuiz();
		}
		else if(menuName.equals("25 Questions"))
		{
			
			JOptionPane.showMessageDialog(null,"you picked 25 quesitons","test response",JOptionPane.PLAIN_MESSAGE);
			testAddingToFrame();
		}
		else if(menuName.equals("50 Questions"))
		{
			JOptionPane.showMessageDialog(null,"you picked 50 quesitons","test response",JOptionPane.PLAIN_MESSAGE);
		}
		else if(menuName.equals("Add Question"))
		{
			JOptionPane.showMessageDialog(null,"you picked to add a question","test response",JOptionPane.PLAIN_MESSAGE);
			
			System.out.println("made it here c");
		//	addNewQuestions();
	/*	try{
      	// 	addFrameQuestions();
      	 	System.out.print("made it to try");
      	 } // try
      	 catch (IOException f){
      	 	System.out.print("Not able to save the file:\n"+
      	 	"Check the console printout for clues to why ");
      	 	f.printStackTrace();
      	 }// catch */
			
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
	
	
	//method to create PlayMenu items
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
	
	
	//method to create AdminMenu items
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
	
	
	private void testAddingToFrame()
	{
	
		System.out.println("made into test method");
		c1.show(kingPanel,"1");
		
	}//END OF TESTING METHOD
	
}//end class	