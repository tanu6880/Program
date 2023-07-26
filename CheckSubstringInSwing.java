import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
class CheckSubstringInSwing implements ItemListener,ActionListener
{
	private JFrame jf;
	private JLabel jl1,jl2,jl3;
	private JTextField jt1,jt2,jt3;
	private JCheckBox jcb1;
	private JButton search;
	static int k=0;
	CheckSubstringInSwing()
	{
		jf=new JFrame("check substring");
		jf.setLayout(new FlowLayout());

		jl1=new JLabel("Enter String");
		jt1=new JTextField(15);

		jl2=new JLabel("SearchWord ");
		jt2=new JTextField(15);

		jl3=new JLabel("Count");
		jt3=new JTextField(15);

		jcb1=new JCheckBox("CaseSansitive");

		search=new JButton("Search");

		jf.add(jl1);	jf.add(jt1);
		jf.add(jl2); 	jf.add(jt2);
		jf.add(jl3); 	jf.add(jt3);
		jf.add(jcb1);
		jf.add(search);
		jcb1.addItemListener(this);
		search.addActionListener(this);

		jf.setSize(200,250);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.setVisible(true);

	}
	public static void main(String args[])
	{
		new CheckSubstringInSwing();
	}
	public void itemStateChanged(ItemEvent ae)
	{
		if(jcb1.isSelected())
			k= 0;
		else 
			k= 1;
	}
	public void actionPerformed(ActionEvent ae)
	{	
		String st1=jt1.getText();
		String st2=jt2.getText();
		if(st2.length()>st1.length())
			jt3.setText("0");
		else
		{
			//first method
			int casec=0;
			int incasec=0;
			
			for(int i=0;i<=st1.length()-st2.length();i++)
			{	
				String newstr = st1.substring(i,(i+st2.length()));
				if(st2.equals(newstr))
				{	casec++;
					
				}
				if(st2.equalsIgnoreCase(newstr))
				{	incasec++;
				}
				
			}
			if(k==0) 
			{
				jt3.setText(""+casec);
			}
			else
			{
				jt3.setText(""+incasec);
			}

			//second method
			if(k==0)
		    {
		      text=text.toLowerCase();
		      word=word.toLowerCase();
		    }
		    while(text.indexOf(word,start)!=-1)
		    {
		      start=text.indexOf(word,start)+1;
		      count++;
		    }
		    System.out.println(count);
		  }
		}
	}	
}