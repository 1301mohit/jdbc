/**
 * Purpose: Show Login form
 * 
 * @author  Mohit Kumar
 * @version 1.0
 * @since   22.01.2019
 */
package com.bridgelabz.preparedstatement;

import java.util.Scanner;

import com.bridgelabz.preparedstatement.User;
import com.bridgelabz.preparedstatement.Login;
import com.bridgelabz.preparedstatement.Register;

public class LoginForm {
	public static void main(String[] args) {
		int choice = 0;
		int choice1 = 0;
		User user = new User();
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("1.Login");
			System.out.println("2.Register");
			System.out.println("3.Exit");
			choice = scanner.nextInt();
			if(choice != 1 && choice != 2 && choice != 3)
				System.out.println("Please enter right choice");
			
			switch(choice) {
			case 1:{
				System.out.println("Enter username");
				String username = scanner.next();
				user.setUserName(username);
				System.out.println("Enter password");
				String password = scanner.next();
				user.setUserPassword(password);
				boolean flag = Login.check(user);
				if(flag == false) {
					System.out.println("Invalid username or password");
				}
				else {
					System.out.println();
					System.out.println("Login Successful");
					System.out.println();
					do {
						System.out.println("1.Update");
						System.out.println("2.Delete");
						System.out.println("3.Exit");
						choice1 = scanner.nextInt();
					switch(choice1) {
					case 1:{
						Login.update(user);
						break;
					}
					case 2:{
						Login.delete(user);
						break;
					}
					case 3:{
						break;
					}
					default:{
						System.out.println();
						System.out.println("Please enter right choice");
						System.out.println();
					}
					}
					}while(choice1 != 3);
				}
				break;	
			}
			case 2:{
				System.out.println("Enter username");
				String username = scanner.next();
				user.setUserName(username);
				System.out.println("Enter password");
				String password = scanner.next();
				user.setUserPassword(password);
				Register.register(user);
				break;
			}
			case 3:
				break;
			default:
				System.out.println("Please enter right choice");
			}
		}while(choice != 3);
		scanner.close();
	}
}
