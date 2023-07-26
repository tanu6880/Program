class fibonacciValuePrint
{
	public static void main(String args[])
	{
		int n=8;
		if(n==1)
		{
			System.out.println(0);
		}
		else if(n==2)
		{
			System.out.println(1);
		}
		else 
		{
			int num=0;
			int firstNumber=0;
			int secondNumber=1;
			while(n>2)
			{
				num = firstNumber+secondNumber;
				firstNumber=secondNumber;
				secondNumber=num;
				n--;
			}
			System.out.print(num+" ");
		}
	}
}