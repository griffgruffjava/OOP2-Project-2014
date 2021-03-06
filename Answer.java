import java.io.*;

public class Answer implements Serializable
{
	//attributes
	private String answer;
	private boolean isCorrect;
	
	
	//constructor
	
	public Answer()
	{
		this("Blank",false);
	}
	
	public Answer(String answer, Boolean isCorrect)
	{
		setAnswer(answer);
		setIsCorrect(isCorrect);
	}
	
	
	//mutators
	
	public void setAnswer(String answer)
	{
		this.answer=answer;
	}
	
	public void setIsCorrect(boolean isCorrect)
	{
		this.isCorrect=isCorrect;
	}
	
	//accessors
	
	public String getAnswer()
	{
		return answer;
	}
	
	public boolean getIsCorrect()
	{
		return isCorrect;
	}
	
	
	//to String with t/f
	
	public String toStringTF()
	{
		String output = getAnswer()+"\t\t"+getIsCorrect();
		
		return output;
	}
	
	//to String with t/f
	
	public String toString()
	{
		String output = getAnswer();
		
		return output;
	}
	
	
}