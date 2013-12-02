package com.webq.action;

import java.util.Map;
import java.util.Timer;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.webq.beans.QuestionsCollection;
import com.webq.beans.User;
import com.webq.beans.UserStatusConstants;
import com.webq.db.RetrieveDbInfo;

public class TestCompleteAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	private Timer time;
	private String testAction;
	private QuestionsCollection questionsCollection;
	private final RetrieveDbInfo retrieveDbInfo;
	private int score;
	private int levelId;
	
	public int getLevelId() {
		return levelId;
	}
	
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	
	public RetrieveDbInfo getRetrieveDbInfo() {
		return retrieveDbInfo;
	}
	
	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public TestCompleteAction(RetrieveDbInfo retrieveDbInfo) {
		super();
		this.retrieveDbInfo = retrieveDbInfo;
	}
	
	@Override
	public String execute() {
		User user = (User) session.get("user");
		switch (user.getStatus()) {
			case UserStatusConstants.USER_LEVEL_ONE_STARTED :
				checkLevelOne(user);
				break;
			case UserStatusConstants.USER_LEVEL_TWO_STARTED :
				checkLevelTwo(user);
				break;
			case UserStatusConstants.USER_LEVEL_THREE_STARTED :
				checkLevelThree(user);
				break;
			default :
				break;
		}
		retrieveDbInfo.updateUserScore(user.getUserId(), levelId, score);
		user.addTotalScore(score);
		return SUCCESS;
	}
	
	private void checkLevelThree(User user) {
		if (score >= UserStatusConstants.LEVEL_THREE_LIMIT) {
			user.setStatus(UserStatusConstants.USER_LEVEL_THREE_COMPLETED);
			retrieveDbInfo.updateUserStatus(user.getUserId(),
					UserStatusConstants.USER_LEVEL_THREE_COMPLETED);
		} else {
			user.setStatus(UserStatusConstants.USER_LEVEL_TWO_COMPLETED);
			retrieveDbInfo.updateUserStatus(user.getUserId(),
					UserStatusConstants.USER_LEVEL_TWO_COMPLETED);
		}
	}
	
	private void checkLevelTwo(User user) {
		if (score >= UserStatusConstants.LEVEL_TWO_LIMIT) {
			user.setStatus(UserStatusConstants.USER_LEVEL_TWO_COMPLETED);
			retrieveDbInfo.updateUserStatus(user.getUserId(),
					UserStatusConstants.USER_LEVEL_TWO_COMPLETED);
		} else {
			user.setStatus(UserStatusConstants.USER_LEVEL_ONE_COMPLETED);
			retrieveDbInfo.updateUserStatus(user.getUserId(),
					UserStatusConstants.USER_LEVEL_ONE_COMPLETED);
		}
	}
	
	private void checkLevelOne(User user) {
		if (score >= UserStatusConstants.LEVEL_ONE_LIMIT) {
			user.setStatus(UserStatusConstants.USER_LEVEL_ONE_COMPLETED);
			retrieveDbInfo.updateUserStatus(user.getUserId(),
					UserStatusConstants.USER_LEVEL_ONE_COMPLETED);
		} else {
			user.setStatus(UserStatusConstants.USER_NULL);
			retrieveDbInfo.updateUserStatus(user.getUserId(),
					UserStatusConstants.USER_NULL);
		}
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
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
}
