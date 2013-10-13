package com.WebQ.action;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.WebQ.beans.User;

public class LoginActionTest extends TestCase {
    private static LoginAction testLoginAction;
    private static Map<String, Object> testSession;

    @Override
    protected void setUp() throws Exception {
	testLoginAction = new LoginAction();
	testSession = new HashMap<String, Object>();
    }

    @Override
    protected void tearDown() throws Exception {
	super.tearDown();
    }

    public static void main(String[] args) {
    }

    public void testValidateEmptyFields() throws Exception {

	testLoginAction.setUserId("");
	testLoginAction.setPassword("");
	testLoginAction.setSession(testSession);
	String output = testLoginAction.execute();
	assertEquals("input", output);

    }

    public void testTalidateAuthentication() throws Exception {

	testLoginAction.setUserId("teja");
	testLoginAction.setPassword("1131002");
	testSession.put("user", new User("testUserId", "testPassword"));
	testLoginAction.setSession(testSession);
	String output = testLoginAction.execute();
	assertEquals("success", output);
    }
}
