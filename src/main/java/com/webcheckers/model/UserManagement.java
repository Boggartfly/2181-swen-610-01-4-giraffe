package com.webcheckers.model;

import java.util.HashMap;
import java.util.HashSet;

public class UserManagement {

    public static HashMap<String, String> users = new HashMap<>();


    public static boolean isValidUser (String playerName){
        if (playerName == null || playerName == "")
            return false;
        return true;
    }

    public static boolean isUserNameAvailable (String playerName){
        if (users.values().contains(playerName))
            return false;
        return true;
    }

    public static void addUser(String session, String playerName){
        users.put(session, playerName);
    }

    public static void removeUser(String session){
        users.remove(session);
    }
}
