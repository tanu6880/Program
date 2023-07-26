import java.io.File;
class filehandling1
{
	public static void main(String args[])
	{
		String path = "C:/practices/java/ans.txt";
		File file = new File(path);
		System.out.println(file.exists());
	}
}