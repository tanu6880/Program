import javax.swing.*;    
import java.awt.event.*;    
import java.awt.*; 
class DemoJComboBox 
{    
    private JFrame f;    
    DemoJComboBox()
    {       
        f=new JFrame("ComboBox Example");   
        f.setLayout(new FlowLayout());

        JLabel label = new JLabel();                  
        JButton b=new JButton("Click Me");          

        String languages[]={"C","C++","C#","Java","PHP"};        
        JComboBox cb=new JComboBox(languages);    
        cb.setBounds(50, 100,90,20);    
        f.add(cb); 
        f.add(label); 
        f.add(b);            
        f.setSize(350,350);    
        f.setVisible(true);  
        cb.addActionListener(
                                new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent ae)
                                    {
                                        String str=""+cb.getItemAt(cb.getSelectedIndex());
                                        label.setText(str);
                                    }
                                }
                            );
        b.addActionListener(new ActionListener() 
                                {   public void actionPerformed(ActionEvent e) 
                                    {     System.out.println("Button Clicked");
                                    }  
                                }
                            );      

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)     ;
    }    
    public static void main(String[] args) 
    {    
        new DemoJComboBox();         
    }    
}