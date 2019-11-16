package se.joeldegerman.models;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		LoginManager loginManager = new LoginManager();
		loginManager.createLoginAccount();
	}

}
