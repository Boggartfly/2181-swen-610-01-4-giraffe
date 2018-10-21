package com.webcheckers.ui;

import com.webcheckers.model.UserManagement;
import spark.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LoginController implements TemplateViewRoute {

    static final String MESSAGE_ATTR = "message";
    static final String MESSAGE_TYPE_ATTR = "messageType";

    LoginController() {
    }

    /**
     * Make an error message when the userName is null.
     */
    static String makeBadArgMessage() {
        return String.format("The user name entered is invalid!");
    }

    static String makeUnavailableUserMessage() {
        return String.format("The user name is already taken!");
    }

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        final Session httpSession = request.session();

        //request.
        if (request.requestMethod() == "GET"){
            vm.put("title", "Welcome!");
            return new ModelAndView(vm, "login.ftl");
        }

        String playerName = request.queryParams("username");

        //httpSession.attribute("playerName", playerName);
        /**
         * Verify UserName is valid and available. If not, dont log in and stay at home
         */
        if (UserManagement.isValidUser(playerName)) {
            if (!UserManagement.isUserNameAvailable(playerName))
                return error(vm, makeUnavailableUserMessage());
            else
                UserManagement.addUser(httpSession.id(), playerName);
        } else
            return error(vm, makeBadArgMessage());

        /**
         * instead of populating the vm here, redirect to game
         */
        response.redirect("/game");

        //this will never get executed
        vm.put("title", "Welcome!");
        return new ModelAndView(vm, "game.ftl");
    }


    private ModelAndView error(final Map<String, Object> vm, final String message) {
        vm.put("title", "Welcome!");
        vm.put(MESSAGE_ATTR, message);
        return new ModelAndView(vm, "login.ftl");
    }
}
