import java.util.*;

class primefactor 
{
	public static void main(String args[])
	{
		Scanner kb = new Scanner(System.in);
		int n1 = kb.nextInt();
		int n2 = kb.nextInt();

		n1 = n1 + n2;
		n2 = n1 - n2;
		n1 = n1 - n2;

		System.out.println(n1+" "+n2);

		//with third variable

		int c=n1;
		n1 = n2;
		n2 = c;

		System.out.println(n1+" "+n2);
	}
}