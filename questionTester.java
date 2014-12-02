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
		Answer ans;
		Question q1;
		
		
		answers = new ArrayList();
		
		while(addMore=true)
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
					answers(i)=ans;		
				}
				
				i++;	
			}
			
			q1 = new Quesiton(question,answers);	
			
			
		}
		
		
	} //end main
	
}//end class
