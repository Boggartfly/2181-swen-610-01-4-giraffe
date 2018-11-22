package com.webcheckers.ui;

import com.webcheckers.appl.GameCentre;
import com.webcheckers.appl.GameConstants;
import com.webcheckers.model.Game;
import com.webcheckers.model.Message;
import com.webcheckers.model.MessageTypeEnum;
import com.webcheckers.model.Player;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.logging.Logger;

public class ResignGameRoute implements Route {

    private GameCentre gameCentre;

    public ResignGameRoute(GameCentre gameCentre) {
        this.gameCentre = gameCentre;
    }

    @Override
    public Object handle(Request request, Response response) {
        //TODO: to be defined

        System.out.println("resigning game");
        String player = request.session().attribute("playerName");
        Game game = gameCentre.getPlayerGame(gameCentre.getPlayer(player));



        String player2 = gameCentre.getPlayer(player).getPlayerName();

        String playerName = gameCentre.getPlayer(player).getPlayerName();
        String opponentName = gameCentre.getPlayer(player).getOpponentName();


        GameLobbyController.awaitingPlayer.remove(playerName);
        GameLobbyController.awaitingPlayer.remove(opponentName);

        gameCentre.addAvailableUser(playerName);
        gameCentre.addAvailableUser(opponentName);

        if (GameRequestController.userRequestorListMap.get(player) != null)
            if (GameRequestController.userRequestorListMap.get(player).contains(opponentName))
                GameRequestController.userRequestorListMap.get(player).remove(opponentName);

        game.setWinner(gameCentre.getPlayer(opponentName));

        response.redirect(WebServer.GAMELOBBY_URL);
        return "success";
    }
}
