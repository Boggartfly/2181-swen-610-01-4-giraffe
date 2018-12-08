package com.webcheckers.ui;

import com.webcheckers.appl.GameCentre;
import com.webcheckers.model.Game;
import com.webcheckers.model.Player;
import spark.Request;
import spark.Response;
import spark.Route;

public class TestMakeKing implements Route {

    private GameCentre gameCentre;

    /**
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public Object handle(Request request, Response response) throws Exception {

        String playerName = request.session().attribute("playerName");
        Player player = gameCentre.getPlayer(playerName);
        Game game = gameCentre.getPlayerGame(player);
        game.getBoard().removePiecesForKing();

        gameCentre.updateGame(player,game);

        response.redirect("/game");

        return "success";

    }

    public TestMakeKing(GameCentre gameCentre) {
        this.gameCentre = gameCentre;
    }

}
