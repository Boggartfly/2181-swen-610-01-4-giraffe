package com.webcheckers.ui;

import com.webcheckers.appl.GameCentre;
import com.webcheckers.model.*;
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

        if(move.isValidJumpMove(gameCenter.getPlayerType(player))) {

            Position position = new Position((move.getEnd().getRow() + move.getStart().getRow())/2,(move.getEnd().getCell()+move.getStart().getCell())/2);
           game.getBoard().setPiece(position,null);
        }
        if(move.isKing(gameCenter.getPlayerType(player))){
            pieceToMove.setType(PieceTypeEnum.KING);
            game.getBoard().setPiece(move.getEnd(),pieceToMove);

        }

        gameCenter.updateGame(player,game);

       // response.redirect("/game");
        return "success";
    }
}
