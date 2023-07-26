class light{
	private int data;
	private int price;
	public void printdetails()
	     {
	     	System.out.println("details of the light"+data+"\nprice"+price);
	     }
}
public class defoultconsturcotor{
	public static void main(String[] args) {
		light small = new light();
		small.printdetails();
	}
}