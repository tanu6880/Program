import java.util.*;
class gcd
{
	public static void main(String args[])
	{
		Scanner kb = new Scanner(System.in);
		int n1 = kb.nextInt();
		int n2 = kb.nextInt();

		int lcm = (n1>n2)? n1:n2;
		for(int i=2;;i++)
		{
			if(lcm%n1==0 && lcm%n2==0)
			{
				System.out.println("lcm--> "+lcm);
				break;
			}
			lcm++;
		}
		int gcd = (n1*n2)/lcm;
		System.out.println("gcd---> "+gcd);
	}
}