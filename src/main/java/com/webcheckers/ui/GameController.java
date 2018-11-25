package com.webcheckers.ui;

import com.webcheckers.appl.GameCentre;
import com.webcheckers.model.Game;
import com.webcheckers.model.Player;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class GameController implements TemplateViewRoute {

    final static String GAME_VIEW = "game.ftl";
    private GameCentre gameCentre;
    private Player player;
    private Player opponent;
    static Boolean winner = false;
    public GameController(GameCentre gameCentre) {
        this.gameCentre = gameCentre;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {

        String playerName = request.session().attribute("playerName");
        System.out.println("PLAYER NAME ON GAME CONTROLLER " + playerName);


        System.out.println("#### PLAYER ++++ " + gameCentre.getPlayer(playerName).toString());
        Player player = gameCentre.getPlayer(playerName.trim());

        Game game = gameCentre.getPlayerGame(player);

        System.out.println("#### GAME ++++" + game.toString());


        Map<String, Object> vm = new HashMap<>();



        if(game.getPlayer().getPlayerName().equalsIgnoreCase(playerName)){
            if(game.getWinner() == gameCentre.getPlayer(playerName)){
                winner = true;

                gameCentre.removeGame(game);
                response.redirect("/gameLobby");

            }
            vm.put("title", "Welcome to Game");
            vm.put("currentPlayer", game.getPlayer());
            vm.put("playerName", game.getPlayer().getPlayerName());
            vm.put("playerColor", game.getPlayer().getPlayerColor());
            vm.put("opponentName", game.getPlayer().getOpponentName());
            vm.put("opponentColor", game.getPlayer().getOpponentColor());
            vm.put("isMyTurn", game.getMyTurn()==0 ? true:false);
            vm.put("message",game.getPlayer().getMessage());
            vm.put("board",game.getBoard());

            return new ModelAndView(vm , "game.ftl");
        } else {
            if(game.getWinner() == gameCentre.getPlayer(playerName)){
                winner = true;
                gameCentre.removeGame(game);
                response.redirect("/gameLobby");
            }
            vm.put("title", "Welcome to Game");
            vm.put("currentPlayer", game.getOpponent());
            vm.put("playerName", game.getOpponent().getPlayerName());
            vm.put("playerColor", game.getOpponent().getPlayerColor());
            vm.put("opponentName", game.getOpponent().getOpponentName());
            vm.put("opponentColor", game.getOpponent().getOpponentColor());
            vm.put("isMyTurn", game.getMyTurn() == 1 ? true : false);
            vm.put("message", game.getPlayer().getMessage());
            vm.put("board", game.getBoard());
            return new ModelAndView(vm, "game.ftl");

        }
    }

}
