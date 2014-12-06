//Question.java
//This is the Question class that will be used by the driver

import java.io.*;
import java.util.*;

public class Question implements Serializable
{
	//attributes
	
	private String question;
	private ArrayList<Answer> answers;
	private String answerKey="";
	
	
	//constructor
	
	public Question()
	{
		setQuestion(question);
		setAns(answers);
		setKey(answerKey);
	}
	
	public Question(String question,ArrayList<Answer> answers)
	{
		setQuestion(question);
		setAns(answers);
		setKey(answerKey);
	}
	
	
	//mutator methods
	
	public void setQuestion(String question)
	{
		this.question=question;
	}
	
	public void setAns(ArrayList answers)
	{
		//Answer ans = new Answer("is this working",true);
		//answers.add(ans);
		this.answers=answers;
	}
	
	public void setKey(String answerKey)
	{
		this.answerKey=answerKey;
	}
	
	//accessor methods
	
	public String getQuestion()
	{
		return question;
	}
	
	public ArrayList getAns()
	{
		return answers;
	}
	
	public String getKey()
	{
		char letter='@';
		for(Answer a: answers)
		{
			letter++;
			if(a.getIsCorrect()==true)
				answerKey+=letter;	
		}
		
		return answerKey;
		
	}
	
	
	//toString Method- no t/f
	
	public String toString()
	{
		char letter='@';
		
		//adds question to output
		String output = "Question: " + getQuestion()+"?\n\n";

		//loop to add answers to string output
		for(Answer a: answers)
		{
			letter++;
			output+= (char)(letter)+ ".  " + a.toString() + "\n";
			
		}//end loop
	//	letter='@';    did not work
		return output;
		
	}//end toString
	
	//toStringFull method with t/f
	
	public String toStringFull()
	{
		char letter='@';
		
		//adds question to output
		String output = "Question: " + getQuestion()+"?\n\n";

		//loop to add answers to string output
		for(Answer a: answers)
		{
			letter++;
			output+= (char)(letter)+ ".  " + a.toStringTF() + "\n";
			
		}//end loop
	//	letter='@';    did not work
		return output;
		
	}//end toStringFull
} 