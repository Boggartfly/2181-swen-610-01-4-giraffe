package com.webcheckers.ui;

import com.webcheckers.appl.GameCentre;
import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameRequestController implements Route {

    private GameCentre gameCentre;
    public  static Map<String, List<String>> userRequestorListMap;


    public GameRequestController(GameCentre gameCentre) {
        this.gameCentre = gameCentre;
        this.userRequestorListMap = new HashMap<>();

    }

 @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title","Lobby Page");
        vm.put("currentUser",request.session().attribute("playerName"));

        String requestor = request.session().attribute("playerName");
        String  player= request.body().split("=")[1];

        System.out.println("Requestor Name " + requestor);
        System.out.println("Player Name " + player);

        if(userRequestorListMap.get(player) ==null) {
            userRequestorListMap.put(player, new ArrayList<>());
            userRequestorListMap.get(player).add(requestor);
            GameLobbyController.vm.put("requests",userRequestorListMap.get(player));
        }else {
            userRequestorListMap.get(player).add(requestor);
            GameLobbyController.vm.put("requests",userRequestorListMap.get(player));
        }

        response.redirect("/gameLobby");

        return new ModelAndView(vm,"gamelobby.ftl");

        }
}
