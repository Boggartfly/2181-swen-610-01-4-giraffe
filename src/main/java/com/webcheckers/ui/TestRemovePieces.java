package com.webcheckers.ui;

import com.webcheckers.appl.GameCentre;
import com.webcheckers.model.Board;
import com.webcheckers.model.Game;
import com.webcheckers.model.Player;
import spark.Request;
import spark.Response;
import spark.Route;

public class TestRemovePieces implements Route {

    private GameCentre gameCentre;

    @Override
    public Object handle(Request request, Response response) throws Exception {

        String playerName = request.session().attribute("playerName");
        Player player = gameCentre.getPlayer(playerName);
        Game game = gameCentre.getPlayerGame(player);
        game.getBoard().removePieces();

        gameCentre.updateGame(player,game);

        response.redirect("/game");

        return "success";

    }

    public TestRemovePieces(GameCentre gameCentre) {
        this.gameCentre = gameCentre;
    }


}
