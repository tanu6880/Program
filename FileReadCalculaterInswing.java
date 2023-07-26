import java.io.*;
import javax.swing.*;
import java.awt.*;
//package for events
import java.awt.event.*;
class FileReadCalculaterInswing implements ActionListener
{
	private JTextField jtf1,jtf2,jtf3;
	private JLabel jl1,jl2,jl3;
	private JButton jb1,jb2,jb3,jb4,jb5;
	private JFrame jf;
	FileReadCalculaterInswing()
	{
		jf=new JFrame()	;
		jf.setTitle("FILE READ CALCULATER");

		//Create a text field, with int value
		jtf1=new JTextField(17);
		jtf2=new JTextField(17);
		jtf3=new JTextField(17);
		jtf2.setEditable(false);
		jtf3.setEditable(false);

		//Add button
		jb1=new JButton("READ");
		jb2=new JButton("DIGIT");
		jb3=new JButton("ALPHABET");
		jb4=new JButton("VOWEL");
		jb5=new JButton("CONSONENT");

		//CREATE LABEL
		jl1 = new JLabel("File Path :");
		jl2 = new JLabel("Data :");
		jl3 = new JLabel("Count :");

		//Change layout manager of frame
		jf.setLayout(new FlowLayout());


		//Add the text field and labelto the frame
		jf.add(jl1);
		jf.add(jtf1);
		jf.add(jl2);
		jf.add(jtf2);
		jf.add(jl3);
		jf.add(jtf3);
		//Add the button to the frame
		jf.add(jb1);
		jf.add(jb2);
		jf.add(jb3);
		jf.add(jb4);
		jf.add(jb5);

		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);

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
		FileReadCalculaterInswing app=new FileReadCalculaterInswing();
	}
	public void actionPerformed(ActionEvent ae)
	{
		//get the value from jtf1
		String s1=jtf1.getText();
		File file = new File(s1);
		String data = "";
		int digitCount = 0;
		int alphabetCount = 0;
		int vowelCount = 0;
		int consonant = 0;
	
		try
		{
			FileReader filereader = new FileReader(s1);
			int i;
			while((i = filereader.read())!=-1)
			{
				data += (char)i;
				char c = (char)i;
				if( (i >= 65 && i<= 90) || (i >= 97 && i <= 122))
					alphabetCount++;
				else if(i >= 48 && i<=57)
					digitCount++;

				if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
					vowelCount++;
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		if(ae.getSource() == jb1)
		{
			if(file.exists())
			{
				jtf2.setText(data);
			}
			else
			{
				jtf2.setText("Invaild File");
			}
			
		}
		else if(ae.getSource() == jb2)
		{
			if(file.exists())
			{
				jtf3.setText(""+digitCount);
			}
			else
			{
				jtf3.setText("ERROR");
			}
		}
		else if(ae.getSource() == jb3)
		{
			if(file.exists())
			{
				jtf3.setText(""+alphabetCount);
			}
			else
			{
				jtf3.setText("ERROR");
			}
		}
		else if(ae.getSource() == jb4)
		{
			if(file.exists())
			{
				jtf3.setText(""+vowelCount);
			}
			else
			{
				jtf3.setText("ERROR");
			}
		}
		else if(ae.getSource() == jb5)
		{
			consonant = alphabetCount - vowelCount;
			jtf3.setText(""+consonant);
		}
	
	}
}