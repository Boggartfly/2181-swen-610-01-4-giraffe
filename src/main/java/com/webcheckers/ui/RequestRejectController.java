package com.webcheckers.ui;

import com.webcheckers.appl.GameCentre;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

public class RequestRejectController implements Route {

    private GameCentre gameCentre;
    //public static Map<String, List<String>> userRequestorListMap;


    public RequestRejectController(GameCentre gameCentre) {
        this.gameCentre = gameCentre;
        // this.userRequestorListMap = new HashMap<>();

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
        vm.put("title", "Lobby Page");
        vm.put("currentUser", request.session().attribute("playerName"));


        String player;
        String requestor;
        //System.out.println("Requestor Name " + requestor);
        //System.out.println("Player Name " + player);

        player = request.session().attribute("playerName");
        requestor = request.queryParams("requestor");
        if (GameRequestController.userRequestorListMap.get(player) != null)
            GameRequestController.userRequestorListMap.get(player).remove(requestor);

        GameLobbyController.vm.put("requests", GameRequestController.userRequestorListMap);
        response.redirect("/gameLobby");

        return new ModelAndView(vm, "gamelobby.ftl");

    }
}
