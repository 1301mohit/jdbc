/**
 * Purpose: The purpose of the class is to updates the record in the database.
 * 
 * @author  Mohit Kumar
 * @version 1.0
 * @since   22.01.2019
 */
package com.bridgelabz.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) {
		try {
			//Register the Driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			//Create connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login2", "root", "root");
			
			//Create statement
			Statement statement = connection.createStatement();
			
			//Execute queries
			int i = statement.executeUpdate("update user set username='Amit1',password='5678' where username='mohit123'");
			if(i == 0)
				System.out.println("Record is not present");
			System.out.println(i);
			
			//Close connection
			statement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
