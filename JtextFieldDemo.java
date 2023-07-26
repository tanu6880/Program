import javax.swing.*;
class JtextFieldDemo
{
	public static void main(String[] args) {
		JFrame jf = new JFrame("tanu saini");
		//create a text field with int value
		JTextField jtf1 = new JTextField(10);
		JTextField jtf2 = new JTextField(10);

		jf.setLayout(new FlowLayout());

		jf.add(jtf1);
		jf.add(jtf2);

		jf.setSize(200,300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//SHOW THE FRAME
		jf.setVisible(true);
	}

}