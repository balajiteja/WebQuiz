package com.WebQ.beans;

public class Question {

    private int questionId;
    private int levelId;
    private String questionDescription;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;

    public int getQuestionId() {
	return questionId;
    }

    public Question(int questionId, int levelId, String questionDescription,
	    String option1, String option2, String option3, String option4,
	    String answer) {
	super();
	this.questionId = questionId;
	this.levelId = levelId;
	this.questionDescription = questionDescription;
	this.option1 = option1;
	this.option2 = option2;
	this.option3 = option3;
	this.option4 = option4;
	this.answer = answer;
    }

    public void setQuestionId(int questionId) {
	this.questionId = questionId;
    }

    public int getLevelId() {
	return levelId;
    }

    public void setLevelId(int levelId) {
	this.levelId = levelId;
    }

    public String getQuestionDescription() {
	return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
	this.questionDescription = questionDescription;
    }

    public String getOption1() {
	return option1;
    }

    public void setOption1(String option1) {
	this.option1 = option1;
    }

    public String getOption2() {
	return option2;
    }

    public void setOption2(String option2) {
	this.option2 = option2;
    }

    public String getOption3() {
	return option3;
    }

    public void setOption3(String option3) {
	this.option3 = option3;
    }

    public String getOption4() {
	return option4;
    }

    public void setOption4(String option4) {
	this.option4 = option4;
    }

    public String getAnswer() {
	return answer;
    }

    public void setAnswer(String answer) {
	this.answer = answer;
    }

}
