package com.webcheckers.ui;

import com.webcheckers.appl.GameCentre;
import com.webcheckers.model.Game;
import com.webcheckers.model.Move;
import com.webcheckers.model.Piece;
import com.webcheckers.model.Player;
import spark.Request;
import spark.Response;
import spark.Route;

public class SubmitTurnRoute implements Route {
    private GameCentre gameCenter;

    public SubmitTurnRoute(GameCentre gameCenter) {
        this.gameCenter = gameCenter;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {


        String playerName = request.session().attribute("playerName");
        Player player = gameCenter.getPlayer(playerName);
        Move move = gameCenter.getPlayerMove(player);
        gameCenter.removePlayerMove(player,move);
        Game game = gameCenter.getPlayerGame(player);

        if(playerName.equalsIgnoreCase(game.getPlayer().getPlayerName())){
            game.setMyTurn(1);
        }else {
            game.setMyTurn(0);
        }


        Piece pieceToMove = game.getBoard().fetchPiece(move.getStart());
        game.getBoard().setPiece(move.getStart(),null);
        game.getBoard().setPiece(move.getEnd(),pieceToMove);
        gameCenter.updateGame(player,game);

       // response.redirect("/game");
        return "success";
    }
}
