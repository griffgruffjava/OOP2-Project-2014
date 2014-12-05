/*this will attempt to put JOP input/outputs onto gui jframe */


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class QuizDriver4 extends JFrame implements ActionListener
{
	JPanel kingPanel;
	JPanel blank;
	JPanel questionPanel;
	JMenu playMenu;
	JMenu adminMenu;
	CardLayout c1 = new CardLayout();
	Container cPane;
//	static QuizDriver4 runBox1;
	int i=0;
	JLabel questionLabel,aLabel,bLabel,cLabel,dLabel,eLabel,fLabel;
	JTextField questionField,aField,bField,cField,dField,eField,fField;
	boolean isCorrect,addMore=true;
	String answer="start", question, isCorrectString, addMoreString, choice, answerKey;
	ArrayList<Answer> answers;
	Answer ans;
	Question q1;
	
		
	
	ArrayList<Question> questions= new ArrayList();
	
	
	public static void main(String[] args)
	{	
		QuizDriver4 runBox1 = new QuizDriver4();
		runBox1.setVisible(true);
	}//end main	
		
	public QuizDriver4()
	{
		
		setTitle("Networking Quiz");
		setSize(500,500);
		setLocation(500,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cPane = getContentPane();
	//	cPaneInAss.setLayout(null);
	//	cPane.setBackground (Color.blue); test to see if cPane was working
		createPlayMenu();
		createAdminMenu();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(playMenu);
		menuBar.add(adminMenu);
		
		
	//	CardLayout c1 = new CardLayout();
		kingPanel= new JPanel();
		kingPanel.setLayout(c1);
		questionPanel = new JPanel();
		questionPanel.setBackground(Color.BLUE);
		questionLabel = new JLabel("Please enter the question");
		questionField = new JTextField(null,20);
		aLabel = new JLabel("Option A");
		aField = new JTextField(null,20);
		bLabel = new JLabel("Option B");
		bField = new JTextField(null,20);
		questionPanel.add(questionLabel);
		questionPanel.add(questionField);
		questionPanel.add(aLabel);
		questionPanel.add(aField);
		questionPanel.add(bLabel);
		questionPanel.add(bField);
		
		blank = new JPanel();
		blank.add(new JButton("click here"));
		blank.setBackground(Color.GREEN);
		
//		JPanel kingPanel = new JPanel();
		kingPanel.add(blank, "2");
		kingPanel.add(questionPanel, "1");
	//	kingPanel.add(blank, "2");
		
	//	card1.add(new JTextField("TextField",20));
	//	questionField = new JTextField(null,20);
	//	questionField.setBounds(110,130,80,40);
	//	runBox.add(questionLabel);
	//	runBox.add(questionField);
	//	p1.add(questionLabel);
	//	p1.add(questionField);
		cPane.add(kingPanel, BorderLayout.PAGE_START);
		
		
		
		
		
//	c1.show(kingPanel,"blank");
		
		this.add(kingPanel);
		
	/*	JPanel card1 = new JPanel();
		
		questionLabel = new JLabel("This is a test");
	//	card1.add(new JTextField("TextField",20));
		questionField = new JTextField(null,20);
	//	questionField.setBounds(110,130,80,40);
	//	runBox.add(questionLabel);
	//	runBox.add(questionField);
		card1.add(questionLabel);
		card1.add(questionField); 
		cPane.add(card1, BorderLayout.PAGE_START); */
		
		 
	}//end constructor	
	
	
	//my event handler method for menu items
	public void actionPerformed(ActionEvent event)
	{
		String menuName;
		menuName = event.getActionCommand();
		
		if(menuName.equals("10 Questions"))
		{
			JOptionPane.showMessageDialog(null,"you picked 10 quesitons","test response",JOptionPane.PLAIN_MESSAGE);
			takeQuiz();
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
		try{
      	 	addFrameQuestions();
      	 	System.out.print("made it to try");
      	 } // try
      	 catch (IOException f){
      	 	System.out.print("Not able to save the file:\n"+
      	 	"Check the console printout for clues to why ");
      	 	f.printStackTrace();
      	 }// catch 
			
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
	
	

	
	private void addNewQuestions()throws IOException 
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
     	
	
		addMore=true;
	
		//to populate questions 
		while(addMore==true)
		{
			
			System.out.println("made it here B");
			answers = new ArrayList();
			question=JOptionPane.showInputDialog("What is the question?");
		
		
			while(i<6 && !answer.equals(""))
			{
				answer=JOptionPane.showInputDialog("Add an optional answer(hit enter to add no more options)");
				
				if(!answer.equals(""))
				{
					isCorrectString=JOptionPane.showInputDialog("Is this option true or false");
					
					if(isCorrectString.charAt(0)=='f'||isCorrectString.charAt(0)=='F')
						isCorrect=false;
					else
						isCorrect=true;	
					
					
					ans = new Answer(answer,isCorrect);
					answers.add(ans);		
				}
				
				i++;	
			}//end of inner while loop for adding answers
			
			//reset counter and answer
			i=0;
			answer="temp";
			
			q1 = new Question(question,answers);
		//	System.out.println(q1.toStringFull()); //to test that questions are being made
			
			addMoreString=JOptionPane.showInputDialog("Do you want to add another question (y/n)?");
			if(addMoreString.charAt(0)=='n'||addMoreString.charAt(0)=='N')
			{
				addMore=false;
				System.out.println("you said stop " + addMoreString.charAt(0));
			}
			else
			{
				addMore=true;
				System.out.println("you said add more " + addMoreString.charAt(0) );	
			}
			
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
      	 	
      	 	
			

				
		}//end of outer loop for making whole questions
		
	}//end of addNewQuestions method	
	
	
	
	
	private void addFrameQuestions()throws IOException 
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
     	
		
		
		
		
		addMore=true;
	
		//to populate questions 
		while(addMore==true)
		{
			
			System.out.println("made it here B");
			answers = new ArrayList();
			question=JOptionPane.showInputDialog("What is the question?");
		
		
			while(i<6 && !answer.equals(""))
			{
				answer=JOptionPane.showInputDialog("Add an optional answer(hit enter to add no more options)");
				
				if(!answer.equals(""))
				{
					isCorrectString=JOptionPane.showInputDialog("Is this option true or false");
					
					if(isCorrectString.charAt(0)=='f'||isCorrectString.charAt(0)=='F')
						isCorrect=false;
					else
						isCorrect=true;	
					
					
					ans = new Answer(answer,isCorrect);
					answers.add(ans);		
				}
				
				i++;	
			}//end of inner while loop for adding answers
			
			//reset counter and answer
			i=0;
			answer="temp";
			
			q1 = new Question(question,answers);
		//	System.out.println(q1.toStringFull()); //to test that questions are being made
			
			addMoreString=JOptionPane.showInputDialog("Do you want to add another question (y/n)?");
			if(addMoreString.charAt(0)=='n'||addMoreString.charAt(0)=='N')
			{
				addMore=false;
				System.out.println("you said stop " + addMoreString.charAt(0));
			}
			else
			{
				addMore=true;
				System.out.println("you said add more " + addMoreString.charAt(0) );	
			}
			
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
      	 	
      	 	
			

				
		}//end of outer loop for making whole questions
		
	}//end of addNewQuestions method
	// start of basic quiz method 
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
	
	
	//method to write questions ArryList to dat file
	public void save() throws IOException
    {
      	ObjectOutputStream os;
      	os = new ObjectOutputStream(new FileOutputStream ("allQuestion.dat"));
      	os.writeObject(questions);
      	os.close();
    }
    
    private void testAddingToFrame()
	{
		
		/*		FIRST TRY
		questionLabel = new JLabel("This is a test");
		questionField = new JTextField();
	//	questionField.setBounds(110,130,80,40);
	//	runBox.add(questionLabel);
	//	runBox.add(questionField);
		cPane.add(questionLabel);
		cPane.add(questionField);*/
		
		System.out.println("made into test method");
		//SECOND TRY
		
		/*
		JPanel questionPanel = new JPanel();
		questionLabel = new JLabel("Please enter the question");
		questionField = new JTextField(null,20);
		aLabel = new JLabel("Option A");
		aField = new JTextField(null,20);
		bLabel = new JLabel("Option B");
		bField = new JTextField(null,20);
		questionPanel.add(questionLabel);
		questionPanel.add(questionField);
		questionPanel.add(aLabel);
		questionPanel.add(aField);
		questionPanel.add(bLabel);
		questionPanel.add(bField);
		
		JPanel blank = new JPanel();
		
		JPanel kingPanel = new JPanel();
		kingPanel.add(questionPanel, "add question box");
		kingPanel.add(blank, "blank");
		
	//	card1.add(new JTextField("TextField",20));
	//	questionField = new JTextField(null,20);
	//	questionField.setBounds(110,130,80,40);
	//	runBox.add(questionLabel);
	//	runBox.add(questionField);
	//	p1.add(questionLabel);
	//	p1.add(questionField);
		cPane.add(kingPanel, BorderLayout.PAGE_START);*/
		
	//	CardLayout c1 = (CardLayout)(kingPanel.getLayout());
		
		c1.show(kingPanel,"1");
		
	//	kingPanel.add(questionPanel, "1");
		
	}//END OF TESTING METHOD
	
}//end class