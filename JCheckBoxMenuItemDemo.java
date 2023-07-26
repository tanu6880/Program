import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

  
class JCheckBoxMenuItemDemo implements ChangeListener
{  
    JFrame frame;
    JColorChooser jc;
    JTextArea jta;
    JCheckBoxMenuItemDemo()
    {
        frame = new JFrame("Jcheckboxmenuitem Example");  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        JMenuBar menuBar = new JMenuBar();  
        // File Menu, F - Shortcut
        JMenu fileMenu = new JMenu("File");  
        fileMenu.setMnemonic(KeyEvent.VK_F);  
        menuBar.add(fileMenu);
        jta=new JTextArea();
        // New, N - Mnemonic         
        JCheckBoxMenuItem editableMenuItem = new JCheckBoxMenuItem("Editable");  
        editableMenuItem.setMnemonic(KeyEvent.VK_E);  
        //JMenuItem pasteMenuItem = new JMenuItem("Paste", KeyEvent.VK_P);
        KeyStroke ctrlEKeyStroke = KeyStroke.getKeyStroke("control E");
        editableMenuItem.setAccelerator(ctrlEKeyStroke);
        fileMenu.add(editableMenuItem);  
        frame.add(jta);
        editableMenuItem.addActionListener( new ActionListener() {  
                    public void actionPerformed(ActionEvent event) 
                    {  
                        JCheckBoxMenuItem temp=(JCheckBoxMenuItem)event.getSource();
                        String newLabel="";
                        if (temp.isSelected()) 
                        {  
                            newLabel = "Editable";  
                        } 
                        else 
                        {  
                            newLabel = "Not editable";  
                        }  
                        System.out.println(newLabel);
                        temp.setText(newLabel);  
                    }  
                });  

        JFrame jf=new JFrame("New temp frame");
        jc=new JColorChooser(Color.white);

        jf.add(jc);
        jc.getSelectionModel().addChangeListener(this);        
        jf.setSize(200,300);
        JMenuItem newFrame=new JMenuItem("Open new frame");
        newFrame.addActionListener(
                        new ActionListener()
                            {
                                public void actionPerformed(ActionEvent ae)
                                {
                                    
                                    jf.setVisible(true);
                                }
                            }
        );
        fileMenu.add(newFrame);
        // editableMenuItem.addActionListener(aListener);  
        frame.setJMenuBar(menuBar);  
        frame.setSize(350, 250);  
        frame.setVisible(true);  
    }
    public static void main(String args[]) 
    {  
        new JCheckBoxMenuItemDemo();
    }  
    public void stateChanged(ChangeEvent e) 
    {
        Color newColor = jc.getColor();
        System.out.println(newColor);
        // frame.getContentPane().setOpaque(true);
        jta.setBackground(newColor);
    }
}  