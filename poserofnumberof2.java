class poserofnumberof2
{
	public static void main(String []args)
	{
		int n=16;
		while(n>1)
		{
			if(n%2!=0)
			{
				break;
			}
			n /=2;
		}
		if(n==1)
		{
			System.out.println("number is power of 2");
		}
		else 
		{
			System.out.println("number is not power of 2");
		}	
	}
}