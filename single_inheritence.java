class tanu
{
	public String name;
	public int age;

	
	void show()
	{
		System.out.println("hii "+name+" age"+age);
	}
}
class lavisha extends tanu
{

}
public class single_inheritence
{
	public static void main(String[] arg)
	{
		lavisha obj=new lavisha();
		obj.name="tanu";
		obj.age=21;
		obj.show();
	}
}