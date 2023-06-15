package project;

public class Random 
{
	public int randomNo()
	{
		int min = 2; 
	    int max = 56;
	    int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
	    return random_int;
	}
}
