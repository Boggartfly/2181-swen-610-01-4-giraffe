package com.webcheckers.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.ConsoleHandler;

import com.webcheckers.model.MatchRequest;
import com.webcheckers.model.UserManagement;
import org.eclipse.jetty.server.Authentication;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

/**
 * The Web Controller for the Home page.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */
public class LobbyController implements TemplateViewRoute {

    String requestedBy = "";
    String currentUser = "";

    @Override
    public ModelAndView handle(Request request, Response response) {

        Map<String, Object> vm = new HashMap<>();
        String sessionId = request.session().id();
        requestedBy = UserManagement.users.get(sessionId);
        currentUser = UserManagement.users.get(sessionId);

        if (request.requestMethod() == "POST") {
            MatchRequest.requestMatch(requestedBy, request.queryParams("username"));
            response.redirect("/lobby");
        }

        else if (request.requestMethod() == "GET") {
            if (!MatchRequest.userStatus.isEmpty())
                if (MatchRequest.userStatus.values().contains(currentUser)) {
                    System.out.println(MatchRequest.getKeyFromValue(currentUser));
                    vm.put("requests", MatchRequest.getKeyFromValue(currentUser));
                    //vm.put("request", "You have a match request!\n Would you like yo play against:  " + MatchRequest.getKeyFromValue(currentUser));
                }
        }

        vm.put("title", "Welcome!");
        vm.put("userName", UserManagement.users.get(sessionId));
        vm.put("users", UserManagement.users.values());
        //vm.put("requestedUser", MatchRequest.userStatus.values());

        return new ModelAndView(vm, "lobby.ftl");
    }


}