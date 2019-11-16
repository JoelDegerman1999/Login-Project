package se.joeldegerman.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class LoginManager {

	public void login() {
		
	}

	public void createLoginAccount() throws SQLException {
		Statement st = getStatement();
		String insertSql = createUsernameAndPassword();
		try {
			st.executeUpdate(insertSql);
		} catch (MySQLIntegrityConstraintViolationException e) {
			System.out.println("Duplicate username is not allowed");
		}
	}

	private String createUsernameAndPassword() {
		String user = "";
		String pass = "";

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username:");
		user = sc.next();
		System.out.println("Enter password:");
		pass = sc.next();

		return "insert into login(username, password)" + " values('" + user + "','" + pass + "')";
	}

	private Statement getStatement() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/login_information";
		String username = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection.createStatement();
	}
}
