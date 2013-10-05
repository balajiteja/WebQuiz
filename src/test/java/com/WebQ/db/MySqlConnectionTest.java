package com.WebQ.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import junit.framework.TestCase;

public class MySqlConnectionTest extends TestCase {

    public void testMySqlConnection() {
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection connection = DriverManager.getConnection(
		    "jdbc:mysql://localhost:3306/webQuizDb", "teja", "123456");
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement
		    .executeQuery("SELECT * FROM level_score;");
	    while (resultSet.next()) {
		// System.out.println(resultSet.);
		System.out.println("Level Id:"
			+ resultSet.getString("Level_Id"));
		System.out.println("Score:" + resultSet.getString("Score"));
		System.out.println("User Id:" + resultSet.getString("User_Id"));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}
