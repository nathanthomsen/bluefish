import java.util.ArrayList;
import java.util.Scanner;

public class tester {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String scanned = scan.next();
		
		ArrayList<String> user_inputs = new ArrayList<String>();
		user_inputs.add(scanned);
		
		input theInput = new input(user_inputs);
		
		if(theInput.askEncrypt())
		{
			/* TODO Call Encrypt method */
		}
		else if(theInput.askDecrypt())
		{
			/* TODO Decrypt method */
		}
	}

}
