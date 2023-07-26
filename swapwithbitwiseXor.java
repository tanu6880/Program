-class swapwithbitwiseXor
{
	public static void main(String []args)
	{
		int n1 = 24;
		int n2 = 34;

		n1 = n1^n2;
		n2 = n1^n2;
		n1 = n1^n2;

		System.out.println("n1 is "+n1+" n2 is "+n2);
		if((n1&1)==0)
		{
			System.out.println("n1 is even number ");
		}
		else 
		{
			System.out.println("n1 is not even number ");
		}
	}
}