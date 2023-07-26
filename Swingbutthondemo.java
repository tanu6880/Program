import javax.swing.*;
import java.awt.*;
//package for events
import java.awt.event.*;
class Swingbutthondemo implements ActionListener
{
	JButtonDemo()
	{
		//Creating a frame, and setting title
		JFrame jf=new JFrame()	;

		//set the title
		jf.setTitle("Text field sikha rahe hain tumhe");

		//Add button
		JButton jb1=new JButton("Click Me");

		//Change layout manager of frame
		jf.setLayout(new FlowLayout());

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

		//show the frame
		jf.setVisible(true);	
	}
	public static void main(String[]args)
	{
		JButtonDemo app=new JButtonDemo();
	}
	public void actionPerformed(ActionEvent ae)
	{
		System.out.println("Button Clicked");
	}
}