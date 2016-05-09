import java.util.ArrayList;
import java.util.Scanner;


public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String scanned = scan.next();
		ArrayList<String> user_inputs = new ArrayList<String>();
		user_inputs.add(scanned);
		input theInput = new input(user_inputs);
		if(theInput.isEncrypt())
		{
			//Call Encrypt method
		}
		else if(theInput.isDecrypt())
		{
			//Call Decrypt method
		}
	}

}
