package com.webcheckers.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MatchRequest {
    public static String parameter;
    //UserID, requested?, inMatch?

    public static HashMap<String, String> userStatus = new HashMap<>();

    public static void requestMatch(String requestedBy, String requestedUserName) {
        //requestees.add(requestedUserName);
        userStatus.put(requestedBy, requestedUserName);
    }

    public static List<String> getKeyFromValue(String value) {
        List<String> requestorList = new ArrayList<>();

        for (String o : userStatus.keySet()) {
            if (userStatus.get(o).equals(value)) {
                requestorList.add(o);
            }
        }
        return requestorList;
    }

}
