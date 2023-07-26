import java.sql.*;
import com.mysql.jdbc.ResultSetMetaData;

class DemoJDBCConnectivity 
{
	public static void main(String arg[])
	{
		//Create a connection reference
		Connection connection = null;
		try {
			// Load drivers
			Class.forName("com.mysql.jdbc.Driver");
			//Get connection
			connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/school",
				"root", "");

			// school is database
			// root is name of database user
			// default password for root is empty

			//Create statement object
			Statement statement;
			statement = connection.createStatement();

			//Create Result Set
			ResultSet resultSet;
			//Call executeQuery() method to run select statement
			resultSet = statement.executeQuery("select * from class11");
			int roll_number;
			String name,email;
			long mobile;

			//Fetch data from ResultSet
			while (resultSet.next()) 
			{
				roll_number = resultSet.getInt("roll_nu");
				name = resultSet.getString("name");
				email = resultSet.getString("email");
				mobile = resultSet.getLong("mobile");


				System.out.println(roll_number+"\t"+name+"\t"+email+"\t"+mobile);
			}
			resultSet.close();
			statement.close();
			connection.close();
		}
		catch (Exception exception) {
			System.out.println(exception);
		}
	} // function ends
} // class ends

//Create a new table class11 in database
//Insert dara into the table
//Create a java program in which you enter the tablename and prints the data of the table