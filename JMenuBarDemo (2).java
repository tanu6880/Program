import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class JMenuBarDemo
{
	public static void main(String[]args)
	{
		JFrame jf=new JFrame("untitled");
		JMenuBar jmb=new JMenuBar();
		JMenu file=new JMenu("File");
		JMenuItem jminew=new JMenuItem("New File");
		JTextArea jta=new JTextArea();
		JScrollPane jsp=new JScrollPane(jta);
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
							{		jta.setText("");
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
				{
					JFileChooser jfc=new JFileChooser();
					//show save open box
					int choice=jfc.showOpenDialog(jf);
					if(choice==jfc.APPROVE_OPTION)
					{	
						//get the selected file
						try
						{
							File sfile=jfc.getSelectedFile();
							//open file for reading
							FileInputStream fr=new FileInputStream(sfile);
							int size=fr.available();
							byte ch[]=new byte[size];
							fr.read(ch);
							String stringData=new String(ch);
							jta.setText(stringData);
							fr.close();
						}
						catch(Exception ee)
						{
							System.out.println(ee);
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
					System.out.println("Clicked on close file");	
				}
			}
		);
		jf.add(jsp);
		file.add(jminew);
		file.add(jmiopen);
		file.add(jmisave);
		file.add(jmiclose);

		jmb.add(file);

		jf.setJMenuBar(jmb);
		jf.setSize(200,150);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}