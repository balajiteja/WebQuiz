package com.WebQ.beans;

import java.util.HashMap;
import java.util.Map;

public class UsersCollection {

    private static Map<String, User> users;

    public void init() {
	setUsers(new HashMap<String, User>());
    }

    public void addUser(User userVal) {
	users.put(userVal.getUserId(), userVal);
    }

    public static Map<String, User> getUsers() {
	return users;
    }

    public static void setUsers(Map<String, User> users) {
	UsersCollection.users = users;
    }

    public boolean containsUser(String userId) {
	return users.containsKey(userId);

    }

}
