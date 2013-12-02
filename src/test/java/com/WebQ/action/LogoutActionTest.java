package com.webq.action;

import java.util.HashMap;

import junit.framework.TestCase;

import com.webq.beans.User;

public class LogoutActionTest extends TestCase {
	private static LogoutAction testLogoutAction;
	private HashMap<String, Object> testSession;
	
	@Override
	protected void setUp() throws Exception {
		testLogoutAction = new LogoutAction();
		testSession = new HashMap<String, Object>();
		super.setUp();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testRemoveUserSession() {
		testSession.put("user", new User("", ""));
		testLogoutAction.setSession(testSession);
		testLogoutAction.execute();
		assertNull(testSession.get("user"));
	}
}
