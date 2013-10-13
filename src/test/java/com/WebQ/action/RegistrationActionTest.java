package com.WebQ.action;

import junit.framework.TestCase;

import com.WebQ.beans.User;
import com.WebQ.db.RetrieveDbInfo;

public class RegistrationActionTest extends TestCase {
    private static RegistrationAction registrationAction;
    private static RetrieveDbInfo retrieveDbInfo;

    @Override
    protected void setUp() throws Exception {
	retrieveDbInfo = new RetrieveDbInfo();
	registrationAction = new RegistrationAction(retrieveDbInfo);
	super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
	super.tearDown();
    }

    public static void main(String[] args) {
    }

    public void testEmptyFields() {
	retrieveDbInfo = new RetrieveDbInfo();
	registrationAction = new RegistrationAction(retrieveDbInfo);
	registrationAction.setUserId("");
	registrationAction.setPassword("");
	registrationAction.setPassword2("");
	registrationAction.setFirstName("");
	registrationAction.setLastName("");
	registrationAction.setEmailId("");
	retrieveDbInfo.init();

	String output = registrationAction.execute();

	assertEquals("input", output);
    }

    public void testRedundantEntry() {
	retrieveDbInfo = new RetrieveDbInfo();
	registrationAction = new RegistrationAction(retrieveDbInfo);
	registrationAction.setUserId("");
	registrationAction.setPassword("");
	registrationAction.setPassword2("");
	registrationAction.setFirstName("");
	registrationAction.setLastName("");
	registrationAction.setEmailId("");
	retrieveDbInfo.init();
	retrieveDbInfo.addUser(new User("testUserId23", "testPassword",
		"testFirstName2", "testLastName2", "testEmailId2"));

	String output = registrationAction.execute();

	assertEquals("input", output);
    }

    public void testValidatePassword() {

	retrieveDbInfo = new RetrieveDbInfo();
	registrationAction = new RegistrationAction(retrieveDbInfo);
	registrationAction.setUserId("testUserId");
	registrationAction.setPassword("testPassword");
	registrationAction.setPassword2("wrongPassword");
	registrationAction.setFirstName("testFirstName");
	registrationAction.setLastName("testLastName");
	registrationAction.setEmailId("testEmailId");
	retrieveDbInfo.init();
	retrieveDbInfo.addUser(new User("testUserId21", "testPassword1",
		"testFirstName1", "testLastName1", "testEmailId1"));

	String output = registrationAction.execute();

	assertEquals("input", output);

    }

    public void testValidEntry() {
	retrieveDbInfo = new RetrieveDbInfo();
	registrationAction = new RegistrationAction(retrieveDbInfo);
	registrationAction.setUserId("testUserId123");
	registrationAction.setPassword("testPassword123");
	registrationAction.setPassword2("testPassword123");
	registrationAction.setFirstName("testFirstName123");
	registrationAction.setLastName("testLastName123");
	registrationAction.setEmailId("testEmailId123");
	retrieveDbInfo.init();

	String output = registrationAction.execute();

	assertEquals("success", output);

    }
}
