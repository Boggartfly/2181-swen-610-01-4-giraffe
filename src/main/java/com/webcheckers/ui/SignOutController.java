package com.webcheckers.ui;

import com.webcheckers.model.UserManagement;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class SignOutController implements TemplateViewRoute {

    private UserManagement users;
    static final String MESSAGE_ATTR = "message";
    static final String MESSAGE_TYPE_ATTR = "messageType";

    SignOutController() {
    }


    @Override
    public ModelAndView handle(Request request, Response response) {

        Map<String, Object> vm = new HashMap<>();
        final Session httpSession = request.session();

        //if (httpSession)
        UserManagement.removeUser(httpSession.id());
        httpSession.invalidate();

        vm.put("title", "Welcome!");
        return new ModelAndView(vm, "home.ftl");
    }

    private ModelAndView error(final Map<String, Object> vm, final String message) {
        vm.put("title", "Welcome!");
        vm.put(MESSAGE_ATTR, message);
        //vm.put(MESSAGE_TYPE_ATTR, ERROR_TYPE);
        return new ModelAndView(vm, "home.ftl");
    }
}
