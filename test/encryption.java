import java.lang.Math;
public class encryption {
	 private int[] pad1;
	 private char[] key;
	 private String input;
	 public encryption(String input)
	 {
		 pad1 = new int[20];
		 this.input = input;
		 key = new char[3];
		 key[0]='a';
		 key[1]='b';
		 key[2]='c';
	 }
	 public void generateRandom()
	 {
		 for (int i = 0; i<pad1.length; i++)
		 {
			 pad1[i] = ((int) Math.random() * 30)+1;
		 }
		 System.out.println(pad1);
	 }
	 public String encrypt()
	 {
		 System.out.println("ENC");
		 String eMessage = new String();
		 int[] encrypted = new int[3];
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
		 }
		 for(int b = 0; b<encrypted.length; b++)
		 {
			 encrypted[b]+=pad1[b];
		 }
		 for(int c = 0; c<encrypted.length; c++)
		 {
			 if(encrypted[c] >3)
			 {
				 encrypted[c]-=3;
			 } 
		 }
		 for(int d = 0; d<encrypted.length; d++)
		 {
			 if(encrypted[d] == key[0])
			 {
				 eMessage+='a';
			 }
			 else if(encrypted[d] == key[1])
			 {
				 eMessage+='b';
			 }
			 else if(encrypted[d] == key[2])
			 {
				 eMessage+='c';
			 }
		 }
		 return eMessage;
			 
		 
	 }
	 
	 
}
