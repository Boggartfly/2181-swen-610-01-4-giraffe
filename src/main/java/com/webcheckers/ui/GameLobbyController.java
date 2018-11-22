package com.webcheckers.ui;

import com.webcheckers.appl.GameCentre;
import com.webcheckers.model.Player;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameLobbyController implements TemplateViewRoute {

    private GameCentre gameCentre;
    public static String GAMELOBBY_VIEW = "gamelobby.ftl";
    public static Map<String, Object> vm = new HashMap<>();
    public static Set<String> awaitingPlayer = new HashSet<>();

    public GameLobbyController(GameCentre gameCentre) {
        this.gameCentre = gameCentre;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {

        String playerName = request.session().attribute("playerName");
        vm.put("title","Lobby Page");
        vm.put("users", gameCentre.getAvailableuserSet());
        vm.put("currentUser", playerName);
        vm.remove("errorMessage");

        if (GameController.winner){
            vm.put("gameWon", true);
            GameController.winner = false;
        }
        else
            vm.remove("gameWon");

        if(StartGameController.unavailable){
            GameLobbyController.vm.put("errorMessage", "The request is no longer available");
            StartGameController.unavailable = false;
        }

        return new ModelAndView(vm, GAMELOBBY_VIEW);
    }
}
