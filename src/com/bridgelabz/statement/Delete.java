/**
 * Purpose: The purpose of the class is to delete record in the database.
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

public class Delete {
	public static void main(String[] args) {
		try {
			//Register the Driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			//Create connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login2","root","root");
			
			//Create statement
			Statement statement = connection.createStatement();
			
			//Execute queries
			int result = statement.executeUpdate("delete from user where username='ravi123'");
			System.out.println(result+" records deleted");
			
			//Close connection
			statement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
