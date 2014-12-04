import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class QuizDriver3 extends JFrame implements ActionListener
{
	JMenu playMenu;
	JMenu adminMenu;
	static QuizDriver3 runBox;
	int i=0;
	boolean isCorrect,addMore=true;
	String answer="start", question, isCorrectString, addMoreString, choice, answerKey;
	ArrayList<Answer> answers;
	Answer ans;
	Question q1;
		
	
	ArrayList<Question> questions= new ArrayList();
	
	
	public static void main(String[] args)
	{	
		runBox = new QuizDriver3();
		runBox.setVisible(true);
	
	}//end main	
		
	public QuizDriver3()
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
      	 	addNewQuestions();
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
	
}//end class