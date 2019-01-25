package com.bridgelabz.preparedstatement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionManagement {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login2", "root", "root");
			con.setAutoCommit(false);
			
			PreparedStatement pstmt = con.prepareStatement("insert into user values(?,?)");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				System.out.println("enter username");
				String username = br.readLine();
				System.out.println("enter password");
				String password = br.readLine();
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				pstmt.executeUpdate();
				System.out.println("commit/Rollback");
				String answer = br.readLine();
				if(answer.equals("commit")) 
					con.commit();
				if(answer.equals("rollback"))
					con.rollback();
				System.out.println("Want to add more records y/n");
				String ans = br.readLine();
				if(ans.equals("n"))
					break;
			}
			con.commit();
			System.out.println("record successfully saved");
			con.close();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
