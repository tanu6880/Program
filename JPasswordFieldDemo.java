import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class JPasswordFieldDemo implements ActionListener
{
	private JFrame jf;
	private JLabel jluser,jlpass;
	private JTextField jtuser;
	private JPasswordField jppass;
	private JButton verify;
	JPasswordFieldDemo()
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
		new JPasswordFieldDemo();
	}
	public void actionPerformed(ActionEvent ae)
	{
		String username=jtuser.getText();
		String password=jppass.getText();
		if(username.equals("admin")&&password.equals("admin"))
			System.out.println("Validated! Login Succes ");
		else
			System.out.println("Invalid Credentials! Login Failed ");
	}
}