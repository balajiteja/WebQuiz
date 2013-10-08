package com.WebQ.action;

import org.apache.log4j.Logger;

import com.WebQ.beans.User;
import com.WebQ.db.RetrieveDbInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

public class RegistrationAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String userId;
    private String password;
    private String password2;

    private String firstName;
    private String lastName;
    private String emailId;
    private final RetrieveDbInfo retrieveDbInfo;

    public RegistrationAction(RetrieveDbInfo retrieveDbInfo) {
	super();
	this.retrieveDbInfo = retrieveDbInfo;
    }

    public void init() {
    }

    @Override
    public String execute() {
	try {
	    if (retrieveDbInfo.containsUser(userId)) {
		addFieldError(userId,
			"UserId already exist.Please enter a new one.");
		return INPUT;
	    }
	    if (!validatePassword(password, password2)) {
		addFieldError(password,
			"Please make sure that the passwords match and are of atleast of length 4");
		return INPUT;
	    }
	    addUserToDB();
	    return SUCCESS;
	} catch (Exception e) {
	    Logger.getLogger(RegistrationAction.class).error(e.toString());
	    return ERROR;
	}
    }

    private void addUserToDB() {
	retrieveDbInfo.addUser(new User(userId, password, firstName, lastName,
		emailId));
    }

    private boolean validatePassword(String p1, String p2) {
	if (p1.equals(p2) && p1.length() >= 4) {
	    return true;
	}
	return false;
    }

    public String getUserId() {
	return userId;
    }

    @RequiredStringValidator(message = "Please enter a UserId", trim = true)
    public void setUserId(String userId) {
	this.userId = userId;
    }

    public String getPassword() {
	return password;
    }

    @RequiredStringValidator(message = "Please enter a password", trim = true)
    public void setPassword(String password) {
	this.password = password;
    }

    public String getLastName() {
	return lastName;
    }

    @RequiredStringValidator(message = "Please enter a LastName", trim = true)
    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getFirstName() {
	return firstName;
    }

    @RequiredStringValidator(message = "Please enter a firstName", trim = true)
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getEmailId() {
	return emailId;
    }

    @RequiredStringValidator(message = "Please enter a emailId", trim = true)
    public void setEmailId(String emailId) {
	this.emailId = emailId;
    }

    public String getPassword2() {
	return password2;
    }

    @RequiredStringValidator(message = "Please re enter a password", trim = true)
    public void setPassword2(String password2) {
	this.password2 = password2;
    }

}
