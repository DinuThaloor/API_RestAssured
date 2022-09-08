package com.crm.genericUtilities;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

/**
 * 
 * @author dinuh
 *
 */
public class DataBaseUtility
{
	static Driver driverRef;
	static Connection connection;
	static ResultSet result;

	/**
	 * this method is used to connect to DataBase
	 * @param DBname
	 */
	public void connectToDB()
	{
		try
		{
			driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			connection=DriverManager.getConnection(IConstants.DBUrl,IConstants.DBUsername,IConstants.DBPassword);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * this method is used to closeDataBase connection
	 */
	public void closeDB()
	{
		try
		{
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * this method is used to perform execute query
	 * @param query
	 * @param columnNum
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public boolean executeQuery(String query,int columnNum,String expectedData) throws SQLException
	{
		result = connection.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			if(result.getString(columnNum).equals(expectedData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("data is present");
			return flag;
		}
		else
		{
			System.out.println("data is not present");
			return flag;
		}
	}

	/**
	 * this method is used to perform execute update
	 * @param query
	 * @throws SQLException
	 */
	public void executeUpdate(String query) throws SQLException
	{
		int result=connection.createStatement().executeUpdate(query);
		if(result==1)
		{
			System.out.println("data is updated");
		}
		else
		{
			System.out.println("data is not updated");
		}
	}
}
