package com.webcheckers.ui;


import com.webcheckers.appl.GameCentre;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class LandingController implements TemplateViewRoute {


    final static String LANDING_VIEW = "landing.ftl";
    private GameCentre gameCentre;

    public LandingController(GameCentre gameCentre) {
        this.gameCentre = gameCentre;
    }

    /**
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    public ModelAndView handle(Request request, Response response) {


        Map<String, Object> vm = new HashMap<>();
        vm.put("title", "Checkers Game");

        return new ModelAndView(vm, LANDING_VIEW);
    }
}
