package signup;

import java.sql.DriverManager;
import com.mysql.jdbc.ResultSetMetaData;
//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.ResultSet;

public class Database 
{
	static Connection con=null;
	
	public static Connection dbconnect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytodolistapp","root","");
			return conn;	
		}
		
		catch(Exception exp)
		{
			System.out.println("In Sign Up Database File : "+exp.getMessage());
			return null;
		}
		
	}
	
}
