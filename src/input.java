public class input {
    private String input;

    public input(String input)
    {
	this.input = input;
    }
    
    /* Use if user asks to encrypt. */
    public boolean askEncrypt
    {
	if (input.equals("Encrypt") || input.equals("encrypt")
	    || input.equals("e"))
	{
	    return true;
	}
	else
	{
	    return false;
	}
    }

    /* Use if user asks to decrypt. */
    public boolean askDecrypt()
    {
	if (input.equals("Decrypt") || input.equals("decrypt")
	    || input.equals("d"))
	{
	    return true;
	}
	else
	{
	    return false;
	}
    }
}
