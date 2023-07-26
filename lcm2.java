class lcm2
{
	public static void main(String args[])
	{
		int n1=34;
		int n2=45;
		int lcm = n1<n2?n1:n2;
		while(true)
		{
			if(lcm%n1==0 && lcm%n2==0)
			{
				System.out.println("lcm is : "+lcm);
				break;
			}
			else 
			{
				lcm++;
			}
		}
	}
}