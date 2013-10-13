package com.WebQ.action;

import java.util.Map;
import java.util.Timer;

import org.apache.struts2.interceptor.SessionAware;

import com.WebQ.beans.Test;
import com.WebQ.beans.User;
import com.WebQ.beans.UserStatusConstants;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport implements SessionAware {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Timer time;
    private final Test test;
    private String testAction;

    private Map<String, Object> session;

    @Override
    public void setSession(Map<String, Object> session) {
	this.session = session;
    }

    @Override
    public String execute() {
	User user = (User) session.get("user");
	if (user != null) {
	    // TO-DO Test logic here
	    String status = user.getStatus();
	    switch (status) {
	    case UserStatusConstants.USER_NULL:
		return "start1";
	    case "NULL":
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

    public Test getTest() {
	return test;
    }

    public TestAction(Test test) {
	super();
	this.test = test;
    }

    public void init() {
	// Get questions collection
    }

}
