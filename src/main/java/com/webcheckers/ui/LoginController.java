package com.webcheckers.ui;

import com.webcheckers.appl.GameCenter;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class LoginController implements TemplateViewRoute {

    @Override
    public ModelAndView handle(Request request, Response response) {

//        if (GameCenter.userSet.contains(request.body()))

        Map<String, Object> vm = new HashMap<>();
        vm.put("title", "Welcome!");
        return new ModelAndView(vm , "login.ftl");


    }
}
