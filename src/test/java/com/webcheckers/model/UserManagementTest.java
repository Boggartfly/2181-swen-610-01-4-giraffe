package com.webcheckers.model;

import org.eclipse.jetty.server.Authentication;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserManagementTest {

    private static final String emptyString = "";
    private static final String nullString = null;
    private static final String validName = "TestName";
    private static final String userSession = "session1234";

    @Test
    public void isValidUserEmpty() {

        assertFalse("User Name is invalid.", UserManagement.isValidUser(emptyString));
        assertFalse("User Name is invalid.", UserManagement.isValidUser(nullString));
        assertTrue("User Name is valid", UserManagement.isValidUser(validName));


    }

    @Test
    public void isUserNameAvailable() {

        //assert the name is not already taken
        UserManagement.users.put("sessionID", "NoTestName");
        assertTrue("The user name is available", UserManagement.isUserNameAvailable(validName));

        //assert name is already taken
        UserManagement.users.put("sessionID2", validName);
        assertFalse("The user name is available", UserManagement.isUserNameAvailable(validName));
    }

    @Test
    public void addUser() {
        //if there are no users, hashmap should be empyu
        assertTrue("User List is empty", UserManagement.users.isEmpty());


        //verify user is added
        UserManagement.addUser(userSession, validName);
        assertEquals("The user is added correctly", UserManagement.users.containsValue(validName), true);
    }

    @Test
    public void removeUser() {
        UserManagement.users.put(userSession, "NoTestName");

        //remove user and verify list is empty
        UserManagement.removeUser(userSession);
        assertTrue("User is removed. List is empty", UserManagement.users.isEmpty());

    }
}