import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
class JMenuBarDemo 
{
  public static void main(String[]args) 
  {
      JFrame jf=new JFrame("untitled");
      JMenuBar jmb=new JMenuBar();
      JMenu file=new JMenu("File");
      JMenu file2=new JMenu("Format");
      JMenuItem jminew=new JMenuItem("New File");
      JTextArea jta=new JTextArea();
      JScrollPane jsp=new JScrollPane(jta);
      JColorChooser tcc = new JColorChooser();
      tcc.setSize(400, 400);
      tcc.setVisible(true);
      Font f=new Font("SansSerif", Font.BOLD, 24);
        jta.setFont(f);
      jminew.addActionListener(
      new ActionListener()
      {
        public void actionPerformed(ActionEvent ae)
        {
          //if textarea have data then confirm from the user to clear the text
          if(jta.getText().length()>0)
          {
              int rv=JOptionPane.showConfirmDialog(jf,null,"Do you want to save this file ",JOptionPane.YES_NO_CANCEL_OPTION);
              if(rv==JOptionPane.YES_OPTION)
              {
                JFileChooser jfc=new JFileChooser();
                  //show save open box
                  int choice=jfc.showSaveDialog(jf);
                  if(choice==jfc.APPROVE_OPTION)
                  { 
                    //get the selected file
                    try
                    {
                      File sfile=jfc.getSelectedFile();
                      //open file for writing
                      FileOutputStream fw=new FileOutputStream(sfile);
                      String stringData=jta.getText();;
                  
                      byte ch[]=stringData.getBytes();
                      fw.write(ch);                           
                      fw.close();
                      jta.setText("");
                      jf.setTitle("untitled");
                    }
                    catch(Exception ee)
                    {
                      System.out.println(ee);
                    }         

                  }
              }
              else if(rv==JOptionPane.NO_OPTION)
              {   jta.setText("");
                  jf.setTitle("untitled");      
              }
          }
          else
          {
              jta.setText("");
              jf.setTitle("untitled");  
          }
          
        }
      }
    );
    JMenuItem jmiopen=new JMenuItem("Open File");
    jmiopen.addActionListener(
      new ActionListener()
      {
        public void actionPerformed(ActionEvent ae)
        { String p = jf.getTitle();
          if(!p.equals("untitled") && !p.equals("Un title") )
          {
              try
              {
                String data1 = jta.getText();
                File f = new File(p);
                String dp = f.getAbsolutePath();
                FileInputStream fr=new FileInputStream(dp);
                int size=fr.available();
                byte ch[]=new byte[size];
                fr.read(ch);
                String data2 = new String(ch);
                if(!data1.equals(data2))
                    jf.setTitle("*"+p);
              }
              catch(Exception ee)
              {
                System.out.println(ee);
              }
              String s2 = ""+jf.getTitle().charAt(0);
              System.out.println(s2.equals("*"));
              if(s2.equals("*"))
              {
                int rv=JOptionPane.showConfirmDialog(jf,null,"Do you want to save this file ",JOptionPane.YES_NO_CANCEL_OPTION);
                if(rv==JOptionPane.YES_OPTION)
                {
                    JFileChooser jfc=new JFileChooser();
                    int choicesave=jfc.showSaveDialog(jf);
                    if(choicesave==jfc.APPROVE_OPTION)
                    { 
                        try
                        {
                          File sfile=jfc.getSelectedFile();
                          FileOutputStream fw=new FileOutputStream(sfile);
                          String stringData=jta.getText();;
                          byte ch[]=stringData.getBytes();
                          fw.write(ch);                           
                          fw.close();
                        
                        }
                        catch(Exception ee)
                        {
                          System.out.println(ee);
                        }         

                    }
                    int choiceOpen=jfc.showOpenDialog(jf);
                    if(choiceOpen==jfc.APPROVE_OPTION)
                    {  
                        try
                        {
                            File sfile=jfc.getSelectedFile();
                            FileInputStream fr=new FileInputStream(sfile);
                            int size=fr.available();
                            byte ch[]=new byte[size];
                            fr.read(ch);
                            String data2 = new String(ch);
                            System.out.println(data2);
                            jta.setText(data2);
                            String str = ""+jfc.getSelectedFile();
                            Path path = Paths.get(str);
                            Path fileName = path.getFileName();
                            jf.setTitle(fileName.toString());
                            fr.close();
                        }
                        catch(Exception ee)
                        {
                          System.out.println(ee);
                        }
                    }
                }
                else if(rv==JOptionPane.NO_OPTION )
                {
                  JFileChooser jfc=new JFileChooser();
                    int choiceOpen=jfc.showOpenDialog(jf);
                    if(choiceOpen==jfc.APPROVE_OPTION)
                    {  
                        try
                        {
                            File sfile=jfc.getSelectedFile();
                            FileInputStream fr=new FileInputStream(sfile);
                            int size=fr.available();
                            byte ch[]=new byte[size];
                            fr.read(ch);
                            String data2 = new String(ch);
                            System.out.println(data2);
                            jta.setText(data2);
                            String str = ""+jfc.getSelectedFile();
                            Path path = Paths.get(str);
                            Path fileName = path.getFileName();
                            jf.setTitle(fileName.toString());
                            fr.close();
                        }
                        catch(Exception ee)
                        {
                          System.out.println(ee);
                        }
                    }
                  }
                }
                else 
                {
                  JFileChooser jfc=new JFileChooser();
                    int choiceOpen=jfc.showOpenDialog(jf);
                    if(choiceOpen==jfc.APPROVE_OPTION)
                    {  
                        try
                        {
                            File sfile=jfc.getSelectedFile();
                            FileInputStream fr=new FileInputStream(sfile);
                            int size=fr.available();
                            byte ch[]=new byte[size];
                            fr.read(ch);
                            String data2 = new String(ch);
                            System.out.println(data2);
                            jta.setText(data2);
                            String str = ""+jfc.getSelectedFile();
                            Path path = Paths.get(str);
                            Path fileName = path.getFileName();
                            jf.setTitle(fileName.toString());
                            fr.close();
                        }
                        catch(Exception ee)
                        {
                          System.out.println(ee);
                        }
                    }
                }
                
            
          }
          else
          {
              JFileChooser jfc=new JFileChooser();
              //show save open box
              int choice=jfc.showOpenDialog(jf);
              if(choice==jfc.APPROVE_OPTION)
              {  
                try
                {
                    File sfile=jfc.getSelectedFile();
                    FileInputStream fr=new FileInputStream(sfile);
                    int size=fr.available();
                    byte ch[]=new byte[size];
                    fr.read(ch);
                    String data2 = new String(ch);
                    System.out.println(data2);
                    jta.setText(data2);
                    String str = ""+jfc.getSelectedFile();
                    Path path = Paths.get(str);
                    Path fileName = path.getFileName();
                    jf.setTitle(fileName.toString());
                    fr.close();
                }
                catch(Exception ee)
                {
                  System.out.println(ee);
                }
              }
          }
         
        }
      }
    );
    JMenuItem jmisave=new JMenuItem("Save File");
    jmisave.addActionListener(
      new ActionListener()
      {
        public void actionPerformed(ActionEvent ae)
        {
          JFileChooser jfc=new JFileChooser();
          int choice=jfc.showSaveDialog(jf);
          if(choice==jfc.APPROVE_OPTION)
          {  
            //get the selected file
            try
            {
              File sfile=jfc.getSelectedFile();
              //open file for Writer
              FileWriter fWriter = new FileWriter(sfile);
              String size = jta.getText();
              fWriter.write(size);
              String str = ""+jfc.getSelectedFile();
              Path path = Paths.get(str);
              Path fileName = path.getFileName();
              jf.setTitle(fileName.toString());
              fWriter.close();
            }
            catch(Exception ee)
            {
              System.out.println(ee);
            }
          }
        }
      }
    );
    JMenuItem jmiclose=new JMenuItem("Close File");
    jmiclose.addActionListener(
      new ActionListener()
      {
        public void actionPerformed(ActionEvent ae)
        {
          System.exit(0);  
        }
      }
    );

    JMenuItem jmiforeground=new JMenuItem("Foreground");
    jmiforeground.addActionListener(
      new ActionListener()
      { 
        public void actionPerformed(ActionEvent ae)
        {
           
        }
      }
    );
    JMenuItem jmibackground=new JMenuItem("Background");
    jmibackground.addActionListener(
      new ActionListener()
      {  
        public void actionPerformed(ActionEvent ae)
        {
        }
      }
    );
    jf.add(jsp);
    file.add(jminew);
    file.add(jmiopen);
    file.add(jmisave);
    file.add(jmiclose);

    jmb.add(file);
    jmb.add(file2);

    file2.add(jmiforeground);
    file2.add(jmibackground);

    jf.setJMenuBar(jmb);
    jf.setSize(200,150);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setVisible(true);
  }
  
}
