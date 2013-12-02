package com.webq.beans;

public final class UserStatusConstants {
	private UserStatusConstants() {
		
	}
	// USER STATUS
	public static final String USER_NULL = "null";
	public static final String USER_LEVEL_ONE_STARTED = "level_one_started";
	public static final String USER_LEVEL_ONE_COMPLETED = "level_one_completed";
	
	// Level two
	public static final String USER_LEVEL_TWO_STARTED = "level_two_started";
	public static final String USER_LEVEL_TWO_COMPLETED = "level_two_completed";
	
	// level three
	public static final String USER_LEVEL_THREE_STARTED = "level_three_started";
	public static final String USER_LEVEL_THREE_COMPLETED = "level_three_completed";
	
	public static final String TRIED_TO_CHEAT = "tried_to_cheat";
	public static final int LEVEL_ONE_LIMIT = 20;
	public static final int LEVEL_TWO_LIMIT = 20;
	public static final int LEVEL_THREE_LIMIT = 25;
	
}
