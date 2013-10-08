package com.WebQ.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import junit.framework.TestCase;

import com.WebQ.beans.User;

public class MySqlConnectionTest extends TestCase {

    static Statement statement;
    static Connection connection;

    public void testMySqlConnection() {
	ResultSet resultSet;
	User user;
	try {
	    Class.forName(DbConstants.DATABASE_DRIVER);
	    Connection connection = DriverManager.getConnection(
		    DbConstants.CONNECTION_URL, DbConstants.DB_USER_NAME,
		    DbConstants.DB_PASSWORD);
	    Statement statement = connection.createStatement();

	    String table = "user";
	    String field1 = "userId";
	    String value = "teja";

	    resultSet = statement.executeQuery("SELECT * FROM " + table
		    + " where " + field1 + "=\"" + value + "\"");
	    if (resultSet.next()) {
		user = new User(resultSet.getString(DbConstants.USER_ID),
			resultSet.getString(DbConstants.PASSWORD),
			resultSet.getString(DbConstants.FIRST_NAME),
			resultSet.getString(DbConstants.LAST_NAME),
			resultSet.getString(DbConstants.EMAIL_ID));
		System.out.println(user.getUserId());
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getEmailId());
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    public void testMySqlInsert() {
	ResultSet resultSet;
	User user;
	try {
	    Class.forName(DbConstants.DATABASE_DRIVER);
	    Connection connection = DriverManager.getConnection(
		    DbConstants.CONNECTION_URL, DbConstants.DB_USER_NAME,
		    DbConstants.DB_PASSWORD);
	    Statement statement = connection.createStatement();

	    user = new User("raghav12", "61740", "Raghav Seshu", "Sista",
		    "raghav@gmmail.com");

	    String queryString = "INSERT INTO " + DbConstants.USER_TABLE
		    + " VALUES('" + user.getUserId() + "','"
		    + user.getPassword() + "','" + user.getFirstName() + "','"
		    + user.getLastName() + "','" + user.getEmailId() + "')";
	    int i = statement.executeUpdate(queryString);
	    System.out.println(i);
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}
