import javax.swing.*;    
import java.awt.event.*;    
import java.awt.*; 
import java.util.*;
class calculaterInSwing 
{    
    private JFrame f; 
    private JTextField jtf;
    private JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb0,jb11,jb12,jb13,jb14,jb15,jb16; 
    calculaterInSwing()
    {       
        f=new JFrame("Calculater");   
        f.setLayout(new FlowLayout());
         
        jtf=new JTextField(30);         
        jb1=new JButton("  1  "); 
        jb2=new JButton("  2  ");
        jb3=new JButton("  3  ");
        jb4=new JButton("  4  ");
        jb5=new JButton("  5  ");
        jb6=new JButton("  6  ");
        jb7=new JButton("  7  ");
        jb8=new JButton("  8  ");
        jb9=new JButton("  9  ");
        jb0=new JButton("  0  ");
        jb11=new JButton("  +  ");
        jb12=new JButton("  -  ");
        jb13=new JButton("  *  ");
        jb14=new JButton("  /  ");
        jb16=new JButton(" <-- ");         
        jb15=new JButton("                     =                   "); 

        f.add(jtf);
        f.add(jb1);
        f.add(jb2);
        f.add(jb3);
        f.add(jb4);
        f.add(jb5);
        f.add(jb6);
        f.add(jb7);
        f.add(jb8);
        f.add(jb9);
        f.add(jb0);
        f.add(jb11);
        f.add(jb12);
        f.add(jb13);
        f.add(jb14);
        f.add(jb16);
        f.add(jb15);
        f.setSize(350,350);    
        f.setVisible(true);  
        jb1.addActionListener(new ActionListener() 
                                {   public void actionPerformed(ActionEvent e) 
                                    {   String str = jtf.getText();
                                        str += "1";
                                        jtf.setText(str);
                                    }  
                                }
                            );  
        jb2.addActionListener(new ActionListener() 
                                {   public void actionPerformed(ActionEvent e) 
                                    {   String str = jtf.getText();
                                        str += "2";
                                        jtf.setText(str);
                                    }  
                                }
                            ); 
        jb3.addActionListener(new ActionListener() 
                                {   public void actionPerformed(ActionEvent e) 
                                    {   String str = jtf.getText();
                                        str += "3";
                                        jtf.setText(str);
                                    }  
                                }
                            ); 
        jb4.addActionListener(new ActionListener() 
                                {   public void actionPerformed(ActionEvent e) 
                                    {   String str = jtf.getText();
                                        str += "4";
                                        jtf.setText(str);
                                    }  
                                }
                            ); 
        jb5.addActionListener(new ActionListener() 
                                {   public void actionPerformed(ActionEvent e) 
                                    {   String str = jtf.getText();
                                        str += "5";
                                        jtf.setText(str);
                                    }  
                                }
                            ); 
        jb6.addActionListener(new ActionListener() 
                                {   public void actionPerformed(ActionEvent e) 
                                    {   String str = jtf.getText();
                                        str += "6";
                                        jtf.setText(str);
                                    }  
                                }
                            ); 
        jb7.addActionListener(new ActionListener() 
                                {   public void actionPerformed(ActionEvent e) 
                                    {   String str = jtf.getText();
                                        str += "7";
                                        jtf.setText(str);
                                    }  
                                }
                            ); 
        jb8.addActionListener(new ActionListener() 
                                {   public void actionPerformed(ActionEvent e) 
                                    {   String str = jtf.getText();
                                        str += "8";
                                        jtf.setText(str);
                                    }  
                                }
                            );  
        jb9.addActionListener(new ActionListener() 
                                {   public void actionPerformed(ActionEvent e) 
                                    {   String str = jtf.getText();
                                        str += "9";
                                        jtf.setText(str);
                                    }  
                                }
                            );
        jb0.addActionListener(new ActionListener() 
                                {   public void actionPerformed(ActionEvent e) 
                                    {   String str = jtf.getText();
                                        str += "0";
                                        jtf.setText(str);
                                    }  
                                }
                            );
        jb11.addActionListener(new ActionListener() 
                                {   public void actionPerformed(ActionEvent e) 
                                    {   String str = jtf.getText();
                                        str += "+";
                                        jtf.setText(str);
                                    }  
                                }
                            );
        jb12.addActionListener(new ActionListener() 
                                {   public void actionPerformed(ActionEvent e) 
                                    {   String str = jtf.getText();
                                        str += "-";
                                        jtf.setText(str);
                                    }  
                                }
                            );
        jb13.addActionListener(new ActionListener() 
                                {   public void actionPerformed(ActionEvent e) 
                                    {   String str = jtf.getText();
                                        str += "*";
                                        jtf.setText(str);
                                    }  
                                }
                            );
        jb14.addActionListener(new ActionListener() 
                                {   public void actionPerformed(ActionEvent e) 
                                    {   String str = jtf.getText();
                                        str += "/";
                                        jtf.setText(str);
                                    }  
                                }
                            );
        jb16.addActionListener(new ActionListener() 
                                {   public void actionPerformed(ActionEvent e) 
                                    {   String str = jtf.getText();
                                        str = str.substring(0,str.length()-1);
                                        jtf.setText(str);
                                    }  
                                }
                            );
        jb15.addActionListener(new ActionListener() 
                                {   public void actionPerformed(ActionEvent e) 
                                    {   String str = jtf.getText();
                                        String st = "";
                                        ArrayList<String> list = new ArrayList<String>();
                                        ArrayList<String> ll = new ArrayList<String>();
                                        for(int i=0;i<str.length();i++)
                                        {   if(str.charAt(0)=='-' && i==0)
                                                list.add("-");
                                            else if(str.charAt(i)=='*' || str.charAt(i)=='/'||str.charAt(i)=='-'||str.charAt(i)=='+' && i!=0)
                                            {   list.add(st);
                                                st = "";
                                                list.add(str.charAt(i)+"");
                                            }
                                            else 
                                                st += str.charAt(i)+"";
                                            if(i==(str.length()-1))
                                                list.add(st);
                                        }
                                        int no=0;
                                        for(int i=0;i<list.size();i++)
                                        {   
                                            if(list.get(i).charAt(0)=='*')
                                            {    no = Integer.parseInt(list.get(i-1))*Integer.parseInt(list.get(i+1));
                                                list.remove(i-1);
                                                list.remove(i-1);
                                                list.remove(i-1);
                                                list.add(i-1,""+no);
                                            }
                                        }
                                        for(int i=0;i<list.size();i++)
                                        {   
                                            if(list.get(i).charAt(0)=='/')
                                            {    no = Integer.parseInt(list.get(i-1))/Integer.parseInt(list.get(i+1));
                                                list.remove(i-1);
                                                list.remove(i-1);
                                                list.remove(i-1);
                                                list.add(i-1,""+no);
                                            }
                                        } 
                                        for(int i=0;i<list.size();i++)
                                        {   
                                            if(list.get(i).charAt(0)=='-' && i==0)
                                            {    no = -1*Integer.parseInt(list.get(i+1));
                                                list.remove(i);
                                                list.remove(i);
                                                list.add(i,""+no);
                                            }  
                                            else if(list.get(i).charAt(0)=='-' && i!=0)
                                            {    no = Integer.parseInt(list.get(i-1))-Integer.parseInt(list.get(i+1));
                                                list.remove(i-1);
                                                list.remove(i-1);
                                                list.remove(i-1);
                                                list.add(i-1,""+no);
                                            }
                                            
                                        }
                                        for(int i=0;i<list.size();i++)
                                        {   
                                            if(list.get(i).charAt(0)=='+')
                                            {   
                                                no = Integer.parseInt(list.get(i-1))+Integer.parseInt(list.get(i+1));
                                                System.out.println(no);
                                                list.remove(i-1);
                                                list.remove(i-1);
                                                list.remove(i-1);
                                                list.add(i-1,""+no);
                                            }
                                        }  
                                        jtf.setText(""+list.get(0));
                                        
                                    }  
                                }
                            );



        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
    public static void main(String[] args) 
    {    
        new calculaterInSwing();         
    }    
}