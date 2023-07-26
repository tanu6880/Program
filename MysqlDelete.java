import java.sql.*;

class MysqlDelete
{  
	public static void main(String args[])
	{  
		try
		{//Loading JDBC Drivers
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/school","root","");  
			//here august_19 is database name, root is username and password is empty  
			Statement stmt=con.createStatement();  
			int n=stmt.executeUpdate("delete from class12 where mobile is null ");  
			
			System.out.println(n+"records deleted");
			
			stmt.close();
			con.close();  
		}
		catch(Exception e)
		{ 	System.out.println(e);
		}  
	}  
}  