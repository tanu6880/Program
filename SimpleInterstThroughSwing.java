import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class SimpleInterstThroughSwing implements ActionListener
{
	private JTextField jtf1,jtf2,jtf3,jtf4;
	private JButton jb1;
	private JFrame jf;
	SimpleInterstThroughSwing()
	{
		//Creating a frame, and setting title
		jf=new JFrame()	;

		//set the title
		jf.setTitle("Text field sikha rahe hain tumhe");

		//Create a text field, with int value
		jtf1=new JTextField(10);
		jtf2=new JTextField(10);
		jtf3=new JTextField(10);
		jtf4=new JTextField(10);
		jtf4.setEditable(false);

		//Add button
		jb1=new JButton("Click Me");

		//Change layout manager of frame
		jf.setLayout(new FlowLayout());

		//Add the text field to the frame
		jf.add(jtf1);
		jf.add(jtf2);
		jf.add(jtf3);
		jf.add(jtf4);
		//Add the button to the frame
		jf.add(jb1);

		jb1.addActionListener(this);
		jf.setSize(200,300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.setVisible(true);	
	}
	public static void main(String[]args)
	{
		SimpleInterstThroughSwing app=new SimpleInterstThroughSwing();
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s1=jtf1.getText();
		String s2=jtf2.getText();
		String s3=jtf3.getText();
		//Area of Traingle the values
		double res=(Integer.parseInt(s1)*Integer.parseInt(s2)*Integer.parseInt(s3))/100;
		//set the the result into jtf3
		jtf4.setText(""+res);
	}
}