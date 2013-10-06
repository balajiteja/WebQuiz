package com.WebQ.action;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.WebQ.beans.User;
import com.WebQ.beans.UsersCollection;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String userId;
    private String password;
    private UsersCollection usersCollection;

    public LoginAction(UsersCollection usersCollection) {
	super();
	this.usersCollection = usersCollection;
    }

    public void init() {
    }

    public String getUserId() {
	return userId;
    }

    public void setUserId(String userId) {
	this.userId = userId;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    private Map<String, Object> session;

    @Override
    public void setSession(Map<String, Object> session) {
	this.session = session;
    }

    private boolean isValidUser(String userId, String password) {

	if (!isValidUserId(userId)) {
	    addFieldError(userId, "invalid userId");
	    return false;
	}
	if (!isValidPassword(userId, password)) {
	    addFieldError(password, "invalid password");
	    return false;
	}
	return true;

    }

    private boolean isValidPassword(String userId, String password) {
	return UsersCollection.getUsers().get(userId).getPassword()
		.equals(password);
    }

    private boolean isValidUserId(String userId) {
	return UsersCollection.getUsers().containsKey(userId);
    }

    @Override
    public String execute() {
	clearFieldErrors();
	User user = (User) session.get("user");
	if (user != null) {
	    return SUCCESS;
	} else {
	    if (isValidUser(userId, password)) {
		session.put("user", UsersCollection.getUsers().get(userId));
		session.put("authorized", true);
		session.put("context", new Date());
		return SUCCESS;
	    } else {
		addFieldError("invalid", "Invalid user or password");
		return INPUT;
	    }
	}
    }

    public UsersCollection getUsersCollection() {
	return usersCollection;
    }

    public void setUsersCollection(UsersCollection usersCollection) {
	this.usersCollection = usersCollection;
    }

}
