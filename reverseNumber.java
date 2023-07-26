import java.util.*;

class reverseNumber 
{
	public static void main(String args[])
	{
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int rev=0;
		while(n!=0)
		{
			int c = n%10;
			rev = rev*10 +c;
			n = n/10;
		}
		System.out.println(rev);
	}
}