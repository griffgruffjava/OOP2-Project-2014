//this is the driver for the quiz gui

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.awt.*;
import javax.swing.*;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuiQuizDriver extends JFrame implements ActionListener {
	
	
	// global attributes needed for methods and driver
	JPanel kingPanel, blank, holdAllPanel, questionPanel, optionsPanel, aPanel,
			bPanel, cPanel, dPanel, ePanel, fPanel;
	JMenu playMenu, adminMenu;
	CardLayout c1 = new CardLayout();
	GridLayout optionsLayout = new GridLayout(6, 3);
	Container cPane;
	int i = 0;
	JLabel questionLabel, aLabel, bLabel, cLabel, dLabel, eLabel, fLabel, blankLabel;
	JTextField questionField, aField, bField, cField, dField, eField, fField,
			aTf, bTf, cTf, dTf, eTf, fTf;
	boolean isCorrect, addMore = true;
	String answer = "start", question, isCorrectString, addMoreString, choice,
			answerKey,resultString="Welcome to the QUIZ";
	ArrayList<Answer> answers;
	Answer ans;
	Question q1;
	ArrayList<Question> questions = new ArrayList<Question>();

	// main start
	public static void main(String[] args) {
		GuiQuizDriver runBox1 = new GuiQuizDriver();
		runBox1.setVisible(true);
		runBox1.pack();
	}// end main

	// start of driver constructor
	public GuiQuizDriver() {

		setTitle("Networking Quiz");
		// setSize(500,500);
		setLocation(100, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		cPane = getContentPane();

		// methods to add menu items
		/*Title:JMenuFrame.java
    	 *Author:John Walsh
	     *date:06/11/2014 15:37
         *Availability: X-Drive\John W\Sample Programs\Units13_15
	     *Comment: I used this code create my Menu items
         */
		createPlayMenu();
		createAdminMenu();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(playMenu);
		menuBar.add(adminMenu);

		// my panels
		kingPanel = new JPanel();
		kingPanel.setLayout(c1);

		questionPanel = new JPanel();
		questionLabel = new JLabel("Please enter the question");
		questionField = new JTextField(null, 50);
		questionField.grabFocus();
		questionPanel.add(questionLabel);
		questionPanel.add(questionField);

		aLabel = new JLabel("Option A");
		aField = new JTextField(null, 20);
		aTf = new JTextField("True/False", 10);

		bLabel = new JLabel("Option B");
		bField = new JTextField(null, 20);
		bTf = new JTextField("True/False", 10);

		cLabel = new JLabel("Option C");
		cField = new JTextField(null, 20);
		cTf = new JTextField("True/False", 10);

		dLabel = new JLabel("Option D");
		dField = new JTextField(null, 20);
		dTf = new JTextField("True/False", 10);

		eLabel = new JLabel("Option E");
		eField = new JTextField(null, 20);
		eTf = new JTextField("True/False", 10);

		fLabel = new JLabel("Option F");
		fField = new JTextField(null, 20);
		fTf = new JTextField("True/False", 10);

		
		optionsPanel = new JPanel();
		optionsPanel.setLayout(optionsLayout);
		optionsPanel.add(aLabel);
		optionsPanel.add(aField);
		optionsPanel.add(aTf);
		optionsPanel.add(bLabel);
		optionsPanel.add(bField);
		optionsPanel.add(bTf);
		optionsPanel.add(cLabel);
		optionsPanel.add(cField);
		optionsPanel.add(cTf);
		optionsPanel.add(dLabel);
		optionsPanel.add(dField);
		optionsPanel.add(dTf);
		optionsPanel.add(eLabel);
		optionsPanel.add(eField);
		optionsPanel.add(eTf);
		optionsPanel.add(fLabel);
		optionsPanel.add(fField);
		optionsPanel.add(fTf);
		

		holdAllPanel = new JPanel();
		JButton submit = new JButton("Submit Question");
		submit.addActionListener(this);
		
		holdAllPanel.add(questionPanel);
		holdAllPanel.add(optionsPanel);
		holdAllPanel.add(submit);
		holdAllPanel.setBackground(Color.BLUE);

		blank = new JPanel();
		blank.setBackground(Color.GREEN);
		
		blankLabel = new JLabel(resultString); 
	
		blankLabel.setFont(new Font("Serif", Font.PLAIN, 54));
		blank.add(blankLabel);
		/*Title:How to change the size of the font of a JLabel to take the maximum size
		 *Author:Asaf David
		 *Date:Apr 26'10 at 16:33
		 *Availability:http://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-the-maximum-size
		 *Comment: I used this bit of code in order to resize my JLabel on the landing panel(blankPanel)
		 */
		
		kingPanel.add(blank, "2");
		kingPanel.add(holdAllPanel, "1");
		/*Title: CardLayoutEX.java
		 *Author: John Walsh
		 *Date:02/12/2014 09:25
		 *Availability: X-Drive\John W\Sample Programs\Multiple Panels
		 *Comment: I  used this to deal with how to display panels at different times during runtime
		 */
		cPane.add(kingPanel, BorderLayout.CENTER);


		this.add(kingPanel);
		
		/*Title: BicyleFrame4.java
		 *Author:John Walsh
		 *date:05/12/2014 12:41
		 *Availability: X-Drive\John W\Sample Programs\Units16_18
		 *Comment: I used this code to model my own input/output streams and to save dat files
		 */
		try {
			System.out.println("made into addNewQuestion() try1");
			ObjectInputStream is;
			is = new ObjectInputStream(new FileInputStream("allQuestion.dat"));
			questions = (ArrayList<Question>) is.readObject();
			is.close();
		} catch (Exception e) {
			System.out.println("made into addNewQuestion() catch1");
			// this is left empty to prevent exceptions being displayed in
			// output
		} 

	}// end constructor

	// my event handler method for menu items
	/*Title:JMenuFrame.java
	 *Author:John Walsh
	 *date:06/11/2014 15:37
     *Availability: X-Drive\John W\Sample Programs\Units13_15
	 *Comment: I used this code to model my own event handling
     */
	public void actionPerformed(ActionEvent event) {
		String menuName;
		menuName = event.getActionCommand();

		if (menuName.equals("10 Questions")) {
			JOptionPane.showMessageDialog(null, "you picked 10 quesitons",
					"test response", JOptionPane.PLAIN_MESSAGE);
			// takeQuiz();
		} else if (menuName.equals("25 Questions")) {

			System.out.println("25 Questions");
			
		} else if (menuName.equals("50 Questions")) {
			JOptionPane.showMessageDialog(null, "you picked 50 quesitons",
					"test response", JOptionPane.PLAIN_MESSAGE);
			try {
				takeQuiz();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (menuName.equals("Add Question")) {

			newQuestionForm();

		} else if (menuName.equals("Edit Question")) {
			
			try {
				deleteQuestion();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (menuName.equals("Submit Question")) {
			
			try {
				addNewQuestion();
				System.out.print("made it to try");
			} // end try
			catch (IOException f) {
				System.out.print("Not able to save the file:\n"
						+ "Check the console printout for clues to why ");
				f.printStackTrace();
			}// end catch
		} else {
			System.exit(0);
		}
	}// end action handler

	// method to create PlayMenu items
	private void createPlayMenu() {
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

	// method to create AdminMenu items
	private void createAdminMenu() {
		JMenuItem item;
		adminMenu = new JMenu("Admin");

		item = new JMenuItem("Add Question");
		item.addActionListener(this);
		adminMenu.add(item);

		item = new JMenuItem("Edit Question");
		item.addActionListener(this);
		adminMenu.add(item);

	}// end createAdminMenu method

	private void newQuestionForm() {

		System.out.println("made into test method");
		c1.show(kingPanel, "1");

	}// END OF TESTING METHOD

	private void addNewQuestion() throws IOException {

	/*	try {
			System.out.println("made into addNewQuestion() try1");
			ObjectInputStream is;
			is = new ObjectInputStream(new FileInputStream("allQuestion.dat"));
			questions = (ArrayList<Question>) is.readObject();
			is.close();
		} catch (Exception e) {
			System.out.println("made into addNewQuestion() catch1");
			// this is left empty to prevent exceptions being displayed in
			// output
		} */

	/*	c1.show(kingPanel, "1");
		System.out.println("made it here B");
		answers = new ArrayList<Answer>(); */
		question = questionField.getText(); 
		questionField.setText("");	
		System.out.println("made into addNewQuestion() before intakeOptions()");
		intakeOptions();
		System.out.println("made into addNewQuestion() after intakeOptions()");
		q1 = new Question(question, answers);
		questions.add(q1); 

		try {
			save();// method to save questions ArrayList to dat file
			System.out.println("made into addNewQuestion() try2 and question has been saved");
		} // try
		catch (IOException f) {
			System.out.println("made into addNewQuestion() catch2");
			f.printStackTrace();
		}// catch

		c1.show(kingPanel, "2");

		

	}// end of addNewQuestions method
	
	

	// method to write questions ArryList to dat file
	public void save() throws IOException {
		ObjectOutputStream os;
		os = new ObjectOutputStream(new FileOutputStream("allQuestion.dat"));
		os.writeObject(questions);
		os.close();
	}
	
	

	private void takeQuiz() throws IOException {


		// staring test quiz
		int n = 0;
		double totalRight = 0, totalQuestion = 0;

		for (Question q1 : questions) {
			q1 = questions.get(n);
			answerKey = q1.getKey();

			choice = JOptionPane.showInputDialog(q1.toString()
					+ "\n\nYour Answer");

			totalRight += scoreAnswers(answerKey, choice);
			totalQuestion++;
			n++;
		}
		resultString="You scored " +String.format("%.0f",((totalRight / totalQuestion) * 100))+"%"; // String.format("$%.2f",creditLimit) +String.format("%.1f",((totalRight / totalQuestion) * 100)+"%");
		blankLabel.setText(resultString);
	/*	JOptionPane.showMessageDialog(null, "You scored "
				+ ((totalRight / totalQuestion) * 100) + "% on this quiz",
				"Quiz Results", JOptionPane.INFORMATION_MESSAGE); */
		
		
	}// end takeQuiz() method
	
	private void take10Quiz() throws IOException {


		// staring test quiz
		int n = 0;
		double totalRight = 0, totalQuestion = 0;

		for (Question q1 : questions) {
			q1 = questions.get(n);
			answerKey = q1.getKey();

			choice = JOptionPane.showInputDialog(q1.toString()
					+ "\n\nYour Answer");

			totalRight += scoreAnswers(answerKey, choice);
			totalQuestion++;
			n++;
		}
		resultString="You scored " +String.format("%.0f",((totalRight / totalQuestion) * 100))+"%"; // String.format("$%.2f",creditLimit) +String.format("%.1f",((totalRight / totalQuestion) * 100)+"%");
		blankLabel.setText(resultString);
	/*	JOptionPane.showMessageDialog(null, "You scored "
				+ ((totalRight / totalQuestion) * 100) + "% on this quiz",
				"Quiz Results", JOptionPane.INFORMATION_MESSAGE); */
		
		
	}// end take10Quiz() method

	// this method will tabulate the score for takeQuiz method
	public static double scoreAnswers(String key, String choices) {
		int outOf = key.length();
		double questionScore = 0, score = 0;
		char pick;

		if (choices.length() > key.length()) {
			return questionScore;
		} else {
			for (int i = 0; i < choices.length(); i++) {
				pick = choices.charAt(i);

				for (int n = 0; n < key.length(); n++) {
					if (pick == key.charAt(n))
						score++;
				}
			}

			questionScore = (score / outOf);
		}// end if/else

		return questionScore;

	}// end scoreAnswers() method

	private void intakeOptions() {
		String answerA,answerB,answerC,answerD,answerE,answerF;
		answers = new ArrayList<Answer>();
		answerA = aField.getText();
		aField.setText("");

		if (!answerA.equals("")) {
			
			isCorrectString = aTf.getText();
			aTf.setText("True/False");
			
			if (isCorrectString.charAt(0) == 'f'
					|| isCorrectString.charAt(0) == 'F')
				isCorrect = false;
			else
				isCorrect = true;
			
			ans = new Answer(answerA, isCorrect);
			answers.add(ans);	
		}

		answerB = bField.getText();
		bField.setText("");

		if (!answerB.equals("")) {
			
			
			isCorrectString = bTf.getText();
			bTf.setText("True/False");

			if (isCorrectString.charAt(0) == 'f'
					|| isCorrectString.charAt(0) == 'F')
				isCorrect = false;
			else
				isCorrect = true;

			ans = new Answer(answerB, isCorrect);
			answers.add(ans);
			
		}

		answerC = cField.getText();
		cField.setText("");

		if (!answerC.equals("")) {
			
		
			isCorrectString = cTf.getText();
			cTf.setText("True/False");

			if (isCorrectString.charAt(0) == 'f'
					|| isCorrectString.charAt(0) == 'F')
				isCorrect = false;
			else
				isCorrect = true;

			ans = new Answer(answerC, isCorrect);
			answers.add(ans);
			
		}

		answerD = dField.getText();
		dField.setText("");

		if (!answerD.equals("")) {
			
			isCorrectString = dTf.getText();
			dTf.setText("True/False");

			if (isCorrectString.charAt(0) == 'f'
					|| isCorrectString.charAt(0) == 'F')
				isCorrect = false;
			else
				isCorrect = true;

			ans = new Answer(answerD, isCorrect);
			answers.add(ans);
			
		}

		answerE = eField.getText();
		eField.setText("");

		if (!answerE.equals("")) {
			
			isCorrectString = eTf.getText();
			eTf.setText("True/False");

			if (isCorrectString.charAt(0) == 'f'
					|| isCorrectString.charAt(0) == 'F')
				isCorrect = false;
			else
				isCorrect = true;

			ans = new Answer(answerE, isCorrect);
			answers.add(ans);
		}

		answerF = fField.getText();
		fField.setText("");

		if (!answerF.equals("")) {
			
			isCorrectString = fTf.getText();
			fTf.setText("True/False");

			if (isCorrectString.charAt(0) == 'f'
					|| isCorrectString.charAt(0) == 'F')
				isCorrect = false;
			else
				isCorrect = true;

			ans = new Answer(answerF, isCorrect);
			answers.add(ans);
		}
		
		

	}// end of intake method
	
	public void deleteQuestion() throws IOException
	{
		

		
		System.out.println("made it into deleteQuestion method");
		
		String[] buttons = { "Delete Question", "Keep Question"};
		
		for(int g=0;g<questions.size();g++)
		{
			
			q1 = questions.get(g);
		    
			int returnValue = JOptionPane.showOptionDialog(null, q1.toStringFull(), "Delete Quiz Question",JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[i]);
			System.out.println(returnValue);
			
			if(returnValue==0)
			{
				System.out.println("into delete if");
				questions.remove(g);
			} 
			
			
		}
		
		
	}//end deleteQuestion method

}// end class	