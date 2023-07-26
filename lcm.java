import java.util.*;
class lcm
{
	public static void main(String args[])
	{
		Scanner kb = new Scanner(System.in);
		int n1 = kb.nextInt();
		int n2 = kb.nextInt();

		int lcm = (n1>n2)? n1:n2;
		int gcd=0;

		for(int i=1;i<=n1 && i<=n2;i++)
		{
			if(n1%i==0 && n2%i==0)
			{
				gcd=i;
			}	
		}
		lcm = (n1*n2)/gcd;
		System.out.println("lcm-->"+lcm+" gcd--->"+gcd);
	}
}