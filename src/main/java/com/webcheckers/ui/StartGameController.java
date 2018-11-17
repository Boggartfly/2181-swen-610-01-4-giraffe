package com.webcheckers.ui;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.webcheckers.appl.GameCentre;
import com.webcheckers.model.Game;
import com.webcheckers.model.PieceColorEnum;
import com.webcheckers.model.Player;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class StartGameController implements TemplateViewRoute {


    private GameCentre gameCentre;
    public static Boolean unavailable = false;

    public StartGameController(GameCentre gameCentre) {
        this.gameCentre = gameCentre;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {

        Map<String, Object> vm = new HashMap<>();
        vm.put("title","Checkers Game");


        String playerName = request.session().attribute("playerName");
        String opponentName = request.body().split("&")[0].split("=")[1];

        System.out.println("FROM START CONTROLLER Player Name = "+playerName);

        System.out.println("FROM START CONTROLLER Opponent Name = "+opponentName);


        //if the user accepts a request after the requestor has joined a match, notify? and redirect.
        if (!gameCentre.getAvailableuserSet().contains(opponentName)){
            unavailable = true;
            GameRequestController.userRequestorListMap.get(playerName).remove(opponentName);
            response.redirect(WebServer.GAMELOBBY_URL);
            return null;
        }

       GameLobbyController.awaitingPlayer.add(opponentName);


        Player player = new Player(playerName.trim());
        player.setPlayerColor(PieceColorEnum.RED);
        player.setOpponentName(opponentName);
        player.setOpponentColor(PieceColorEnum.WHITE);
        player.setMyTurn(true);

        gameCentre.setUserPlayerMap(playerName,player);


        Player opponent = new Player(opponentName.trim());
        opponent.setOpponentName(playerName);
        opponent.setPlayerColor(PieceColorEnum.WHITE);
        opponent.setOpponentColor(PieceColorEnum.RED);
        opponent.setMyTurn(false);

        gameCentre.setUserPlayerMap(opponentName,opponent);


        gameCentre.removeAvailableUser(playerName);

        gameCentre.removeAvailableUser(opponentName);

        Game game = new Game(player,opponent);
        gameCentre.addGame(game);

        response.redirect("/game");


        return new ModelAndView(vm,"game.ftl");

    }
}
