/**
 * Purpose: The purpose of the class to execute multiple query in single execution
 * 
 * @author  Mohit Kumar
 * @version 1.0
 * @since   23.01.2019
 */
package com.bridgelabz.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionManagement {
	public static void main(String[] args) {
		try {
			
			//Register the Driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			//Create connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login2", "root", "root");
			connection.setAutoCommit(false);
			
			//Create statement
			Statement statement = connection.createStatement();
			
			//Execute queries
			statement.executeUpdate("insert into user values('a','1')");
			statement.executeUpdate("insert into user values('b','2')");
			
			//Close connection
			connection.commit();
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
