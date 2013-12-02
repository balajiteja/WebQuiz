package com.webq.action;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.webq.beans.User;
import com.webq.db.RetrieveDbInfo;

public class TestActionTest extends TestCase {
	private static TestAction ta;
	private static RetrieveDbInfo rdi;
	private static Map<String, Object> testSession;
	
	protected void setUp() throws Exception {
		rdi = new RetrieveDbInfo();
		ta = new TestAction(rdi);
		testSession = new HashMap<String, Object>();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testLevel1() throws Exception {
		testSession.put("user", new User("testUserId", "testPassword"));
		ta.setSession(testSession);
		String output = ta.execute();
		assertEquals("start1", output);
	}
	
}
