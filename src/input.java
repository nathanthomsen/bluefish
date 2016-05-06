import java.util.ArrayList;
import java.util.Scanner;

public class input {
	private ArrayList<String> user_inputs;
	
	public input(ArrayList<String> theInput)
	{
		for(int i = 0; i<theInput.size(); i++)
		{
			user_inputs.set(i, theInput.get(i));
		}
	}
	
	public boolean isEncrypt()
	{
		if(user_inputs.get(0).equals("Encrypt")||user_inputs.get(0).equals("encrypt"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isDecrypt()
	{
		if(user_inputs.get(0).equals("Decrypt")||user_inputs.get(0).equals("decrypt"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public String toString()
	{
		String output = new String();
		output += " ";
		return output;
	}

}