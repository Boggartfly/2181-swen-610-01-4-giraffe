package com.webcheckers.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.ConsoleHandler;

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

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        String sessionId = request.session().id();
        String parameter;


        if (request.requestMethod() == "POST") {
            parameter = request.queryParams("username");
            if (!request.queryParams("username").isEmpty())
                System.out.println(parameter);

        }




        vm.put("title", "Welcome!");
        vm.put("userName", UserManagement.users.get(sessionId));
        vm.put("users", UserManagement.users.values());

        return new ModelAndView(vm , "lobby.ftl");
    }

}