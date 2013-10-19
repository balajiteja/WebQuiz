package com.WebQ.action;

import java.util.Map;
import java.util.Timer;

import org.apache.struts2.interceptor.SessionAware;

import com.WebQ.beans.QuestionsCollection;
import com.WebQ.beans.User;
import com.WebQ.beans.UserStatusConstants;
import com.WebQ.db.RetrieveDbInfo;
import com.opensymphony.xwork2.ActionSupport;

public class TestCompleteAction extends ActionSupport implements SessionAware {

    private static final long serialVersionUID = 1L;
    private Timer time;
    private String testAction;
    private QuestionsCollection questionsCollection;
    private final RetrieveDbInfo retrieveDbInfo;
    private final Integer sc = new Integer(0);
    private int score;
    private int levelId;

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
	case UserStatusConstants.USER_LEVEL_ONE_STARTED:
	    if (score >= UserStatusConstants.LEVEL_ONE_LIMIT) {
		user.setStatus(UserStatusConstants.USER_LEVEL_ONE_COMPLETED);
		retrieveDbInfo.updateUserStatus(user.getUserId(),
			UserStatusConstants.USER_LEVEL_ONE_COMPLETED);
	    } else {
		user.setStatus(UserStatusConstants.USER_NULL);
		retrieveDbInfo.updateUserStatus(user.getUserId(),
			UserStatusConstants.USER_NULL);
	    }
	    break;
	case UserStatusConstants.USER_LEVEL_TWO_STARTED:
	    if (score >= UserStatusConstants.LEVEL_TWO_LIMIT) {
		user.setStatus(UserStatusConstants.USER_LEVEL_TWO_COMPLETED);
		retrieveDbInfo.updateUserStatus(user.getUserId(),
			UserStatusConstants.USER_LEVEL_TWO_COMPLETED);
	    } else {
		user.setStatus(UserStatusConstants.USER_LEVEL_ONE_COMPLETED);
		retrieveDbInfo.updateUserStatus(user.getUserId(),
			UserStatusConstants.USER_LEVEL_ONE_COMPLETED);
	    }
	    break;
	case UserStatusConstants.USER_LEVEL_THREE_STARTED:
	    if (score >= UserStatusConstants.LEVEL_THREE_LIMIT) {
		user.setStatus(UserStatusConstants.USER_LEVEL_THREE_COMPLETED);
		retrieveDbInfo.updateUserStatus(user.getUserId(),
			UserStatusConstants.USER_LEVEL_THREE_COMPLETED);
	    } else {
		user.setStatus(UserStatusConstants.USER_LEVEL_TWO_COMPLETED);
		retrieveDbInfo.updateUserStatus(user.getUserId(),
			UserStatusConstants.USER_LEVEL_TWO_COMPLETED);
	    }
	    break;
	default:
	    break;
	}
	retrieveDbInfo.updateUserScore(user.getUserId(), levelId, score);
	user.addTotalScore(score);
	return SUCCESS;
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

    public void getLevelOneScore() {

    }

    public int getScore() {
	return score;
    }

    public void setScore(int score) {
	this.score = score;
    }

}
