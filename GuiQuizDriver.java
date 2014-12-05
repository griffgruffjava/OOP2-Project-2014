//this is the driver for the quiz gui

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GuiQuizDriver extends JFrame implements ActionListener
{
	//global attributes needed for methods and driver
	JPanel kingPanel, blank, holdAllPanel, questionPanel, optionsPanel, aPanel, bPanel, cPanel, dPanel, ePanel, fPanel;
	JMenu playMenu, adminMenu;
	CardLayout c1 = new CardLayout();
	GridLayout optionsLayout = new GridLayout(5,0);
	Container cPane;
	int i=0;
	JLabel questionLabel,aLabel,bLabel,cLabel,dLabel,eLabel,fLabel;
	JTextField questionField,aField,bField,cField,dField,eField,fField,aTf,bTf,cTf,dTf,eTf,fTf;
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
		runBox1.pack();
	}//end main	
	
	
	//start of driver constructor
	public GuiQuizDriver()
	{
		
		setTitle("Networking Quiz");
	//	setSize(500,500);
		setLocation(100,200);
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
		questionField = new JTextField(null,50);
		questionPanel.add(questionLabel);
		questionPanel.add(questionField);
		
		aLabel = new JLabel("Option A");
		aField = new JTextField(null,20);
		aTf = new JTextField("True/False",10);
		aPanel.add(aLabel);
		aPanel.add(aField);
		aPanel.add(aTf);
		
		bLabel = new JLabel("Option B");
		bField = new JTextField(null,20);
		bTf = new JTextField("True/False",10);
		bPanel.add(bLabel);
		bPanel.add(bField);
		bPanel.add(bTf);
		
		cLabel = new JLabel("Option C");
		cField = new JTextField(null,20);
		cTf = new JTextField("True/False",10);
		cPanel.add(cLabel);
		cPanel.add(cField);
		cPanel.add(cTf);
		
		dLabel = new JLabel("Option D");
		dField = new JTextField(null,20);
		dTf = new JTextField("True/False",10);
		dPanel.add(dLabel);
		dPanel.add(dField);
		dPanel.add(dTf);
		
		eLabel = new JLabel("Option E");
		eField = new JTextField(null,20);
		eTf = new JTextField("True/False",10);
		ePanel.add(eLabel);
		ePanel.add(eField);
		ePanel.add(eTf);
		
		fLabel = new JLabel("Option F");
		fField = new JTextField(null,20);
		fTf = new JTextField("True/False",10);
		fPanel.add(fLabel);
		fPanel.add(fField);
		fPanel.add(fTf);
		
		optionsPanel = new JPanel();
		optionsPanel.setLayout(optionsLayout);
		optionsPanel.add(aPanel);
		optionsPanel.add(bPanel);
		optionsPanel.add(cPanel);
		optionsPanel.add(dPanel);
		optionsPanel.add(ePanel);
		optionsPanel.add(fPanel);
		
		holdAllPanel = new JPanel();
		JButton submit = new JButton("Submit Question");
		submit.addActionListener(this);
	//	FlowLayout flow = new FlowLayout();  not effecting the layout?!?
	//	holdAllPanel.setLayout(flow);
		holdAllPanel.add(questionPanel);
		holdAllPanel.add(optionsPanel);
		holdAllPanel.add(submit);
		holdAllPanel.setBackground(Color.BLUE);
		
		blank = new JPanel();
		blank.add(new JButton("click here"));
		blank.setBackground(Color.GREEN);
		

		kingPanel.add(blank, "2");
		kingPanel.add(holdAllPanel, "1");
		cPane.add(kingPanel, BorderLayout.CENTER);
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
			takeQuiz();
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
		else if(menuName.equals("Submit Question"))
		{
			JOptionPane.showMessageDialog(null,"you picked to edit a question","test response",JOptionPane.PLAIN_MESSAGE);
		//	addNewQuestion();
			try{
      	 	addNewQuestion();
      	 	System.out.print("made it to try");
      	 } // end try
      	 catch (IOException f){
      	 	System.out.print("Not able to save the file:\n"+
      	 	"Check the console printout for clues to why ");
      	 	f.printStackTrace();
      	 }// end catch 
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
	
	
	private void addNewQuestion()throws IOException 
	{
     	
     	try{
      	  ObjectInputStream is;
      	  is = new ObjectInputStream(new FileInputStream ("allQuestion.dat"));
         	questions  = (ArrayList<Question>) is.readObject();
      	  is.close(); 
      	}
      	catch(Exception e){
      	//	this is left empty to prevent exceptions being displayed in output
      	}
     	
	
	//	addMore=true;
	
		//to populate questions 
	//	while(addMore==true)
	//	{
			
			System.out.println("made it here B");
			answers = new ArrayList();
			question=questionField.getText();
		
			intakeOptions();

			
			q1 = new Question(question,answers);
		//	System.out.println(q1.toStringFull()); //to test that questions are being made
			
		/*	addMoreString=JOptionPane.showInputDialog("Do you want to add another question (y/n)?");
			if(addMoreString.charAt(0)=='n'||addMoreString.charAt(0)=='N')
			{
				addMore=false;
				System.out.println("you said stop " + addMoreString.charAt(0));
			}
			else
			{
				addMore=true;
				System.out.println("you said add more " + addMoreString.charAt(0) );	
			}*/
			
			questions.add(q1);
			
			try{
      	 		save();//method to save questions ArrayList to dat file
      	 		System.out.println("Questions saved successfully");
      	 	} // try
      	 	catch (IOException f){
      	 		System.out.println("Not able to save the file:\n"+
      	 		"Check the console printout for clues to why ");
      	 		f.printStackTrace();
      	 	}// catch
      	 	
      	 c1.show(kingPanel,"2");	
			
				
	//	}//end of outer loop for making whole questions
		
	}//end of addNewQuestions method	
	
	
		//method to write questions ArryList to dat file
	public void save() throws IOException
    {
      	ObjectOutputStream os;
      	os = new ObjectOutputStream(new FileOutputStream ("allQuestion.dat"));
      	os.writeObject(questions);
      	os.close();
    }	
    	
    
    	private void takeQuiz()
	{
			
		//staring test quiz
		int n=0;
		double totalRight=0,totalQuestion=0;
		
		for(Question q: questions)
		{
			q1=questions.get(n);
			answerKey=q1.getKey();
			
			choice=JOptionPane.showInputDialog(q1.toString()+"\n\nYour Answer");
			
			totalRight+=scoreAnswers(answerKey,choice);
			totalQuestion++;	
			n++;	
		}
		
		JOptionPane.showMessageDialog(null,"You scored " + ((totalRight/totalQuestion)*100) + "% on this quiz","Quiz Results",JOptionPane.INFORMATION_MESSAGE);
		
	}//end takeQuiz() method
	
	
	//this method will tabulate the score for takeQuiz method
	public static double scoreAnswers(String key,String choices)
	{
		int outOf=key.length();
		double questionScore=0,score=0;
		char pick;
		
		if(choices.length()>key.length())
		{
			return questionScore;
		}
		else
		{	
			for(int i=0;i<choices.length();i++)
			{
				pick=choices.charAt(i);
				
				for(int n=0;n<key.length();n++)
				{
					if(pick==key.charAt(n))
						score++;
				}
			}
			
			questionScore=(score/outOf);
		}//end if/else
		
		return questionScore;
				
	}//end scoreAnswers() method
	
	
	private void intakeOptions()
	{
			answer=aField.getText(); 
			
			if(!answer.equals(""))
			{
				isCorrectString=aTf.getText();
					
				if(isCorrectString.charAt(0)=='f'||isCorrectString.charAt(0)=='F')
					isCorrect=false;
				else
					isCorrect=true;	
					
				ans = new Answer(answer,isCorrect);
				answers.add(ans);			
			}
			
			answer=bField.getText();
			
			if(!answer.equals(""))
			{
				isCorrectString=bTf.getText();
					
				if(isCorrectString.charAt(0)=='f'||isCorrectString.charAt(0)=='F')
					isCorrect=false;
				else
					isCorrect=true;	
					
				ans = new Answer(answer,isCorrect);
				answers.add(ans);			
			}
			
			answer=cField.getText();
			
			if(!answer.equals(""))
			{
				isCorrectString=cTf.getText();
					
				if(isCorrectString.charAt(0)=='f'||isCorrectString.charAt(0)=='F')
					isCorrect=false;
				else
					isCorrect=true;	
					
				ans = new Answer(answer,isCorrect);
				answers.add(ans);			
			}
			
			answer=dField.getText();
			
			if(!answer.equals(""))
			{
				isCorrectString=dTf.getText();
					
				if(isCorrectString.charAt(0)=='f'||isCorrectString.charAt(0)=='F')
					isCorrect=false;
				else
					isCorrect=true;	
					
				ans = new Answer(answer,isCorrect);
				answers.add(ans);			
			}
			
			answer=eField.getText();
			
			if(!answer.equals(""))
			{
				isCorrectString=eTf.getText();
					
				if(isCorrectString.charAt(0)=='f'||isCorrectString.charAt(0)=='F')
					isCorrect=false;
				else
					isCorrect=true;	
					
				ans = new Answer(answer,isCorrect);
				answers.add(ans);			
			}
			
			answer=fField.getText();
			
			if(!answer.equals(""))
			{
				isCorrectString=fTf.getText();
					
				if(isCorrectString.charAt(0)=='f'||isCorrectString.charAt(0)=='F')
					isCorrect=false;
				else
					isCorrect=true;	
					
				ans = new Answer(answer,isCorrect);
				answers.add(ans);			
			}
	
	}//end of intake method
	
}//end class	