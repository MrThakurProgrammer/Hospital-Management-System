package DatabaseConnection;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider 
{
	private static Connection con;	
	public static Connection getConnection()
		{
			if(con == null)
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system","root","thakur");		
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			return con;
		}
}

