import java.util.*;

class prime {
	public static void main(String args[])
	{
		Scanner kb = new Scanner(System.in);
		int n1=kb.nextInt();
		int n2=kb.nextInt();
		int flag = 0;
		for(int i=2;i<=n1/2;i++)
		{
			if(n1%i == 0)
			{
				System.out.println("not");
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("prime");
		}
		
	}
}