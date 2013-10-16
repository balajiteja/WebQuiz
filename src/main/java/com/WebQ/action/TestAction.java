package com.WebQ.action;

import java.util.Map;
import java.util.Timer;

import org.apache.struts2.interceptor.SessionAware;

import com.WebQ.beans.QuestionsCollection;
import com.WebQ.beans.User;
import com.WebQ.beans.UserStatusConstants;
import com.WebQ.db.RetrieveDbInfo;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport implements SessionAware {

    private static final long serialVersionUID = 1L;
    private Timer time;
    private String testAction;
    private QuestionsCollection questionsCollection;
    private final RetrieveDbInfo retrieveDbInfo;
    private final Integer sc = new Integer(0);

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
    public String execute() {
	User user = (User) session.get("user");
	questionsCollection = retrieveDbInfo
		.populateQuestions(user.getUserId());
	session.put("questions", questionsCollection);
	if (user != null) {
	    // TO-DO Test logic here
	    String status = user.getStatus();
	    switch (status) {
	    case UserStatusConstants.USER_NULL:
		session.put(user.getUserId() + 1, sc);
		questionsCollection.populateLevel1();
		return "start1";
	    case "NULL":
		session.put(user.getUserId() + 1, sc);
		questionsCollection.populateLevel1();
		return "start1";
	    case UserStatusConstants.USER_LEVEL_ONE_COMPLETED:
		return "start2";
	    case UserStatusConstants.USER_LEVEL_TWO_COMPLETED:
		return "start3";
	    default:
		break;
	    }
	    return INPUT;
	}
	return ERROR;
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

}
