package com.webcheckers.ui;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import com.webcheckers.model.MatchRequest;
import com.webcheckers.model.UserManagement;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

/**
 * The Web Controller for the Home page.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */
public class HandleRequestController implements TemplateViewRoute {

    String requestedBy = "";
    String currentUser = "";

    @Override
    public ModelAndView handle(Request request, Response response) {

        Map<String, Object> vm = new HashMap<>();
        String sessionId = request.session().id();
        currentUser = UserManagement.users.get(sessionId);
        String requestResponse = request.queryParams("handleRequest").trim();
        //if (request.requestMethod() == "POST") {
            if (requestResponse.equals("Reject")){
                String a = request.queryParams("requestor");
                MatchRequest.rejectRequest(a, currentUser);
                vm.put("title", "Welcome!");
                vm.put("userName", UserManagement.users.get(sessionId));
                vm.put("users", UserManagement.users.values());
                vm.put("requests", MatchRequest.getKeyFromValue(currentUser));
                response.redirect("/lobby");
            }

            else if(request.contextPath() == "/accept"){

            }


     //   }

        vm.put("title", "Welcome!");
        vm.put("userName", UserManagement.users.get(sessionId));
        vm.put("users", UserManagement.users.values());
        //vm.put("requestedUser", MatchRequest.userStatus.values());

        return new ModelAndView(vm, "lobby.ftl");
    }


}