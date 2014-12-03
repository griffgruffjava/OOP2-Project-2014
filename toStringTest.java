

public class toStringTest{
	public static void main(String args[])
	{
		char letter='@';
		String output="";
		
		
		for(int i=0;i<6;i++)
		{
			letter++;
			output+= (char)(letter);
			
		}
		
		System.out.println(output);
	}
}