package com.webcheckers.ui;

import com.webcheckers.appl.GameCentre;
import com.webcheckers.model.Message;
import com.webcheckers.model.MessageTypeEnum;
import spark.*;

import java.util.HashMap;
import java.util.Map;



public class SignoutController implements TemplateViewRoute {

    private GameCentre gameCentre;

    public SignoutController(GameCentre gameCentre) {
        this.gameCentre = gameCentre;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {


        Map<String, Object> vm = new HashMap<>();

        String player = request.session().attribute("playerName");
        gameCentre.removeUser(player);
        gameCentre.removeAvailableUser(player);
        request.session().attribute("playerName", null);
        response.cookie("playerName", null);
        request.session().invalidate();

        vm.put("title","Checkers Game");
        return new ModelAndView(vm, LandingController.LANDING_VIEW);
    }


}
