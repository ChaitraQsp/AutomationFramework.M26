package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBC {
	
	@Test
	public void executeQueryJDBC() throws SQLException
	{
		
		Driver dref = new Driver();
		
		//Step 1: Register the Driver
		DriverManager.registerDriver(dref);
		
		//Step 2: Get the connection with driver/database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		
		//Step 3: issue create statement
		Statement state = con.createStatement();
		
		//Step 4: Execute any query
		ResultSet result = state.executeQuery("select * from customerinfo;");
		
		while(result.next())
		{
			System.out.println(result.getString(1)+"-"+result.getInt(2)+"-"+result.getString(3));
		}
		
		//Step 5: Close the database
		con.close();
		System.out.println("db closed");

	}
	
	@Test
	public void executeUpdateJDBC() throws SQLException
	{
		Driver dref = new Driver();
		
		//Step 1: Register the Driver
		DriverManager.registerDriver(dref);
		
		//Step 2: Get the connection with driver/database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		
		//Step 3: issue create statement
		Statement state = con.createStatement();
		
		//Step 4: Execute any query
		int result = state.executeUpdate("insert into customerinfo values('Alex',12,'NewYork');");
		
		if(result==1)
		{
			System.out.println("Data is added");
		}
		
		
		//Step 5: Close the database
		con.close();
		System.out.println("db closed");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
