import java.util.Arrays;

public class bluefish implements encpt {
    /* Definition of size-related constants. MAIN_SIZE is for use
     * in the algorithm as the final size used by the key and by
     * text which is encrypted. SECT_SIZE is for use in the 32-bit
     * sectors which the MAIN_SIZE is divided up into. BLOCK_SIZE
     * is used for convenience in giving sub-keys a certain size
     * without having to divide SECT_SIZE or MAIN_SIZE. */
    private static final int BLOCK_SIZE = 16;
    private static final int SECT_SIZE  = 32;
    private static final int MAIN_SIZE  = 128;
    
    /* Constants ROUNDS and MAX_ROUNDS reference the number of
     * times the algorithm will run. MAX_ROUNDS is defined as
     * sort of saftey-net. */
    private static final int ROUNDS     = 16;
    private static final int MAX_ROUNDS = 16;
    
    /* Pre-initialized arrays for containing data derived from 
     * split arrays. These will typically contain parts of the
     * user input or parts of the key. */
    private byte[] split_0 = new byte[SECT_SIZE];
    private byte[] split_1 = new byte[SECT_SIZE];
    private byte[] split_2 = new byte[SECT_SIZE];
    private byte[] split_3 = new byte[SECT_SIZE];
    
    /* Pre-defined lookup tables from the Twofish reference. The
     * first four columns match to the q0 permutation and the next
     * four columns match to the q1 permutation. Bear in mind: the
     * hexadecimal values may need to be cast to bytes. */
    private static final byte[][][] tables = new byte[][][]{
		{ 
	        {0x8,0x1,0x7,0xD,0x6,0xF,0x3,0x2,0x0,0xB,0x5,0x9,0xE,0xC,0xA,0x4}, 
	        {0xE,0xC,0xB,0x8,0x1,0x2,0x3,0x5,0xF,0x4,0xA,0x6,0x7,0x0,0x9,0xD}, 
	        {0xB,0xA,0x5,0xE,0x6,0xD,0x9,0x0,0xC,0x8,0xF,0x3,0x2,0x4,0x7,0x1}, 
	        {0xD,0x7,0xF,0x4,0x1,0x2,0x6,0xE,0x9,0xB,0x3,0x0,0x8,0x5,0xC,0xA} 
	    }, 
	    { 
	        {0x2,0x8,0xB,0xD,0xF,0x7,0x6,0xE,0x3,0x1,0x9,0x4,0x0,0xA,0xC,0x5}, 
	        {0x1,0xE,0x2,0xB,0x4,0xC,0x3,0x7,0x6,0xD,0xA,0x5,0xF,0x9,0x0,0x8}, 
	        {0x4,0xC,0x7,0x5,0x1,0x6,0x9,0xA,0x0,0xE,0xD,0x8,0x2,0xB,0x3,0xF}, 
	        {0xB,0x9,0x5,0x1,0xC,0x3,0xD,0xE,0x6,0x4,0x7,0xF,0x2,0x0,0x8,0xA} 
	    } 
	};
    
    /* Function input_filler is purely for testing, please ignore.
     * This function genereates input which fills "user" input before
     * splitting. This function is not for filling the key. */
    public void input_filler(byte[] INPUT)
    {
    	for (int j = 0; j < INPUT.length; j++)
    	{
    		if (j % 2 == 0)
    			INPUT[j] = 0x00;
    		else
    			INPUT[j] = 0x01;	
    	}
    }
	
    /* Function input_splitter splits a 128-bit long array of bytes
     * into 4 different 32-bit portions, be the array related to the
     * key or the user input. */
	public void input_splitter(byte INPUT[])
	{
		for (int j = 0; j < MAIN_SIZE; j++)
		{
			switch(j)
			{
				case 0:
					System.arraycopy(INPUT, 0, split_0, 0, SECT_SIZE);
					break;
				case 32:
					System.arraycopy(INPUT, SECT_SIZE, split_1, 0, SECT_SIZE);
					break;
				case 64:
					System.arraycopy(INPUT, SECT_SIZE * 2, split_2, 0, SECT_SIZE);
					break;
				case 96:
					System.arraycopy(INPUT, SECT_SIZE * 3, split_3, 0, SECT_SIZE);
					break;
			}
		}
	}
	
	/* Function bit_rot is used to rotate a value of 4 bytes by one bit. */
	public static final int bit_rot(int rot)
	{
		return (((rot) >> 1) | (((rot) << 3) &0x8));
	}
	
	/* Function gen_qtable is the integral piece in the generation of
	 * qtables for the q0 and q1 permutations. */
	public static void gen_qtable(byte[][] t, byte[] q)
	{
		int at, bt, ao, bo;
		
		t = new byte[4][16];
		q = new byte[256];
		
		for (int i = 1; i < MAIN_SIZE*2; i++)
		{
			at = i >> 4;
			bt = i&0xf;
			ao = at ^ bt;
			bo = at ^ bit_rot(bt) ^ ((at << 3)&8);
			at = t[0][ao];
			bt = t[1][bo];
			ao = at ^ bt;
			bo = at ^ bit_rot(bt) ^ ((at << 3)&8);
			at = t[2][ao];
			bt = t[3][bo];
			
			q[i] = (byte) ((bt << 4) | at);
		}
	}
}