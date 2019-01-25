package com.bridgelabz.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bridgelabz.preparedstatement.User;

public class Register {
	
	public static void register(User user) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login2", "root", "root");
			PreparedStatement pstmt = connection.prepareStatement("Insert into user values(?,?)");
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserPassword());
			int i = pstmt.executeUpdate();
			if(i != 0)
				System.out.println("Registion successful");
			else
				System.out.println("Registration not successful");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
