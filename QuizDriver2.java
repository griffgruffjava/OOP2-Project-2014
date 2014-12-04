import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class QuizDriver2 extends JFrame implements ActionListener
{
	JMenu playMenu;
	JMenu adminMenu;
	static QuizDriver2 runBox;
	int i=0;
	boolean isCorrect,addMore=true;
	String answer="start", question, isCorrectString, addMoreString, choice, answerKey;
	ArrayList<Answer> answers;
	Answer ans;
	Question q1;
		
	
	ArrayList<Question> questions= new ArrayList();
	
	
	public static void main(String[] args)
	{	
		runBox = new QuizDriver2();
		runBox.setVisible(true);
	
	}//end main	
		
	public QuizDriver2()
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
	
	
	private void addQuestion()
	{
		JLabel question,a,b,c,d,e,f;
		JTextField txtQues,txtA,txtB,txtC,txtD,txtE,txtF;
		JButton btnAdd;
		JPanel p1;
		GridLayout grid;
		//QuizDriver runBox2 = new QuizDriver();
		
		//runBox2.setVisible(true);
		
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
		
		p1.setLayout(grid);
		
		p1.add(question);
		p1.add(txtQues);
		
		p1.add(a);
		p1.add(txtA);
		
		p1.add(b);
		p1.add(txtB);
		
		p1.add(c);
		p1.add(txtC);
		
		p1.add(d);
		p1.add(txtD);
		
		p1.add(e);
		p1.add(txtE);
		
		p1.add(f);
		p1.add(txtF);
		
		p1.add(btnAdd);
		
	//	cPane.add(f1);
      runBox.add(p1);
		
	//	return p1;
		
		
		
	}//end addQuestion method
	
	private void addNewQuestions()throws IOException 
	{
      //	File inFile = new File("allQuestions");
      	
      //	FileInputStream inStream = new FileInputStream(inFile);
      //	FileOutputStream outStream = new FileOutputStream(outFile);
     // 	DataInputStream inDataStream = new DataInputStream(inStream);
     // 	DataOutputStream outDataStream = new DataOutputStream(outStream);
     	
     	try{
      	  ObjectInputStream is;
      	  is = new ObjectInputStream(new FileInputStream ("allQuestions.dat"));
         	questions  = (ArrayList<Question>) is.readObject();
      	  is.close(); 
      	}
      	catch(Exception e){
      		JOptionPane.showMessageDialog(null,"open didn't work");
      		e.printStackTrace();
      	}
     	
	
		addMore=true;
		System.out.println("made it here A");
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
				//	System.out.println(ans.toString());  -tests that Answer object is made
					answers.add(ans);		
				}
				
				i++;	
			}//end of inner while loop for adding answers
			
			//reset counter and answer
			i=0;
			answer="temp";
			
			q1 = new Question(question,answers);
			System.out.println(q1.toStringFull());
		/*	q1 = new Question();
			q1.setQuestion(question);
			q1.setAns(answers);	*/
			
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
			
			FileOutputStream outFile = new FileOutputStream("allQuestions");
			ObjectOutputStream os = new ObjectOutputStream(outFile);
			os.writeObject(questions);
			os.close();
				
		}//end of outer loop for making whole questions
		
	}//end of addNewQuestions method	
	
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
	
}//end class