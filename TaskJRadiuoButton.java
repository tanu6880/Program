import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TaskJRadiuoButton implements ActionListener
{

  private JFrame jf;  
  private JLabel jl1,jl2;
  private JTextField jtf1,jtf2;
  private JRadioButton jrb1,jrb2,jrb3,jrb4,jrb5,jrb6;
  TaskJRadiuoButton()
  {
    jf=new JFrame("Radio Button Task");
    jf.setLayout(new FlowLayout());

    jl1=new JLabel("String");
    jl2=new JLabel("Result");

    jtf1=new JTextField(20);
    jtf2=new JTextField(20);

    jrb1=new JRadioButton("Length ");
    jrb2=new JRadioButton("Upper ");
    jrb3=new JRadioButton("Lower ");
    jrb4=new JRadioButton("WordCase ");
    jrb5=new JRadioButton("Sentance ");
    jrb6=new JRadioButton("Toggle ");

    //to make only single radio button selected add them into a ButtonGroup
    ButtonGroup gen=new ButtonGroup();
    gen.add(jrb1);
    gen.add(jrb2);
    gen.add(jrb3);
    gen.add(jrb4);
    gen.add(jrb5);
    gen.add(jrb6);

    jf.add(jl1); jf.add(jtf1);
    jf.add(jl2); jf.add(jtf2);

    jf.add(jrb1);
    jf.add(jrb2);
    jf.add(jrb3);
    jf.add(jrb4);
    jf.add(jrb5);
    jf.add(jrb6);

    jrb1.addActionListener(this);
    jrb2.addActionListener(this);
    jrb3.addActionListener(this);
    jrb4.addActionListener(this);
    jrb5.addActionListener(this);
    jrb6.addActionListener(this);

    jf.setSize(300,350);
    jtf2.setEditable(false);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setResizable(false);
    jf.setVisible(true);

  }
  public static void main(String args[])
  {
    new TaskJRadiuoButton();
  }
  public void actionPerformed(ActionEvent ae)
  {
    String str= jtf1.getText();
    String st="";
    if(jrb1.isSelected())
    {   int length;
        length =str.length();
        jtf2.setText(""+length);
    }
    else if(jrb2.isSelected())
    {
        str=str.toUpperCase();
        jtf2.setText(str);
    }
    else if(jrb3.isSelected())
    {
        str=str.toLowerCase();
        jtf2.setText(str);
    } 
    else if(jrb4.isSelected())
    {   
        st =str.substring(0, 1).toUpperCase();
        for(int i=1;i<str.length();i++)
        {
          if(str.charAt(i)==' ')
          {  st += str.charAt(i)+str.substring(i+1, i+2).toUpperCase(); i++;
          }
          else 
            st += str.charAt(i);
        }
        jtf2.setText(st);
    }
    else if(jrb5.isSelected())
    {   st = str.substring(0, 1).toUpperCase() + str.substring(1,str.length()).toLowerCase();
        jtf2.setText(st);
    } 
    else if(jrb6.isSelected())
    {
        st="";
        for(int i=0;i<str.length();i++)
        {
          if(str.charAt(i)>='a' && str.charAt(i)<='z')
              st += str.substring(i, i+1).toUpperCase();
          else if(str.charAt(i)>='A' && str.charAt(i)<='Z')
            st += str.substring(i, i+1).toLowerCase();
          else 
            st +=str.charAt(i);
        }
        jtf2.setText(st);
    }   
  }
}