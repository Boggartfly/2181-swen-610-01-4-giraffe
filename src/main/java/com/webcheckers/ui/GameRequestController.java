package com.webcheckers.ui;

import com.webcheckers.appl.GameCentre;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameRequestController implements Route {

    public static Map<String, List<String>> userRequestorListMap;
    private GameCentre gameCentre;


    public GameRequestController(GameCentre gameCentre) {
        this.gameCentre = gameCentre;
        userRequestorListMap = new HashMap<>();

    }

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", "Lobby Page");
        vm.put("currentUser", request.session().attribute("playerName"));


        String player;
        String requestor;
        //System.out.println("Requestor Name " + requestor);
        //System.out.println("Player Name " + player);


        //guess the if/else could be deleted, we never call this controller with a get
        if (request.requestMethod() == WebServer.GET_METHOD) {


        } else if (request.requestMethod() == WebServer.POST_METHOD) {
            requestor = request.session().attribute("playerName");
            player = request.body().split("=")[1];
            if (userRequestorListMap.get(player) == null) {
                userRequestorListMap.put(player, new ArrayList<>());
                userRequestorListMap.get(player).add(requestor);
                GameLobbyController.vm.put("requests", userRequestorListMap);
            } else {
                userRequestorListMap.get(player).add(requestor);
                vm.put("requests", userRequestorListMap.get(player));
                GameLobbyController.vm.put("requests", userRequestorListMap);
            }

        }

        response.redirect("/gameLobby");

        return new ModelAndView(vm, "gamelobby.ftl");

    }
}
