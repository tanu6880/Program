
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;
 

public class JColorChooserDemo extends JPanel
                              implements ChangeListener {
 
    protected JColorChooser tcc;
    protected JLabel banner;
 
        public JColorChooserDemo() 
    {
        super(new BorderLayout());
 
        //Set up the banner at the top of the window
        banner = new JLabel("Welcome to the JColor chooser!",JLabel.CENTER);
        banner.setForeground(Color.yellow);
        banner.setBackground(Color.blue);
        banner.setOpaque(true);
        Font f=new Font("SansSerif", Font.BOLD, 24);
        banner.setFont(f);
        Dimension d=new Dimension(100, 65);
        banner.setPreferredSize(d);
 
        JPanel bannerPanel = new JPanel(new BorderLayout());
        bannerPanel.add(banner, BorderLayout.CENTER);
        bannerPanel.setBorder(BorderFactory.createTitledBorder("Banner"));
 
        //Set up color chooser for setting text color
        tcc = new JColorChooser(banner.getForeground());
        tcc.getSelectionModel().addChangeListener(this);
        tcc.setBorder(BorderFactory.createTitledBorder(
                                             "Choose Text Color"));
 
        add(bannerPanel, BorderLayout.CENTER);
        add(tcc, BorderLayout.PAGE_END);
    }
 
    public void stateChanged(ChangeEvent e) 
    {
        Color newColor = tcc.getColor();
        banner.setForeground(newColor);
    }
 
    
    private static void createAndShowGUI() 
    {
        //Create and set up the window.
        JFrame frame = new JFrame("JColorChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new JColorChooserDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) 
    {
    
        createAndShowGUI();
    
    }
}