package com.WebQ.action;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.WebQ.beans.User;
import com.WebQ.db.RetrieveDbInfo;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String userId;
    private String password;
    private RetrieveDbInfo retrieveDbInfo;

    public LoginAction() {

    }

    public LoginAction(RetrieveDbInfo retrieveDbInfo) {
	super();
	this.setRetrieveDbInfo(retrieveDbInfo);
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
	    // addFieldError(userId, "invalid userId");
	    return false;
	}
	if (!isValidPassword(userId, password)) {
	    // addFieldError(password, "invalid password");
	    return false;
	}
	return true;

    }

    private boolean isValidPassword(String userId, String password) {
	if (StringUtils.isBlank(password)) {
	    // addFieldError(password, "blank password");
	    return false;
	}
	return retrieveDbInfo.getUser(userId).getPassword().equals(password);
    }

    private boolean isValidUserId(String userId) {
	if (StringUtils.isBlank(userId)) {
	    // addFieldError(userId, "blank userId");
	    return false;
	}
	return retrieveDbInfo.containsUser(userId);
    }

    @Override
    public String execute() {
	clearFieldErrors();
	User user = (User) session.get("user");
	if (user != null) {
	    return SUCCESS;
	} else {
	    if (isValidUser(userId, password)) {
		session.put("user", retrieveDbInfo.getUser(userId));
		session.put("context", new Date());
		return SUCCESS;
	    } else {
		return INPUT;
	    }
	}
    }

    public RetrieveDbInfo getRetrieveDbInfo() {
	return retrieveDbInfo;
    }

    public void setRetrieveDbInfo(RetrieveDbInfo retrieveDbInfo) {
	this.retrieveDbInfo = retrieveDbInfo;
    }

}
