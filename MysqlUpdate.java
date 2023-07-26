import java.sql.*;
class MysqlUpdate
{  
	public static void main(String args[])
	{  try
		{	//Loading JDBC Drivers
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/school","root","");  
			//here august_19 is database name, root is username and password is empty  
			Statement stmt=con.createStatement();  
			int n=stmt.executeUpdate("update class11 set email='bp@gmail.com' where roll_nu=102");  
			
			System.out.println(n+"records updated");
			
			stmt.close();
			con.close();  
		}
		catch(Exception e)
		{ 	System.out.println(e);
		}  
	}  
}  