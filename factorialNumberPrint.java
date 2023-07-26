class factorialNumberPrint
{
	public static void main(String args[])
	{
		int n=7;
		int fact=n;
		while(n>1)//5>=1 true
		{
			fact = fact*(n-1);
			n--;
		}
		System.out.println(fact);
	}
}