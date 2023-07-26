class checkPrimeOrNot
{
	public static void main(String args[])
	{
		int n=11;
		int i=0;
		for(i=2;i<=n/2;i++)
		{
			if(n%i==0)
			{
				System.out.println("not prime");
				break;
			}
		}
		if(i>n/2)
		{
			System.out.println("prime");
		}
	}
}