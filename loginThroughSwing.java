import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
class loginThroughSwing implements ActionListener
{
	private JFrame jf;
	private JLabel jluser,jlpass;
	private JTextField jtuser;
	private JPasswordField jppass;
	private JButton verify;
	static int k=0;
	loginThroughSwing()
	{
		jf=new JFrame("password demo");
		jf.setLayout(new FlowLayout());

		jluser=new JLabel("Username ");
		jtuser=new JTextField(15);

		jlpass=new JLabel("Password ");
		jppass=new JPasswordField(15);

		verify=new JButton("Verify");

		jf.add(jluser);	jf.add(jtuser);
		jf.add(jlpass); jf.add(jppass);
		jf.add(verify);

		verify.addActionListener(this);

		jf.setSize(200,250);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.setVisible(true);

	}
	public static void main(String args[])
	{
		new loginThroughSwing();
	}
	//first method
	/*public void actionPerformed(ActionEvent ae)
	{
		HashMap<String,String> hm=new HashMap<String,String>();
		String username=jtuser.getText();
		String password=jppass.getText();
		File file = new File("user.txt");
		try
		{
			FileReader filereader = new FileReader("user.txt");
			BufferedReader br = new BufferedReader(filereader);
			String data[] = null;
			String s;
			while((s = br.readLine())!=null)
			{	
				data=s.split(" ");
			}
			for(int j=0;j<data.length;j=j+2)
			{
				hm.put(data[j],data[j+1]);
			}
			
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		int temp=0;
		for(Map.Entry<String,String> x:hm.entrySet())
        {	
			if(username.equals(x.getKey())&&password.equals(x.getValue()))
			{	System.out.println("Validated! Login Succes ");
				break;
			}
			temp++;
		}
		if(k<5 && temp==hm.size())
		{	System.out.println("Invalid Credentials! Login Failed ");
			k++;
		}
		else 
		System.exit(0);
	}*/
	//second method
	public void actionPerformed(ActionEvent ae)
	{
		HashMap<String,String> hm=new HashMap<String,String>();
		String username=jtuser.getText();
		String password=jppass.getText();
		File file = new File("user.txt");
		try
		{
			FileReader filereader = new FileReader("user.txt");
			BufferedReader br = new BufferedReader(filereader);
			String data[] = null;
			String arr[] = null;
			String s;
			int temp=0;
			while((s = br.readLine())!=null)
			{	
				data=s.split("\n");
				arr=data[0].split(" ");
				if(username.equals(arr[0])&&password.equals(arr[1]))
				{	System.out.println("Validated! Login Succes ");
					temp=1;
					break;
				}
			}
			if(k<5 && temp==0 )
			{	System.out.println("Invalid Credentials! Login Failed ");
				k++;
			}
			else 
				System.exit(0);
				
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
}