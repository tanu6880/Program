import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;
import javax.swing.*;
import javax.swing.event.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

class NotepadProject implements ChangeListener
{
	JFrame jf,frame;
    JColorChooser jc;
    JTextArea jta;
    JMenuBar jmp;
    JMenu file,format,view;
    JScrollPane jsp;
    JMenuItem jminew, jmiopen, jmisave, jmiclose,jmibackground,jmiforeground;
    KeyStroke ctrlEKeyStroke1,ctrlEKeyStroke2;
    int r=0,v=0,zoom =20;
    int arr[] = new int[7];
    String name="data.txt";
    NotepadProject()
    {
    	frame = new JFrame("Jcheckboxmenuitem Example");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jf = new JFrame("untitled");
       	JMenuBar jmb = new JMenuBar();
      	file = new JMenu("File");
      	format = new JMenu("Format");
      	view = new JMenu("View");
      	jminew = new JMenuItem("New File");
      	jta = new JTextArea();
      	jsp = new JScrollPane(jta);
      	jc = new JColorChooser();
	    jc.setSize(400, 400);
	    jc.setVisible(true);

        //keyshortcut
        file.setMnemonic(KeyEvent.VK_F);
        format.setMnemonic(KeyEvent.VK_V);

        /*ctrlEKeyStroke1 = KeyStroke.getKeyStroke("control N");
        jminew.setAccelerator(ctrlEKeyStroke1);*/

        File datafile = new File(name);
        if(datafile.exists())
        {
        	try 
        	{
		        String pd = datafile.getAbsolutePath();
		        FileInputStream fr=new FileInputStream(pd);
		        int size = fr.available();
		        byte ch[]=new byte[size];
		        fr.read(ch);
		       	String stp = new String(ch);
		       	String sp[] = stp.split(" ");
		       	for (int i = 0; i < sp.length; i++) 
		       	{
		            arr[i] = Integer.parseInt(sp[i]);
		        }
		        Font f=new Font("SansSerif", Font.BOLD, arr[0]);
		        jta.setFont(f);
		        Color t1 = new Color(arr[1],arr[2],arr[3]);
		        jta.setBackground(t1);
		        Color t2 = new Color(arr[4],arr[5],arr[6]);
		        jta.setForeground(t2);

        	}
        	catch(Exception ae)
        	{
        		System.out.println(ae);
        	}
        }
        else 
        {
        	Font f1=new Font("SansSerif", Font.BOLD, arr[0]);
        	jta.setFont(f1);
        }

        jminew.setAccelerator(KeyStroke.getKeyStroke("control N"));
      	jminew.addActionListener(
      	new ActionListener()
      	{
	        public void actionPerformed(ActionEvent ae)
	        {
		        //if textarea have data then confirm from the user to clear the text
		        if(jta.getText().length()>0)
		        {
		        	String[] options = {"Yes! Please.", "No! Not now.", "Cancel"};
		            int rv = JOptionPane.showOptionDialog(null,"Do you want to save this file","NotePad",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,null);
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
    	jmiopen.setAccelerator(KeyStroke.getKeyStroke("control O"));
    	jmiopen.addActionListener(
      	new ActionListener()
      	{	
	        public void actionPerformed(ActionEvent ae)
		    { 	String p = new String(jf.getTitle());
		        if(!p.equals("untitled"))
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
		        }
	            if(jf.getTitle().startsWith("*") || (jf.getTitle().equals("untitled") && jta.getText().length()>0))
	            {		
	            		String[] options = {"Yes! Please.", "No! Not now.", "Cancel"};
		                int rv = JOptionPane.showOptionDialog(null,"Do you want to save this file","NotePad",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,null);
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
      	}
    	);
		JMenuItem jmisave=new JMenuItem("Save File");
    	jmisave.setAccelerator(KeyStroke.getKeyStroke("control S"));
    	jmisave.addActionListener(
      	new ActionListener()
      	{
      		public void actionPerformed(ActionEvent ae)
	        {	String name = jf.getTitle();
	        	if(!name.equals("untitled"))
	        	{
	        		try
		            {
		            	File filename = new File(name);
		            	String path = filename.getAbsolutePath();

		              	File sfile= new File(path);
		              	//open file for Writer
		              	FileWriter fWriter = new FileWriter(sfile);
		              	String size = jta.getText();
		              	fWriter.write(size);
		              	
		              	
		              	
		              	jf.setTitle(name);
		              	fWriter.close();
            		}
		            catch(Exception ee)
		            {
		              System.out.println(ee);
		            }
	        	}
	        	else 
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
      	});
    	JMenuItem jmisaveas=new JMenuItem("Save As");
    	jmisaveas.setAccelerator(KeyStroke.getKeyStroke("control shift S"));
    	jmisaveas.addActionListener(
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
	    JMenuItem jmiclose=new JMenuItem("Exit");
	    jmiclose.addActionListener(
      	new ActionListener()
      	{
	        public void actionPerformed(ActionEvent ae)
	        {
	          System.exit(0);  
	        }
      	}
    	);

	    frame=new JFrame("New temp frame");
    	JMenuItem jmiforeground=new JMenuItem("Foreground");
    	jmiforeground.addActionListener(
      	new ActionListener()
      	{ 
	        public void actionPerformed(ActionEvent ae)
	        {
	           	r=0;
	        	v=1;
	        	frame.setVisible(true);
	        }
      	}
    	);
        jc=new JColorChooser(Color.white);
	    JMenuItem jmibackground=new JMenuItem("Background");
	    jmibackground.addActionListener(
      	new ActionListener()
      	{  
	        public void actionPerformed(ActionEvent ae)
	        {	r=1;
	        	v=0;
	        	frame.setVisible(true);
	 
	        }
      	}
    	);
    	JMenuItem jmizoomin=new JMenuItem("Zoom In");
    	jmizoomin.setAccelerator(KeyStroke.getKeyStroke("control EQUALS"));
	    jmizoomin.addActionListener(
      	new ActionListener()
      	{  
	        public void actionPerformed(ActionEvent ae)
	        {	zoom = zoom+1;
	 			Font f=new Font("SansSerif", Font.BOLD, zoom);
        		jta.setFont(f);
        		arr[0]=zoom;

        		try
			    {	
			    	File man = new File(name);
			    	String pd = man.getAbsolutePath();
				    //open file for writing
				    FileWriter fw = new FileWriter(pd);
				    String s = arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]+" "+arr[4]+" "+arr[5]+" "+arr[6];
				    fw.write(s);                           
				   	fw.close();
			    }
			    catch(Exception ee)
			    {
			    	System.out.println(ee);
			    }
	        }
      	}
    	);
    	JMenuItem jmizoomout=new JMenuItem("Zoom Out");
    	jmizoomout.setAccelerator(KeyStroke.getKeyStroke("control MINUS"));
	    jmizoomout.addActionListener(
      	new ActionListener()
      	{  
	        public void actionPerformed(ActionEvent ae)
	        {	arr[0]=zoom;	
	        	zoom = zoom-1;
	 			Font f=new Font("SansSerif", Font.BOLD, zoom);
        		jta.setFont(f);

        		try
			    {	
			    	File man = new File(name);
			    	String pd = man.getAbsolutePath();
				    //open file for writing
				    FileWriter fw = new FileWriter(pd);
				    String s = arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]+" "+arr[4]+" "+arr[5]+" "+arr[6];
				    fw.write(s);                           
				   	fw.close();
			    }
			    catch(Exception ee)
			    {
			    	System.out.println(ee);
		    	}
	        }
      	}
    	);
	    jf.add(jsp);
	    file.add(jminew);
	    file.add(jmiopen);
	    file.add(jmisave);
	    file.add(jmisaveas);
	    file.add(jmiclose);

	    jmb.add(file);
	    jmb.add(format);
	    jmb.add(view);

	    format.add(jmiforeground);
	    format.add(jmibackground);

	    view.add(jmizoomin);
	    view.add(jmizoomout);

	    frame.add(jc);
	    jc.getSelectionModel().addChangeListener(this);
	    jf.setJMenuBar(jmb);
	    jf.setSize(200,150);
	    frame.setSize(200,300);
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jf.setVisible(true);
    }
    public static void main(String args[]) 
    {  
        new NotepadProject();
    } 
    public void stateChanged(ChangeEvent e) 
    {	if(r==1 && v==0)
    	{
    		Color newColor = jc.getColor();
        	jta.setBackground(newColor);
        	int red1 = newColor.getRed();
        	arr[1]=red1;
        	int green1 = newColor.getGreen();
        	arr[2]=green1;
        	int blue1 = newColor.getBlue();
        	arr[3]=blue1;

        	try
		    {	
		    	File man = new File(name);
		    	String pd = man.getAbsolutePath();
			    //open file for writing
			    FileWriter fw = new FileWriter(pd);
			    String s = arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]+" "+arr[4]+" "+arr[5]+" "+arr[6];
			    fw.write(s);                           
			   	fw.close();
		    }
		    catch(Exception ee)
		    {
		    	System.out.println(ee);
		    }

    	}
    	else if(r==0 && v==1)
    	{
    		Color newColor = jc.getColor();
        	jta.setForeground(newColor);
        	int red2 = newColor.getRed();
        	arr[4]=red2;
        	int green2 = newColor.getGreen();
        	arr[5]=green2;
        	int blue2 = newColor.getBlue();
        	arr[6]=blue2;

 			try
		    {	
		    	File man = new File(name);
		    	String pd = man.getAbsolutePath();
			    //open file for writing
			    FileWriter fw = new FileWriter(pd);
			    String s = arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]+" "+arr[4]+" "+arr[5]+" "+arr[6];
			    fw.write(s);                           
			   	fw.close();
		    }
		    catch(Exception ee)
		    {
		    	System.out.println(ee);
		    }       	

    	}
    }
}