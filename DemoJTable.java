// Packages to import
import javax.swing.*;

public class DemoJTable
{
	// frame
	JFrame f;
	// Table
	JTable j;

	// Constructor
	DemoJTable()
	{
		// Frame initialization
		f = new JFrame();

		// Frame Title
		f.setTitle("JTable Example");

		// Data to be displayed in the JTable
		String[][] data = {
			{ "Tanu Saini", "ECBCS101", "CSE" },
			{ "Bharat Pareek", "CETCS201", "CSE" },
			{ "Mohit Purohit", "CETCS124", "CSE" },
			{ "Anmol Aggarwal", "ECBCS1425", "CSE" }
		};

		// Column Names
		String[] columnNames = { "Student Name", "Roll Number", "Branch" };

		// Initializing the JTable
		j = new JTable(data, columnNames);
		j.setBounds(30, 40, 200, 300);

		// adding it to JScrollPane
		JScrollPane sp = new JScrollPane(j);
		f.add(sp);

		// Frame Size
		f.setSize(500, 200);
		// Frame Visible = true
		f.setVisible(true);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// Driver method
	public static void main(String[] args)
	{
		new DemoJTable();
	}
}
