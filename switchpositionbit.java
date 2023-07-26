import java.util.Scanner;

class switchpositionbit
{
	public static void main(String []args)
	{
			Scanner kb = new Scanner(System.in);
			System.out.println("Enter the number1 : ");
			int n1 = kb.nextInt();
			System.out.println("Enter the number2 : ");
			int n2 = kb.nextInt();

			System.out.println(((n1)|1<<n2-1));
	}
}