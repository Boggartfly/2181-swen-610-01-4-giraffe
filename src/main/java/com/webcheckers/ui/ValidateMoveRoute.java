package com.webcheckers.ui;


import com.webcheckers.appl.GameCentre;
import com.webcheckers.model.*;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;


public class ValidateMoveRoute implements Route {

    private GameCentre gameCentre;

    public ValidateMoveRoute(GameCentre gameCentre) {
        this.gameCentre = gameCentre;
    }

    /**
     *
     * @param request
     * @param response
     * @return
     */
    public Object handle(Request request, Response response) {

        Message message;

        System.out.println("VALIDATION MOVE ROUTE");

        Move move = JsonUtils.fromJson(request.body(), Move.class);
        String playerName = request.session().attribute("playerName");
        Player player = gameCentre.getPlayer(playerName);
        String playerType = gameCentre.getPlayerType(player);
        Game game = gameCentre.getPlayerGame(player);
        Boolean isavailableJumpMove = false;
        Piece startPositionPiece = game.getBoard().fetchPiece(move.getStart());


        try {



            List<Move> availableJumpMoves = game.getBoard().generateAvailableJumpMoves(player.getPlayerColor(), gameCentre.getPlayerType(player));

            if (availableJumpMoves.size() != 0 && !checkMoveContained(availableJumpMoves, move)) {
                isavailableJumpMove = true;
                message = new Message("A Jump needs to be taken", MessageTypeEnum.error);
            } else if (!isavailableJumpMove && move.isValidMove(playerType, startPositionPiece.getType()) && gameCentre.getPlayerMoves(player) == null) {
                message = new Message("This is a valid move", MessageTypeEnum.info);
                gameCentre.addPlayerMove(player, move);
            } else if (!isavailableJumpMove && move.isValidJumpMove(playerType,startPositionPiece.getType())) {
                Position position = new Position((move.getEnd().getRow() + move.getStart().getRow()) / 2, (move.getEnd().getCell() + move.getStart().getCell()) / 2);

                Piece piece = game.getBoard().fetchPiece(position);


                if (piece != null) {
                    if (piece.getColor().equals(PieceColorEnum.getOpponentColor(playerType)) && gameCentre.getPlayerMove(player) == null) {
                        message = new Message("This is a valid Jump Move", MessageTypeEnum.info);
                        gameCentre.addPlayerMove(player, move);
                    } else {
                        message = new Message("This is not a valid Jump Move", MessageTypeEnum.error);
                    }
                } else
                    message = new Message("This is not a valid Jump Move", MessageTypeEnum.error);

            } else {
                message = new Message("Sorry this is not a valid move because TODO", MessageTypeEnum.error);
            }

            return JsonUtils.toJson(message);
        } catch (Exception e) {
            message = new Message("Sorry this is not a valid move because Exception", MessageTypeEnum.error);
            e.printStackTrace();
            return JsonUtils.toJson(message);

        }
    }

    /**
     *
     * @param availableJumpMoves
     * @param move
     * @return
     */

    public boolean checkMoveContained(List<Move> availableJumpMoves, Move move){

        Boolean result= false;

        for(Move mov : availableJumpMoves){
            if(mov.getStart().equals(move.getStart()) && mov.getEnd().equals(move.getEnd())){
                result = true;
            }
        }
        return result;
    }


}
