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
	Scanner kb = new Scanner(System.in);
	private int age;
	private String name;

	void read()
	{
		System.out.println("enter name : ");
		name = kb.nextLine();
		System.out.println("enter age : ");
		age = kb.nextInt();
	}
	void show()
	{
		System.out.println("name : "+name);
		System.out.println("age : "+age);
	}
}
class player extends student
{
	Scanner kb = new Scanner(System.in);
	private int age;
	private String name;

	void get()
	{
		System.out.println("enter name : ");
		name = kb.nextLine();
		System.out.println("enter age : ");
		age = kb.nextInt();
	}
	void put()
	{
		System.out.println("name : "+name);
		System.out.println("age : "+age);
	}
}
class multilevel_inheritence
{
	public static void main(String[] args)
	{
		player obj = new player();
		obj.input();
		obj.display();
		obj.read();
		obj.show();
		obj.get();
		obj.put();
	}
}