//java provides swing API for GUI app Development
//every GUI app have a basic frame on which multiple components are added.
import javax.swing.*;
class swingsdemo
{
	public static void main(String[] args) {
		//creating a new frame
		JFrame jf = new JFrame();
		// set the title
		jf.setTitle("tanu");
		//set size of frame
		jf.setSize(200,300);
		//set working of the close button of the frame 
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//SHOW THE FRAME
		jf.setVisible(true);

	}
}