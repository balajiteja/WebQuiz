package com.webq.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.webq.beans.Question;
import com.webq.beans.QuestionsCollection;
import com.webq.beans.User;

public class RetrieveDbInfo implements RetrieveDbInfoImpl {
	
	private Statement statement;
	private Connection connection;
	
	public RetrieveDbInfo() {
		init(); // NOSONAR
	}
	
	public boolean containsUser(String userId) throws SQLException {
		ResultSet resultSet = null;
		resultSet = getResultSet(DbConstants.USER_TABLE, DbConstants.USER_ID,
				userId);
		try {
			if (resultSet.next()
					&& resultSet.getString(DbConstants.USER_ID) != null) {
				return true;
			}
		} catch (SQLException e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		} catch (Exception e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
		}
		return false;
	}
	
	@Override
	public void init() {
		try {
			Class.forName(DbConstants.DATABASE_DRIVER);
			connection = DriverManager.getConnection(
					DbConstants.CONNECTION_URL, DbConstants.DB_USER_NAME,
					DbConstants.DB_PASSWORD);
			statement = connection.createStatement();
		} catch (Exception e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		}
		
	}
	
	public User getUser(String userId) throws SQLException {
		User user = null;
		ResultSet resultSet = null;
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
			getUserScore(user);
		} catch (SQLException e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		} catch (Exception e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		} finally {
			resultSet.close();
		}
		return user;
	}
	
	public void getUserScore(User user) throws SQLException {
		ResultSet resultSet = null;
		try {
			resultSet = getResultSet(DbConstants.LEVEL_SCORE_TABLE,
					DbConstants.USER_ID, user.getUserId());
			while (resultSet.next()) {
				user.setLevelScore(resultSet.getInt(DbConstants.LEVEL_ID),
						resultSet.getInt(DbConstants.SCORE));
				user.addTotalScore(resultSet.getInt(DbConstants.SCORE));
			}
		} catch (SQLException e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		} catch (Exception e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		} finally {
			resultSet.close();
		}
	}
	
	private ResultSet getResultSet(String table, String field1, String value) {
		ResultSet resultSet = null; // NOSONAR
		// Select * from [table] where [field1]="[value]"; //NOSONAR
		try {
			resultSet = statement.executeQuery("SELECT * FROM " + table
					+ " where " + field1 + "=\"" + value + "\"");
		} catch (SQLException e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		} catch (Exception e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		}
		return resultSet;
	}
	
	private ResultSet getResultSet(String table, String field1, int value) {
		ResultSet resultSet = null; // NOSONAR
		// Select * from [table] where [field1]="[value]"; //NOSONAR
		try {
			resultSet = statement.executeQuery("SELECT * FROM " + table
					+ " where " + field1 + "=" + value);
		} catch (SQLException e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		} catch (Exception e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		}
		
		return resultSet;
	}
	
	public boolean addUser(User user) {
		int i = 0;
		// Select * from [table]; //NOSONAR
		try {
			String queryString = "INSERT INTO " + DbConstants.USER_TABLE
					+ " VALUES('" + user.getUserId() + "','"
					+ user.getPassword() + "','" + user.getFirstName() + "','"
					+ user.getLastName() + "','" + user.getEmailId() + "','"
					+ user.getStatus() + "')";
			i = statement.executeUpdate(queryString);
			
		} catch (SQLException e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		} catch (Exception e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		}
		return i == 1;
		
	}
	
	public QuestionsCollection getLevelOneQuestions(String userId)
			throws SQLException {
		QuestionsCollection questionsCollection = new QuestionsCollection();
		ResultSet resultSet = null;
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
		} catch (SQLException e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		} catch (Exception e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		} finally {
			resultSet.close();
		}
		
		return questionsCollection;
	}
	
	public QuestionsCollection getLevelTwoQuestions(String userId)
			throws SQLException {
		QuestionsCollection questionsCollection = new QuestionsCollection();
		ResultSet resultSet = null;
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
		} catch (SQLException e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		} catch (Exception e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		} finally {
			resultSet.close();
		}
		
		return questionsCollection;
	}
	
	public QuestionsCollection getLevelThreeQuestions(String userId)
			throws SQLException {
		QuestionsCollection questionsCollection = new QuestionsCollection();
		ResultSet resultSet = null;
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
		} catch (SQLException e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		} catch (Exception e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		} finally {
			resultSet.close();
		}
		return questionsCollection;
	}
	
	public boolean addQuestion(Question question) {
		int i = 0;
		// Select * from [table]; //NOSONAR
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
			
		} catch (SQLException e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		} catch (Exception e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		}
		return i == 1;
		
	}
	
	public boolean updateUserStatus(String userId, String status) {
		int i = 0;
		// Select * from [table]; //NOSONAR
		try {
			String queryString = "UPDATE " + DbConstants.USER_TABLE + " SET "
					+ DbConstants.STATUS + "='" + status + "' WHERE "
					+ DbConstants.USER_ID + "='" + userId + "'";
			i = statement.executeUpdate(queryString);
			
		} catch (SQLException e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		} catch (Exception e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		}
		return i == 1;
	}
	
	public boolean updateUserScore(String userId, int levelId, int score) {
		int i = 0;
		// Select * from [table]; //NOSONAR
		try {
			String queryString = "INSERT INTO " + DbConstants.LEVEL_SCORE_TABLE
					+ " VALUES('" + userId + "'," + levelId + "," + score
					+ ") ON DUPLICATE KEY UPDATE score=" + score;
			i = statement.executeUpdate(queryString);
			
		} catch (SQLException e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		} catch (Exception e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		}
		return i == 1;
	}
	
	public boolean deleteFromTable(String table, String column, String value) {
		int i = 0;
		// Select * from [table]; //NOSONAR
		try {
			String queryString = "DELETE FROM " + table + " WHERE " + column
					+ " = '" + value + "'";
			i = statement.executeUpdate(queryString);
			
		} catch (SQLException e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		} catch (Exception e) { // NOSONAR
			Logger.getLogger(RetrieveDbInfo.class).error(e.toString());
		}
		return i == 1;
	}
	
	public static void main(String[] args) {
		RetrieveDbInfo rb = new RetrieveDbInfo();
		rb.init();
		Question question = new Question();
		int qid = 30;
		question.setQuestionId(qid);
		question.setLevelId(3);
		question.setQuestionDescription("While the concept of social distance applies _____________ to human relationships, the _____________ of closeness and distance varies between cultures");
		question.setOption1("unequivocally �� materialization");
		question.setOption2("universally �� manifestation");
		question.setOption3("unambiguously �� degree");
		question.setOption4("unconditionally �� extent");
		question.setAnswer("2");
		
		System.out.println(rb.addQuestion(question)); // NOSONAR
		
	}
	
}
