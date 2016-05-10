import java.lang.Math;
public class encryption {
	 private int[] pad1;
	 private int[] key;
	 private String input;
	 public encryption(String input)
	 {
		 pad1 = new int[20];
		 this.input = input;
		 key = new int[3];
		 key[0]=1;
		 key[1]=2;
		 key[2]=3;
	 }
	 public void generateRandom()
	 {
		 for (int i = 0; i<pad1.length; i++)
		 {
			 pad1[i] = (int) (Math.random() * 3)+1;
		 }
		 System.out.print("The key = ");
		 for (int i : pad1) {
	            System.out.print(i+" ");
	        }
		 System.out.println("");
		 System.out.println("The input = " + input);
	 }
	 public String[] encrypt()
	 {
		 String[] eMessage = new String[3];
		 
		 int[] encrypted = new int[3];
		 System.out.print("The input values = ");
		 for (int i = 0; i<encrypted.length; i++)
		 {
			 if(input.charAt(i)=='a')
			 {
				 encrypted[i]=1;
			 } 
			 if(input.charAt(i)=='b')
			 {
				 encrypted[i]=2;
			 } 
			 if(input.charAt(i)=='c')
			 {
				 encrypted[i]=3;
			 } 
			 System.out.print(encrypted[i]+" ");
		 }
		 System.out.println("");
		 
		 for(int b = 0; b<encrypted.length; b++)
		 {
			 encrypted[b]+=pad1[b];
		 }
		 
		 for(int c = 0; c<encrypted.length; c++)
		 {
			 if(encrypted[c] >3)
			 {
				 encrypted[c]=encrypted[c]-3;
			 } 
		 }
		 System.out.print("The encrypted values = ");
		 for (int x : encrypted) {
	            System.out.print(x+" ");
	        }
		 
		 System.out.println("");
		 
		 for(int d = 0; d<encrypted.length; d++)
		 {
			 if(encrypted[d] == key[0])
			 {
				 eMessage[d]="a";
			 }
			 else if(encrypted[d] == key[1])
			 {
				 eMessage[d]="b";
			 }
			 else if(encrypted[d] == key[2])
			 {
				 eMessage[d]="c";
			 }
		 }
		 System.out.print("The encrypted message = ");
		 for (String i : eMessage) {
	            System.out.print(i+" ");
	        }
		 
		 return eMessage;
		
			 
		 
	 }
	 
	 
}
