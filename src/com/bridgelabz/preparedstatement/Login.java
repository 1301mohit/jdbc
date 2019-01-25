/**
 * Purpose: Methods of Login form
 * 
 * @author  Mohit Kumar
 * @version 1.0
 * @since   25.01.2019
 */
package com.bridgelabz.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bridgelabz.preparedstatement.User;

public class Login {
	
	static Scanner sc = new Scanner(System.in);
	
	//Check user data is present or not in database
	public static boolean check(User user) {
		boolean flag = false; 
		ResultSet resultSet = null;
		try {
			//Register the Driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			//Create connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login2", "root", "root");
			
			//Create preparedStatement
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user where username = ? && password = ?");
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getUserPassword());
			
			//Execute queries
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
				flag = true;
			else
				flag = false;
			
			//Close connection
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	//Update user details
	public static void update(User user) {
		try {
			System.out.println("Enter username");
			String username = sc.next();
			System.out.println("Enter password");
			String password = sc.next();
			
			//Register the Driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			//Create connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login2", "root", "root");
			
			//Create preparedStatement
			PreparedStatement preparedStatement = connection.prepareStatement("update user set username = ?,password = ? where username = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, user.getUserName());
			
			//Execute queries
			int i = preparedStatement.executeUpdate();
			if(i != 0) {
				System.out.println("Record updated");
				user.setUserName(username);
				user.setUserPassword(password);
			}
			else
				System.out.println("Record not updated");
			
			//Close connection
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	//Delete user details
	public static void delete(User user) {
			try {
				
				//Register the Driver class
				Class.forName("com.mysql.jdbc.Driver");
				
				//Create connection
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login2", "root", "root");
				
				//Create preparedStatement
				PreparedStatement preparedStatement = connection.prepareStatement("delete from user where username = ?");
				preparedStatement.setString(1, user.getUserName());
				
				//Execute queries
				int i = preparedStatement.executeUpdate();
				if(i != 0)
					System.out.println("Record deleted");
				else
					System.out.println("Record not deleted");
				
				//Close connection
				preparedStatement.close();
				connection.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
	}
}
