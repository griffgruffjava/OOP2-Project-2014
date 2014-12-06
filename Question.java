//Question.java
//This is the Question class that will be used by the driver


/**This is an instantiable Question class.
 *@author Ciaran Griffin
 *@version 1.0*/

import java.io.*;
import java.util.*;

public class Question implements Serializable
{
	//attributes
	
	private String question;
	private ArrayList<Answer> answers;
	private String answerKey="";
	
	
	//constructor
	/**no argument constructor method */
	public Question()
	{
		setQuestion(question);
		setAns(answers);
		setKey(answerKey);
	}
	/** two argument constructor method
	 *@param question is  the question string and @param answers is an ArrayList of the class Answer*/
	public Question(String question,ArrayList<Answer> answers)
	{
		setQuestion(question);
		setAns(answers);
		setKey(answerKey);
	}
	
	
	//mutator methods
	/**mutator method to set the question 
	*@param question the question */
	
	public void setQuestion(String question)
	{
		this.question=question;
	}
	
	/**mutator method to set the answers ArrayList 
	 *@param answers ArrayList of Answer class*/
	public void setAns(ArrayList answers)
	{
		this.answers=answers;
	}
	
	/**mutator method to set the answerKey for this question 
	 *@param answerKey answerKey as String*/
	
	public void setKey(String answerKey)
	{
		this.answerKey=answerKey;
	}
	
	//accessor methods
	
	/**acessor method to return the question String
	*@return question the question */
	
	public String getQuestion()
	{
		return question;
	}
	
	/**acessor method to return the answers ArrayList
	*@return answers ArrayList of Answer class */
	
	public ArrayList getAns()
	{
		return answers;
	}
	
	
	/**acessor method to return answerKey as String
	*@return answerKey answerKey as String */
	
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
	
	/**toString method to return the question and options as one String
	 *@return output the question and options as String  */
	
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
	
	/**toString method to return the question, options and True/False value as one String
	 *@return output the question and options as String */
	
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
	
		return output;
		
	}//end toStringFull
} 