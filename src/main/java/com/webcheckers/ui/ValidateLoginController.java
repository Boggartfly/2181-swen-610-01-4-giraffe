package com.webcheckers.ui;

import com.webcheckers.appl.GameCentre;
import com.webcheckers.model.Game;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;


public class ValidateLoginController implements TemplateViewRoute {

    static final String MESSAGE_ATTR = "message";
    static final String MESSAGE_TYPE_ATTR = "messageType";
    static final String invalidUserName = "The user name entered is invalid!";
    static final String unavailableUserName = "The user name is already taken!";

    private GameCentre gameCentre;

    public ValidateLoginController(GameCentre gameCentre) {
        this.gameCentre = gameCentre;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title","Welcome to LOGIN PAGE");

        if (!request.session().isNew() && request.queryParams().contains("userName")) {
            String userName = request.queryParams("userName");
            if (gameCentre.isUserAvailable(userName)) { // valid user
                response.cookie("playerName", userName);
                gameCentre.addUser(userName);
                gameCentre.addAvailableUser(userName);
                request.session().attribute("playerName", userName);
                response.redirect("/gameLobby");
            }else {
                return error(vm, makeUnavailableUserMessage());

            }
        }else {
            return error(vm, makeBadArgMessage());
        }
        return new ModelAndView(vm,LoginController.LOGIN_VIEW);
    }

    protected ModelAndView error(final Map<String, Object> vm, final String message) {
        vm.put(MESSAGE_ATTR, message);
        return new ModelAndView(vm, "login.ftl");
    }

    /**
     * Make an error message when the userName is null.
     */
    static String makeBadArgMessage() {
        return invalidUserName;
    }

    static String makeUnavailableUserMessage() {
        return unavailableUserName;
    }

}

