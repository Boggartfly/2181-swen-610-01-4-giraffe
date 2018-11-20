package com.webcheckers.ui;


import com.webcheckers.appl.GameCentre;
import com.webcheckers.model.*;
import spark.Request;
import spark.Response;
import spark.Route;


public class ValidateMoveRoute implements Route {

    private GameCentre gameCentre;

    public ValidateMoveRoute(GameCentre gameCentre) {
        this.gameCentre = gameCentre;
    }

    public Object handle(Request request, Response response) {

        Message message;

        System.out.println("VALIDATION MOVE ROUTE");

        Move move = JsonUtils.fromJson(request.body(), Move.class);
        String playerName = request.session().attribute("playerName");
        Player player = gameCentre.getPlayer(playerName);
        Game game = gameCentre.getPlayerGame(player);


        if (move.isValidMove(gameCentre.getPlayerType(player))) {
            message = new Message("This is a valid move", MessageTypeEnum.info);
            gameCentre.addPlayerMove(player, move);
        } else if (move.isValidJumpMove(gameCentre.getPlayerType(player))) {
            Position position = new Position((move.getEnd().getRow() + move.getStart().getRow()) / 2, (move.getEnd().getCell() + move.getStart().getCell()) / 2);
            PieceColorEnum pieceColorEnum;

            switch (gameCentre.getPlayerType(player)) {
                case "player":
                    //    position = new Position(Math.abs(move.getEnd().getRow() - move.getStart().getRow() +2),
                    //            Math.abs(move.getEnd().getCell()-move.getStart().getCell()) +1);
                    pieceColorEnum = PieceColorEnum.WHITE;
                    break;
                case "opponent":
                    //     position = new Position(Math.abs(move.getEnd().getRow() - move.getStart().getRow()+2),
                    //             Math.abs(move.getEnd().getCell()-move.getStart().getCell() +1));
                    pieceColorEnum = PieceColorEnum.RED;
                    break;
                default:
                    //         position=null;
                    pieceColorEnum = null;

            }

            Piece piece = game.getBoard().fetchPiece(position);

            if (piece != null) {
                if (piece.getColor().equals(pieceColorEnum)) {
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
    }
}
