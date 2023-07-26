class fibonacciSeries
{
	public static void main(String []args)
	{
		int n=10;
		int r=1;
		int firstNumber = 0;
		int secondNumber = 1;
		System.out.print(firstNumber+" ");
		System.out.print(secondNumber+" ");
		while(r<=8)
		{
			int num = firstNumber+secondNumber;
			System.out.print(num+" ");
			firstNumber=secondNumber;
			secondNumber=num;
			r++;
		}
	}
}