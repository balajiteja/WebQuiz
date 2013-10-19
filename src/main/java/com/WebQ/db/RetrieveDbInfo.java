package com.WebQ.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.WebQ.beans.Question;
import com.WebQ.beans.QuestionsCollection;
import com.WebQ.beans.User;

public class RetrieveDbInfo implements RetrieveDbInfoImpl {

    Statement statement;
    Connection connection;
    private ResultSet resultSet;

    public RetrieveDbInfo() {
	init();
    }

    public boolean containsUser(String userId) {
	if (getUser(userId) == null) {
	    return false;
	} else {
	    return true;
	}
    }

    @Override
    public void init() {
	try {
	    Class.forName(DbConstants.DATABASE_DRIVER);
	    connection = DriverManager.getConnection(
		    DbConstants.CONNECTION_URL, DbConstants.DB_USER_NAME,
		    DbConstants.DB_PASSWORD);
	    statement = connection.createStatement();
	} catch (Exception e) {
	    Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
	}

    }

    public User getUser(String userId) {
	User user = null;
	ResultSet resultSet;
	try {
	    resultSet = getResultSet(DbConstants.USER_TABLE,
		    DbConstants.USER_ID, userId);
	    if (resultSet.next()) {
		user = new User(resultSet.getString(DbConstants.USER_ID),
			resultSet.getString(DbConstants.PASSWORD),
			resultSet.getString(DbConstants.FIRST_NAME),
			resultSet.getString(DbConstants.LAST_NAME),
			resultSet.getString(DbConstants.EMAIL_ID),
			resultSet.getString(DbConstants.STATUS));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
	}
	setUserScore(user);
	return user;
    }

    public void setUserScore(User user) {
	ResultSet resultSet;
	try {
	    resultSet = getResultSet(DbConstants.LEVEL_SCORE_TABLE,
		    DbConstants.USER_ID, user.getUserId());
	    while (resultSet.next()) {
		user.setLevelScore(resultSet.getInt(DbConstants.LEVEL_ID),
			resultSet.getInt(DbConstants.SCORE));
		user.addTotalScore(resultSet.getInt(DbConstants.SCORE));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
	}
    }

    private ResultSet getResultSet(String targetField, String table,
	    String field1, String value) {
	// Select [targetField] from [table] where [field1]="[value]";
	try {
	    resultSet = statement.executeQuery("SELECT " + targetField
		    + " FROM " + table + " where " + field1 + "=\"" + value
		    + "\"");

	} catch (SQLException e) {
	    Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
	}
	return resultSet;
    }

    private ResultSet getResultSet(String table, String field1, String value) {
	ResultSet resultSet = null;
	// Select * from [table] where [field1]="[value]";
	try {
	    resultSet = statement.executeQuery("SELECT * FROM " + table
		    + " where " + field1 + "=\"" + value + "\"");
	} catch (SQLException e) {
	    e.printStackTrace();
	    Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
	}
	return resultSet;
    }

    private ResultSet getResultSet(String table, String field1, int value) {
	ResultSet resultSet = null;
	// Select * from [table] where [field1]="[value]";
	try {
	    resultSet = statement.executeQuery("SELECT * FROM " + table
		    + " where " + field1 + "=" + value);
	} catch (SQLException e) {
	    e.printStackTrace();
	    Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
	}
	return resultSet;
    }

    private ResultSet getResultSet(String targetField, String table) {
	ResultSet resultSet = null;
	// Select [targetField] from [table];
	try {
	    resultSet = statement.executeQuery("SELECT " + targetField
		    + " FROM " + table);

	} catch (SQLException e) {
	    Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
	}
	return resultSet;
    }

    private ResultSet getResultSet(String table) {
	ResultSet resultSet = null;
	// Select * from [table];
	try {
	    resultSet = statement.executeQuery("SELECT * FROM " + table);

	} catch (SQLException e) {
	    Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
	}
	return resultSet;
    }

    public boolean addUser(User user) {
	int i = 0;
	// Select * from [table];
	try {
	    String queryString = "INSERT INTO " + DbConstants.USER_TABLE
		    + " VALUES('" + user.getUserId() + "','"
		    + user.getPassword() + "','" + user.getFirstName() + "','"
		    + user.getLastName() + "','" + user.getEmailId() + "','"
		    + user.getStatus() + "')";
	    i = statement.executeUpdate(queryString);

	} catch (SQLException e) {
	    Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
	}
	if (i == 1) {
	    return true;
	} else {
	    return false;
	}

    }

    public QuestionsCollection getLevelOneQuestions(String userId) {
	// TODO logic to get all the questions of level i
	QuestionsCollection questionsCollection = new QuestionsCollection();
	ResultSet resultSet;
	try {
	    resultSet = getResultSet(DbConstants.QUESTION_TABLE,
		    DbConstants.LEVEL_ID, 1);
	    while (resultSet.next()) {
		questionsCollection.addQuestion(new Question(resultSet
			.getInt(DbConstants.QUESTION_ID), resultSet
			.getInt(DbConstants.LEVEL_ID), resultSet
			.getString(DbConstants.QUESTION_DESCRIPTION), resultSet
			.getString(DbConstants.OPTION1), resultSet
			.getString(DbConstants.OPTION2), resultSet
			.getString(DbConstants.OPTION3), resultSet
			.getString(DbConstants.OPTION4), resultSet
			.getString(DbConstants.ANSWER)));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
	}

	return questionsCollection;
    }

    public QuestionsCollection getLevelTwoQuestions(String userId) {
	// TODO logic to get all the questions of level i
	QuestionsCollection questionsCollection = new QuestionsCollection();
	ResultSet resultSet;
	try {
	    resultSet = getResultSet(DbConstants.QUESTION_TABLE,
		    DbConstants.LEVEL_ID, 2);
	    while (resultSet.next()) {
		questionsCollection.addQuestion(new Question(resultSet
			.getInt(DbConstants.QUESTION_ID), resultSet
			.getInt(DbConstants.LEVEL_ID), resultSet
			.getString(DbConstants.QUESTION_DESCRIPTION), resultSet
			.getString(DbConstants.OPTION1), resultSet
			.getString(DbConstants.OPTION2), resultSet
			.getString(DbConstants.OPTION3), resultSet
			.getString(DbConstants.OPTION4), resultSet
			.getString(DbConstants.ANSWER)));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
	}

	return questionsCollection;
    }

    public QuestionsCollection getLevelThreeQuestions(String userId) {
	// TODO logic to get all the questions of level i
	QuestionsCollection questionsCollection = new QuestionsCollection();
	ResultSet resultSet;
	try {
	    resultSet = getResultSet(DbConstants.QUESTION_TABLE,
		    DbConstants.LEVEL_ID, 3);
	    while (resultSet.next()) {
		questionsCollection.addQuestion(new Question(resultSet
			.getInt(DbConstants.QUESTION_ID), resultSet
			.getInt(DbConstants.LEVEL_ID), resultSet
			.getString(DbConstants.QUESTION_DESCRIPTION), resultSet
			.getString(DbConstants.OPTION1), resultSet
			.getString(DbConstants.OPTION2), resultSet
			.getString(DbConstants.OPTION3), resultSet
			.getString(DbConstants.OPTION4), resultSet
			.getString(DbConstants.ANSWER)));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
	}

	return questionsCollection;
    }

    public boolean addQuestion(Question question) {
	int i = 0;
	// Select * from [table];
	try {
	    String queryString = "INSERT INTO " + DbConstants.QUESTION_TABLE
		    + " VALUES('" + question.getQuestionId() + "','"
		    + question.getLevelId() + "','"
		    + question.getQuestionDescription() + "','"
		    + question.getOption1() + "','" + question.getOption2()
		    + "','" + question.getOption3() + "','"
		    + question.getOption4() + "','" + question.getAnswer()
		    + "')";
	    i = statement.executeUpdate(queryString);

	} catch (SQLException e) {
	    Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
	}
	if (i == 1) {
	    return true;
	} else {
	    return false;
	}

    }

    public boolean updateUserStatus(String userId, String status) {
	int i = 0;
	// Select * from [table];
	try {
	    String queryString = "UPDATE " + DbConstants.USER_TABLE + " SET "
		    + DbConstants.STATUS + "='" + status + "' WHERE "
		    + DbConstants.USER_ID + "='" + userId + "'";
	    i = statement.executeUpdate(queryString);

	} catch (SQLException e) {
	    Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
	}
	if (i == 1) {
	    return true;
	} else {
	    return false;
	}
    }

    public boolean updateUserScore(String userId, int levelId, int score) {
	int i = 0;
	// Select * from [table];
	try {
	    String queryString = "INSERT INTO " + DbConstants.LEVEL_SCORE_TABLE
		    + " VALUES('" + userId + "'," + levelId + "," + score + ")";
	    i = statement.executeUpdate(queryString);

	} catch (SQLException e) {
	    Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
	}
	if (i == 1) {
	    return true;
	} else {
	    return false;
	}
    }

    public static void main(String[] args) {
	RetrieveDbInfo rb = new RetrieveDbInfo();
	rb.init();
	Question question = new Question();
	int qid = 11;
	question.setQuestionId(qid);
	question.setLevelId(2);
	question.setQuestionDescription("Function oriented metrics were first proposed by?");
	question.setOption1("John");
	question.setOption2("Gaffney");
	question.setOption3("Albrecht");
	question.setOption4("Basili");
	question.setAnswer("3");

	System.out.println(rb.addQuestion(question));
	// System.out.println(rb.getLevelOneQuestions(""));
    }

}
