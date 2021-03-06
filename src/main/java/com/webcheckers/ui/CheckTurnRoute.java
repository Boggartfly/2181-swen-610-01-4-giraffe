package com.webcheckers.ui;

import com.webcheckers.appl.GameCentre;
import com.webcheckers.model.Game;
import spark.Request;
import spark.Response;
import spark.Route;

public class CheckTurnRoute implements Route {

    private GameCentre gameCenter;

    public CheckTurnRoute(GameCentre gameCenter) {
        this.gameCenter = gameCenter;

    }

    /**
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public Object handle(Request request, Response response) throws Exception {

        String playerName = request.session().attribute("playerName").toString().trim();

        Game game = gameCenter.getPlayerGame(gameCenter.getPlayer(playerName));

        if (game.getMyTurn() == 0 && game.getPlayer().getPlayerName().equalsIgnoreCase(playerName)) {
            return true;
        } else return game.getMyTurn() == 1 && game.getOpponent().getPlayerName().equalsIgnoreCase(playerName);
    }
}
