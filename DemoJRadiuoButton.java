import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DemoJRadiuoButton implements ActionListener
{

  private JFrame jf;  
  private JRadioButton jrb1,jrb2;
  DemoJRadiuoButton()
  {
    jf=new JFrame("Radio Button Demo");
    jf.setLayout(new FlowLayout());

    jrb1=new JRadioButton("Male ");
    jrb2=new JRadioButton("Female ");

    //to make only single radio button selected add them into a ButtonGroup
    ButtonGroup gen=new ButtonGroup();
    gen.add(jrb1);
    gen.add(jrb2);
    jf.add(jrb1);
    jf.add(jrb2);

    jrb1.addActionListener(this);
    jrb2.addActionListener(this);

    jf.setSize(200,250);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setResizable(false);
    jf.setVisible(true);

  }
  public static void main(String args[])
  {
    new DemoJRadiuoButton();
  }
  public void actionPerformed(ActionEvent ae)
  {
    if(jrb1.isSelected())
      System.out.println("Male");
    else if(jrb2.isSelected())
      System.out.println("Female");

  }
}