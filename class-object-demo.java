import java.util.Scanner;
class student
{
	private String name;
	private int age ;
	private int roll_number;

	public student(String n, int a , int r)
	{
		name= n;
		age = a;
		roll_number = r;
	}
	public void print()
	{
		System.out.println(name);
		System.out.println(age);
		System.out.println(roll_number);
	}
}
class usestudent
{
	public static void main(String[] args)
	{
		student s1,s2;
		s1=new student("tanu",21,101);
		s2=new student("tanisha",22,102);
		s1.print();
		s2.print();

	}
}