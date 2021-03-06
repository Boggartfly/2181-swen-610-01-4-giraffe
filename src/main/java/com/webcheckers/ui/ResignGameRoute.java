package com.webcheckers.ui;

import com.webcheckers.appl.GameCentre;
import com.webcheckers.model.Game;
import spark.Request;
import spark.Response;
import spark.Route;

public class ResignGameRoute implements Route {

    private GameCentre gameCentre;

    public ResignGameRoute(GameCentre gameCentre) {
        this.gameCentre = gameCentre;
    }

    /**
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object handle(Request request, Response response) {


        System.out.println("resigning game");
        String player = request.session().attribute("playerName");
        Game game = gameCentre.getPlayerGame(gameCentre.getPlayer(player));


        String player2 = gameCentre.getPlayer(player).getPlayerName();

        String playerName = gameCentre.getPlayer(player).getPlayerName();
        String opponentName = gameCentre.getPlayer(player).getOpponentName();


        if (GameRequestController.userRequestorListMap.get(player) != null)
            GameRequestController.userRequestorListMap.get(player).remove(opponentName);

        game.setWinner(gameCentre.getPlayer(opponentName));

        response.redirect(WebServer.GAMELOBBY_URL);
        return "success";
    }
}
