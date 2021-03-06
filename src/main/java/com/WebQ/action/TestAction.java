package com.webq.action;

import java.sql.SQLException;
import java.util.Map;
import java.util.Timer;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.webq.beans.QuestionsCollection;
import com.webq.beans.User;
import com.webq.beans.UserStatusConstants;
import com.webq.db.RetrieveDbInfo;

public class TestAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	private Timer time;
	private String testAction;
	private QuestionsCollection questionsCollection;
	private final RetrieveDbInfo retrieveDbInfo;
	private String statusTest;
	
	public RetrieveDbInfo getRetrieveDbInfo() {
		return retrieveDbInfo;
	}
	
	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public TestAction(RetrieveDbInfo retrieveDbInfo) {
		super();
		this.retrieveDbInfo = retrieveDbInfo;
	}
	
	@Override
	public String execute() throws SQLException { // NOSONAR
	
		User user = (User) session.get("user");
		if (user == null) {
			return "loginTimeout";
		}
		if (user != null) {
			// TO-DO Test logic here
			String status = user.getStatus();
			if (status == null) {
				status = UserStatusConstants.USER_NULL;
			}
			
			if (statusTest != null && "tried_to_cheat".equals(statusTest)) {
				handleCheatedUser(user);
				return "cheat";
			}
			
			switch (status) {
				case UserStatusConstants.USER_NULL :
					handleNewUser(user);
					return "start1";
				case UserStatusConstants.USER_LEVEL_ONE_COMPLETED :
					handleLevelOneCompletedUser(user);
					return "start2";
				case "Cheated" :
					handleCheatedUser(user);
					return "cheat";
				case UserStatusConstants.USER_LEVEL_TWO_COMPLETED :
					handleLevelTwoCompletedUser(user);
					return "start3";
				default :
					break;
			}
			return INPUT;
		}
		return ERROR;
	}

	private void handleLevelTwoCompletedUser(User user) throws SQLException {
		questionsCollection = retrieveDbInfo
				.getLevelThreeQuestions(user.getUserId());
		session.put("questions", questionsCollection);
		user.setStatus(UserStatusConstants.USER_LEVEL_THREE_STARTED);
		retrieveDbInfo.updateUserStatus(user.getUserId(),
				UserStatusConstants.USER_LEVEL_THREE_STARTED);
	}

	private void handleCheatedUser(User user) throws SQLException {
		questionsCollection = retrieveDbInfo
				.getLevelOneQuestions(user.getUserId());
		session.put("questions", questionsCollection);
		user.setStatus("tried_to_cheat");
		retrieveDbInfo.updateUserStatus(user.getUserId(),
				"tried_to_cheat");
	}

	private void handleLevelOneCompletedUser(User user) throws SQLException {
		questionsCollection = retrieveDbInfo
				.getLevelTwoQuestions(user.getUserId());
		session.put("questions", questionsCollection);
		user.setStatus(UserStatusConstants.USER_LEVEL_TWO_STARTED);
		retrieveDbInfo.updateUserStatus(user.getUserId(),
				UserStatusConstants.USER_LEVEL_TWO_STARTED);
	}

	private void handleNewUser(User user) throws SQLException {
		questionsCollection = retrieveDbInfo
				.getLevelOneQuestions(user.getUserId());
		session.put("questions", questionsCollection);
		user.setStatus(UserStatusConstants.USER_LEVEL_ONE_STARTED);
		retrieveDbInfo.updateUserStatus(user.getUserId(),
				UserStatusConstants.USER_LEVEL_ONE_STARTED);
	}
	
	public Timer getTime() {
		return time;
	}
	
	public void setTime(Timer time) {
		this.time = time;
	}
	
	public String getTestAction() {
		return testAction;
	}
	
	public void setTestAction(String testAction) {
		this.testAction = testAction;
	}
	
	public void init() {
		// Get questions collection
	}
	
	public QuestionsCollection getQuestionsCollection() {
		return questionsCollection;
	}
	
	public void setQuestionsCollection(QuestionsCollection questionsCollection) {
		this.questionsCollection = questionsCollection;
	}
	
	/**
	 * @return the statusTest
	 */
	public String getStatusTest() {
		return statusTest;
	}
	
	/**
	 * @param statusTest
	 *            the statusTest to set
	 */
	public void setStatusTest(String status) {
		this.statusTest = status;
	}
	
}
