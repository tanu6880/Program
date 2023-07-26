class checkBitpostionSetOrNot
{
	public static void main(String []args)
	{
		int n = 43;
		int bp = 31;
		if(1<<32-bp==1)
		{
			System.out.println("set");
		}
		else 
		{
			System.out.println("not set");
		}	
	}
}