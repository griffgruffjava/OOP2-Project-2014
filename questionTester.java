//this will make some questions using the answer and question classes

import javax.swing.*;
import java.util.*;

public class questionTester
{
	public static void main(String args[])
	{
		int i=0;
		boolean isCorrect,addMore=true;
		String answer="start", question, isCorrectString, addMoreString;
		ArrayList<Answer> answers;
		ArrayList<Question> questions;
		Answer ans;
		Question q1;
		
		questions = new ArrayList();
		answers = new ArrayList();
		
		while(addMore==true)
		{
		
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
			System.out.println(q1.toString());
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
			
			
				
		}//end of outer loop for making whole questions
		
		
		
		
		
	} //end main
	
}//end class
