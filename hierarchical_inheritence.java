import java.util.*;

class person
{
	Scanner kb = new Scanner(System.in);
	private int age;
	private String name;

	void input()
	{
		System.out.println("enter name : ");
		name = kb.nextLine();
		System.out.println("enter age : ");
		age = kb.nextInt();
	}
	void display()
	{
		System.out.println("name : "+name);
		System.out.println("age : "+age);
	}
}
class student extends person
{
	
}
class player extends person
{
	
}
class hierarchical_inheritence
{
	public static void main(String[] args)
	{
		player obj = new player();
		student obj1 = new student();
		obj.input();
		obj.display();
		obj1.input();
		obj1.display();
		
	}
}