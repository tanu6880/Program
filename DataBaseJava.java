import java.sql.*;
import java.util.Scanner;
import javax.swing.*;

class DataBaseJava {
	
	public static void main(String args[])
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("1. Create DataBase");
		System.out.println("2. Create Table");
		System.out.println("3. Insert Data In Table");
		System.out.println("4. update Data In Table");
		System.out.println("5. Show Table");
		System.out.println("6. Delete Table ");
		System.out.println("7. Delete Data In Table");

		int n = kb.nextInt();
		switch(n)
		{
			case 1:
				String str = kb.next();
				createData(str);
				break;
			case 2:
				System.out.println("Enter the DataBase Name");
				String db = kb.next();
				System.out.println("Enter the Table Name");
				String tn = kb.next();
				createTable(db,tn);
				break;
			case 3:
				System.out.println("Enter the DataBase Name");
				String db1 = kb.next();
				System.out.println("Enter the Table Name");
				String tn1 = kb.next();
				InserDataInTable(db1,tn1);
				break;
			case 4:
				System.out.println("Enter the DataBase Name");
				String db2 = kb.next();
				System.out.println("Enter the Table Name");
				String tn2 = kb.next();
				UpdateDataInTable(db2,tn2);
				break;
			case 5:
				System.out.println("Enter the DataBase Name");
				String db3 = kb.next();
				System.out.println("Enter the Table Name");
				String tn3 = kb.next();
				ShowTable(db3,tn3);
				break;
			case 6:
				System.out.println("Enter the DataBase Name");
				String db4 = kb.next();
				System.out.println("Enter the Table Name");
				String tn4 = kb.next();
				DeleteTable(db4,tn4);
				break;
			case 7:
				System.out.println("Enter the DataBase Name");
				String db5 = kb.next();
				System.out.println("Enter the Table Name");
				String tn5 = kb.next();
				System.out.println("Enter the condition");
				String condition = kb.next();
				DeleteDataInTable(db5,tn5,condition);
				break;
		} 
	}
	public static void createData(String str)
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306","root",""); 
			Statement stmt=con.createStatement();
			//Call executeQuery() method to run select statement
			int n = stmt.executeUpdate("Create DataBase "+str);
			System.out.println(n+"records deleted");
			stmt.close();
			con.close();
		}
		catch(Exception e)
		{
				System.out.println(e);
		}
	}
	public static void createTable(String db,String tn)
	{	Scanner kb = new Scanner(System.in); 
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/"+db,"root",""); 
			Statement stmt=con.createStatement();
			//Call executeQuery() method to run select statement

			System.out.println("how much element want you created :");
			int t = kb.nextInt();
			String arr[] = new String[2*t];
			for(int i=0;i<2*t;i=i+2)
			{
				System.out.println("enter Atribute");
				arr[i] = kb.next();
				System.out.println("enter Atribute Type");
				arr[i+1] = kb.next();
			}
			stmt.executeUpdate("Create Table "+tn+" "+"("+arr[0]+" "+arr[1]+")");
			for(int i=2;i<2*t;i=i+2)
			{
				stmt.executeUpdate("Alter Table "+tn+" ADD "+arr[i]+" "+arr[i+1]);
			}


			stmt.close();
			con.close();
		}
		catch(Exception e)
		{
				System.out.println(e);
		}
	}
	public static void InserDataInTable(String dp, String tn)
	{	Scanner kb = new Scanner(System.in);
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/"+dp,"root","");  
			//here august_19 is database name, root is username and password is empty 
			System.out.println("kitne element me Insert karna hai");
			int p = kb.nextInt();
			String values[] = new String[2*p];

			for(int i=0;i<p*2;i++)
			{
				values[i] = kb.next();
			}
			Statement stmt=con.createStatement(); 
			stmt.executeUpdate("insert into "+tn+" ("+values[0]+") values('"+values[1]+"')");
			String cond = values[0]+"='"+values[1]+"'";
			for(int i=2;i<2*p;i=i+2)
			{
				stmt.executeUpdate("update "+tn+" set "+values[i]+"='"+values[i+1]+"' where "+cond);  
			}
			  
			stmt.close();
			con.close();  
		}
		catch(Exception e)
		{ 	System.out.println(e);		
		}  
	}
	public static void UpdateDataInTable(String db,String tn)
	{	Scanner kb = new Scanner(System.in);
		try
		{	//Loading JDBC Drivers
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/"+db,"root","");  
			//here august_19 is database name, root is username and password is empty  
			Statement stmt=con.createStatement();  
			System.out.println("kis column me add krni hai");
			String s1 = kb.next();
			System.out.println("value btaoo");
			String s2 = kb.next();
			System.out.println("condition vala column btaoo");
			String s3 = kb.next();
			System.out.println("condition ki values btaoo");
			String s4 = kb.next();
			stmt.executeUpdate("update "+tn+" set "+s1+"='"+s2+"' where "+s3+"="+s4);  
			
			stmt.close();
			con.close();  
		}
		catch(Exception e)
		{ 	System.out.println(e);
		}
	}
	public static void ShowTable(String db,String tn)
	{
		try
		{	//Loading JDBC Drivers
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/"+db,"root","");  
			//here august_19 is database name, root is username and password is empty  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from "+tn); 
         	ResultSetMetaData rsMetaData = rs.getMetaData();
		    int count = rsMetaData.getColumnCount();
		    String as[] = new String[count];
		    for(int i = 1; i<=count; i++) 
		    {
		         as[i-1]=(String)rsMetaData.getColumnName(i);
		         System.out.print(as[i-1]+"\t");
		    }
		    System.out.println();
		    while (rs.next()) 
			{
				for(int i = 0; i<count; i++) {
		        String arr = rs.getString(as[i]);
		        	System.out.print(arr+"\t");
		      	}
		      	System.out.println();
			}
			stmt.close();
			con.close();  
		}
		catch(Exception e)
		{ 	System.out.println(e);
		}
	}
	public static void DeleteTable(String db,String tn)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/"+db,"root","");  
			//here august_19 is database name, root is username and password is empty  
			Statement stmt=con.createStatement();  
			int n=stmt.executeUpdate("delete from "+tn);  
			
			stmt.close();
			con.close();  
		}
		catch(Exception e)
		{ 	System.out.println(e);
		}
	}
	public static void DeleteDataInTable(String db,String tn,String condition)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/"+db,"root","");  
			//here august_19 is database name, root is username and password is empty  
			Statement stmt=con.createStatement();  
			int n=stmt.executeUpdate("delete from "+tn+" where "+condition);  
			
			System.out.println(n+"records deleted");
			
			stmt.close();
			con.close();  
		}
		catch(Exception e)
		{ 	System.out.println(e);
		}
	}
}