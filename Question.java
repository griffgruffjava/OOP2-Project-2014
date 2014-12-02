//Question.java
//This is the Question class that will be used by the driver

import java.io.*;
import java.util.*;

public class Question implements Serializable
{
	//attributes
	
	private String question;
	private ArrayList<Answer> answers;
	
	//constructor
	
	public Question()
	{
		setQuestion(question);
		setAns(answers);
	}
	
	public Question(String question,ArrayList answers)
	{
		setQuestion(question);
		setAns(answers);
	}
	
	
	//mutator methods
	
	public void setQuestion(String question)
	{
		this.question=question;
	}
	
	public void setAns(ArrayList answers)
	{
		Answer ans = new Answer("is this working",true);
		answers.add(ans);
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
	
	
	//toString Method
	
	public String toString()
	{
		char letter='@';
		String output="Question: " + getQuestion();
		
		for(Answer a: answers)
		{
			output+= (char)(letter+1)+ ".  "+a.toString()+"\n";
			
		}
		
		return output;
	}
} 