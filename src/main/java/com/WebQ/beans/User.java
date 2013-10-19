package com.WebQ.beans;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String userId;
    private String password;

    private String firstName;
    private String lastName;
    private String emailId;
    private String status;
    private int totalScore = 0;

    public int getTotalScore() {
	return totalScore;
    }

    public void setTotalScore(int totalScore) {
	this.totalScore = totalScore;
    }

    private Map<Integer, Integer> score = new HashMap<Integer, Integer>();

    public User() {

    }

    public User(String userId, String password) {
	super();
	this.userId = userId;
	this.password = password;
    }

    public User(String userId, String password, String firstName,
	    String lastName, String emailId) {
	super();
	this.userId = userId;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.emailId = emailId;
    }

    public User(String userId, String password, String firstName,
	    String lastName, String emailId, String status) {
	super();
	this.userId = userId;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.emailId = emailId;
	this.status = status;
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

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getEmailId() {
	return emailId;
    }

    public void setEmailId(String emailId) {
	this.emailId = emailId;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public Map<Integer, Integer> getScore() {
	return score;
    }

    public void setScore(Map<Integer, Integer> score) {
	this.score = score;
    }

    public void setLevelScore(int level, int score) {
	this.score.put(new Integer(level), new Integer(score));
    }

    public int getLevelScore(int level) {
	return score.get(level);
    }

    public int addTotalScore(int score2) {
	totalScore = totalScore + score2;
	return totalScore;
    }

}
