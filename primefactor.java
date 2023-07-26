import java.util.*;

class primefactor 
{
	public static void main(String args[])
	{
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		 for(int i=2;i<=n/2;)
		 {
		 	if(n%i==0)
		 	{
		 		System.out.println(i);
		 		n=n/i;
		 	}
		 	else 
		 		i++;
		 }
	}
}