import javax.swing.*;
import java.awt.*;
//package for events
import java.awt.event.*;
class SwappingThroughSwing implements ActionListener
{
	private JTextField jtf1,jtf2,jtf3,jtf4;
	private JButton jb1;
	private JFrame jf;
	SwappingThroughSwing()
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
		jtf3.setEditable(false);
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

		//To perform any operation on click of button we have to add some event
		//handling code.
		//To handle the click of button
		//i) your class must implements The ActionListener interface
		//ii)The ActionListener iterface declares a method actionPerformed()
		//   so we have define the actionPerformed() method in our class.
		//   the actionPerformed() method contains the code which we want to execute.
		//iii) Register the action Listener with button using the addActionListener() method
		jb1.addActionListener(this);

		//set size of frame
		jf.setSize(200,300);
		//set the working of the Close button of the frame
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		//show the frame
		jf.setVisible(true);	
	}
	public static void main(String[]args)
	{
		SwappingThroughSwing app=new SwappingThroughSwing();
	}
	public void actionPerformed(ActionEvent ae)
	{
		//get the value from jtf1
		String s1=jtf1.getText();

		//get the value from jtf2
		String s2=jtf2.getText();
		//add the values
		int res1=Integer.parseInt(s2);
		int res2=Integer.parseInt(s1);
		//set the the result into jtf3
		jtf3.setText(""+res1);
		jtf4.setText(""+res2);
	}
}