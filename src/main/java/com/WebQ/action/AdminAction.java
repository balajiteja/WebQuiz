package com.webq.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.webq.beans.Question;
import com.webq.db.RetrieveDbInfo;

public class AdminAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	private int questionId;
	private int levelId;
	private String questionDescription;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;
	private final RetrieveDbInfo retrieveDbInfo;
	private Map<String, Object> session;
	
	public AdminAction(RetrieveDbInfo retrieveDbInfo) {
		this.retrieveDbInfo = retrieveDbInfo;
	}
	
	@Override
	public String execute() {
		boolean addSuccess = false;
		Question q = new Question(questionId, levelId, questionDescription,
				option1, option2, option3, option4, answer);
		addSuccess = retrieveDbInfo.addQuestion(q);
		if (addSuccess) {
			session.put("add", SUCCESS);
			return SUCCESS;
		} else {
			session.put("add", ERROR);
			return ERROR;
		}
	}
	public int getQuestionId() {
		return questionId;
	}
	
	@RequiredStringValidator(message = "Please enter a QuestionId", trim = true)
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
	public int getLevelId() {
		return levelId;
	}
	
	@RequiredStringValidator(message = "Please enter a LevelId", trim = true)
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	
	public String getQuestionDescription() {
		return questionDescription;
	}
	
	@RequiredStringValidator(message = "Please enter a Question Description", trim = true)
	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}
	
	public String getOption1() {
		return option1;
	}
	
	@RequiredStringValidator(message = "Please enter a option1", trim = true)
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	
	public String getOption2() {
		return option2;
	}
	
	@RequiredStringValidator(message = "Please enter a option2", trim = true)
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	
	public String getOption3() {
		return option3;
	}
	
	@RequiredStringValidator(message = "Please enter a option3", trim = true)
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	
	public String getOption4() {
		return option4;
	}
	
	@RequiredStringValidator(message = "Please enter a option4", trim = true)
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	@RequiredStringValidator(message = "Please enter a answer", trim = true)
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public RetrieveDbInfo getRetrieveDbInfo() {
		return retrieveDbInfo;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
