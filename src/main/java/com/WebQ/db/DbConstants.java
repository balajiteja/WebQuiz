package com.WebQ.db;

public final class DbConstants {
    // DB configuration constants
    public static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    public static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/webQuizDb";
    public static final String DB_USER_NAME = "teja";
    public static final String DB_PASSWORD = "123456";

    // Table Name Constants
    public static final String USER_TABLE = "user";
    public static final String QUESTION_TABLE = "question";
    public static final String LEVEL_SCORE_TABLE = "levelscore";

    // USER TABLE FIELDS
    public static final String USER_NO = "userNo";
    public static final String USER_ID = "userId";
    public static final String PASSWORD = "password";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL_ID = "emailId";

    // QUESTION TABLE FIELDS
    public static final String QUESTION_ID = "questionId";
    public static final String LEVEL_ID = "levelId";
    public static final String QUESTION_DESCRIPTION = "questionDescription";
    public static final String OPTION1 = "option1";
    public static final String OPTION2 = "option2";
    public static final String OPTION3 = "option3";
    public static final String OPTION4 = "option4";
    public static final String ANSWER = "answer";

    // LEVEL_SCORE TABLE FIELDS
    // USER_ID already mentioned above
    // LEVEL_ID already mentioned above
    public static final String SCORE = "score";

    public DbConstants() {
	super();
	// TODO Auto-generated constructor stub
    }

}
