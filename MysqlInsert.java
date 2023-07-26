import java.sql.*;
class MysqlInsert
{  
	public static void main(String args[])
	{  	try
		{  	//Loading JDBC Drivers
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/school","root","");  
			//here august_19 is database name, root is username and password is empty  
			Statement stmt=con.createStatement();  
			int n=stmt.executeUpdate("insert into class12 values(1234, 'bharat','bharat@cmail.com',7742578899) ");  
			if(n!=0)
				System.out.println("Record added");
			else
				System.out.println("Something went wrong");
			stmt.close();
			con.close();  
		}
		catch(Exception e)
		{ 	System.out.println(e);		}  
	}  
}  
/*
Take roll number, name, email and mobile number from user and insert them into table.
*/