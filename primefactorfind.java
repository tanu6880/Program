class primefactorfind
{
	public static void main(String args[])
	{
		int n=600;
		int i=2;
		while(n>1)
		{
			if(n%i==0)
			{
				System.out.println(i+" ");
				n/=i;
			}
			else 
			{
				i++;
			}
		}
	}
}