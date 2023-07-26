import javax.swing.*;
import java.awt.*;
//package for events
import java.awt.event.*;
class functionthroughswing implements ActionListener
{
	private JTextField jtf1,jtf2,jtf3;
	private JButton jb1,jb2,jb3,jb4;
	private JFrame jf;
	functionthroughswing()
	{
		//Creating a frame, and setting title
		jf=new JFrame()	;

		//set the title
		jf.setTitle("Text field sikha rahe hain tumhe");

		//Create a text field, with int value
		jtf1=new JTextField(17);
		jtf2=new JTextField(17);
		jtf3=new JTextField(17);
		jtf3.setEditable(false);

		//Add button
		jb1=new JButton("ADD");
		jb2=new JButton("SUB");
		jb3=new JButton("MUL");
		jb4=new JButton("DIV");

		//Change layout manager of frame
		jf.setLayout(new FlowLayout());

		//Add the text field to the frame
		jf.add(jtf1);
		jf.add(jtf2);
		jf.add(jtf3);
		//Add the button to the frame
		jf.add(jb1);
		jf.add(jb2);
		jf.add(jb3);
		jf.add(jb4);

		//To perform any operation on click of button we have to add some event
		//handling code.
		//To handle the click of button
		//i) your class must implements The ActionListener interface
		//ii)The ActionListener iterface declares a method actionPerformed()
		//   so we have define the actionPerformed() method in our class.
		//   the actionPerformed() method contains the code which we want to execute.
		//iii) Register the action Listener with button using the addActionListener() method
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);

		//set size of frame
		jf.setSize(220,300);
		//set the working of the Close button of the frame
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		//show the frame
		jf.setVisible(true);	
	}
	public static void main(String[]args)
	{
		functionthroughswing app=new functionthroughswing();
	}
	public void actionPerformed(ActionEvent ae)
	{
		//get the value from jtf1
		String s1=jtf1.getText();

		//get the value from jtf2
		String s2=jtf2.getText();
		System.out.println(s2);
		//add the values
		int n1=Integer.parseInt(s1);
		int n2=Integer.parseInt(s2);
		int res=0;
		//set the the result into jtf3
		if(ae.getSource()==jb1)
			res=n1+n2;
		else if(ae.getSource()==jb2)
			res=n1-n2;
		else if(ae.getSource()==jb3)
			res=n1*n2;
		else if(ae.getSource()==jb3)
			res=n1/n2;

		jtf3.setText(""+res);
	}
}