import java.util.Arrays;

public class test {
	private static final int BLOCK_SIZE = 16;
	private static final int SECT_SIZE  = 32;
	private static final int MAIN_SIZE  = 128;
	
	private static final int[][] MDS = new int[4][256];
	
    private byte[] INPUT = new byte[MAIN_SIZE];
    
    private byte[] input_0; 
    private byte[] input_1;
	private byte[] input_2;
	private byte[] input_3;
	
	public test()
	{
		input_0= new byte[SECT_SIZE];
		input_1 = new byte[SECT_SIZE];
		input_2 = new byte[SECT_SIZE];
		input_3 = new byte[SECT_SIZE];
	}
	
	public void input_filler()
	{
		for(int a = 0; a<INPUT.length; a++)
		{
			INPUT[a] = (byte) (Math.random() *2);
		}
	}
	
	public void input_splitter()
	{
		for (int j = 0; j < MAIN_SIZE; j++)
		{
			if (j < SECT_SIZE)
			  System.arraycopy(INPUT, 0, input_0, 0, SECT_SIZE);
			if (j < SECT_SIZE*2 && j > SECT_SIZE)
			  System.arraycopy(INPUT, SECT_SIZE, input_1, 0, SECT_SIZE);
			if (j < SECT_SIZE*3 && j > SECT_SIZE*2 && j > SECT_SIZE)
			  System.arraycopy(INPUT, SECT_SIZE, input_2, 0, SECT_SIZE);
			if (j < MAIN_SIZE && j > SECT_SIZE*3 && j > SECT_SIZE*2 && j > SECT_SIZE)
			  System.arraycopy(INPUT, SECT_SIZE, input_3, 0, SECT_SIZE);
        }
    }
	
	public String toString()
	 {
		 String output;
		 //output= Arrays.toString(input);
		 output= Arrays.toString(input_0)+"\n"+Arrays.toString(input_1)+"\n"+Arrays.toString(input_2)+"\n"+Arrays.toString(input_3);
		 return output;
	 }
}