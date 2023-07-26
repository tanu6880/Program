class reverseNumber2
{
	public static void main(String []args)
	{
		int n = 0011;
		String num = n+"";
		int r=0;
		while(n!=0)
		{
			int m =n%10;
			r =r*10+m;
			n = n/10;	
		}
		System.out.println(r);
		System.out.println(num.length());
	}
}