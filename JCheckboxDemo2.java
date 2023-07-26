import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class JCheckboxDemo2 implements ItemListener,ActionListener
{
	private JFrame jf;	
	private JCheckBox jcb1;
	private JLabel jlstr,jlword,jlcount;
	private JTextField jtstr,jtword,jtcount;
	private JButton search;
	private static int a;
	private static int b;
	JCheckboxDemo2()
	{
		jf=new JFrame("String Read");
		jf.setLayout(new FlowLayout());

		jcb1=new JCheckBox("Case Sensitive",true);

		jlstr=new JLabel("Enter String :-");
		jtstr=new JTextField(15);

		jlword=new JLabel("Enter word :-");
		jtword=new JTextField(15);

		jlcount=new JLabel("Count :-");
		jtcount=new JTextField(15);

		search=new JButton("Search");


		jf.add(jlstr);jf.add(jtstr);
		jf.add(jlword);jf.add(jtword);
		jf.add(jlcount);jf.add(jtcount);
		jf.add(jcb1);jf.add(search);

		jcb1.addItemListener(this);
		search.addActionListener(this);

		jf.setSize(300,480);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.setVisible(true);

	}
	public static void main(String args[])
	{
		new JCheckboxDemo2();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(jcb1.isSelected())
			{
				
				jtcount.setText(""+a+"");	
			}
		else
			{
				
				jtcount.setText(""+b+"");
			}
	
	}
	public void itemStateChanged(ItemEvent ie)
	{
		
		String str=jtstr.getText();
		String word=jtword.getText();

		a=(str.split(word,-1).length)-1;

		String t=str.toLowerCase();
		String p=word.toLowerCase();
		b=(t.split(p,-1).length)-1;
	}
	
	
}
