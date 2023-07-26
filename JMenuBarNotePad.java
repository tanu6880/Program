import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class JMenuBarNotePad
{
	public static void main(String[]args)
	{
		JFrame jf=new JFrame("NotePad");
		JMenuBar jmb=new JMenuBar();
		//first menu
		JMenu file1=new JMenu("File");
		JMenuItem jminew=new JMenuItem("New File");
		jminew.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					System.out.println("Clicked on new file");
				}
			}
		);
		JMenuItem jmiopen=new JMenuItem("Open File");
		jmiopen.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					System.out.println("Clicked on open file");	
				}
				
			}
		);
		JMenuItem jmiclose=new JMenuItem("Close File");
		jmiclose.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					System.out.println("Clicked on close file");	
				}
			}
		);
		file1.add(jminew);
		file1.add(jmiopen);
		file1.add(jmiclose);
		jmb.add(file1);
		//second menu
		JMenu file2=new JMenu("Edit");
		jmb.add(file2);
		//3rd menu
		JMenu file3=new JMenu("Format");
		jmb.add(file3);
		//4th menu
		JMenu file4=new JMenu("View");
		jmb.add(file4);
		//5th menu
		JMenu file5=new JMenu("Help");
		jmb.add(file5);
		

		jf.setJMenuBar(jmb);
		jf.setSize(200,150);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}