package com.webcheckers.ui;

import com.webcheckers.appl.GameCentre;
import com.webcheckers.model.Message;
import com.webcheckers.model.MessageTypeEnum;
import spark.*;

import java.util.HashMap;
import java.util.Map;



public class LoginController implements TemplateViewRoute {

    public static final String LOGIN_VIEW = "login.ftl";
    public static boolean isUserValid;
    public static String userName =null;

    private GameCentre gameCentre;

    public LoginController(GameCentre gameCentre) {
        this.gameCentre = gameCentre;
    }

    @Override

    public ModelAndView handle(Request request, Response response) {


        Map<String, Object> vm = new HashMap<>();
        vm.put("title","LOGIN PAGE");

        return new ModelAndView(vm,LOGIN_VIEW);
    }


}
