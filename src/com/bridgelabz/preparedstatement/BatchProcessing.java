package com.bridgelabz.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchProcessing {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login2", "root", "root");
				PreparedStatement preparedStatement = connection.prepareStatement("insert into user values(?,?)");
				Scanner scanner = new Scanner(System.in);
				while(true) {
					System.out.println("Enter username");
					String username = scanner.next();
					System.out.println("Enter password");
					String password = scanner.next();
					preparedStatement.setString(1, username);
					preparedStatement.setString(2, password);
					preparedStatement.addBatch();
					System.out.println("Want to add more records y/n");
					String ans = scanner.next();
					if(ans.equals("n")) {
						break;
					}
				}
				preparedStatement.executeBatch();
				System.out.println("records successfully saved");
				connection.close();
				scanner.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
