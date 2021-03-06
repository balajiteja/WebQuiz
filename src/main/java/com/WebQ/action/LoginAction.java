package com.webq.action;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.webq.beans.User;
import com.webq.db.RetrieveDbInfo;

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
		this.retrieveDbInfo = retrieveDbInfo;
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
	
	private boolean isValidUser(String userId, String password)
			throws SQLException {
		
		if (!isValidUserId(userId)) {
			return false;
		}
		if (!isValidPassword(userId, password)) {
			return false;
		}
		return true;
		
	}
	
	private boolean isValidPassword(String userId, String password)
			throws SQLException {
		if (StringUtils.isBlank(password)) {
			return false;
		}
		return retrieveDbInfo.getUser(userId).getPassword().equals(password);
	}
	
	private boolean isValidUserId(String userId) throws SQLException {
		if (StringUtils.isBlank(userId)) {
			return false;
		}
		return retrieveDbInfo.containsUser(userId);
	}
	
	@Override
	public String execute() throws SQLException {
		clearFieldErrors();
		User user = (User) session.get("user");
		if (user != null) {
			return SUCCESS;
		} else {
			if ("admin".equals(userId) && "admin".equals(password)) {
				session.put("admin", new User("admin", "admin"));
				return "admin";
			}
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
