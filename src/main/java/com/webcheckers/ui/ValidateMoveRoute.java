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

        System.out.println("VALIDATION MOVE ROUTE");

        Move move = JsonUtils.fromJson(request.body(), Move.class);
        String playerName = request.session().attribute("playerName");
        Player player = gameCentre.getPlayer(playerName);
        Game game = gameCentre.getPlayerGame(player);



      //  if(move.getEnd().isValidPosition() && (move.getEnd().getRow()>move.getStart().getRow())){

            if(playerName.equalsIgnoreCase(game.getPlayer().getPlayerName())){
                game.setMyTurn(1);
            }else {
                game.setMyTurn(0);
            }

            Message message =  new Message("Valid Move", MessageTypeEnum.info);
           Piece pieceToMove = game.getBoard().fetchPiece(move.getStart());
           game.getBoard().setPiece(move.getStart(),null);
           game.getBoard().setPiece(move.getEnd(),pieceToMove);
           gameCentre.updateGame(player,game);

            return JsonUtils.toJson(message);


       // }
      //  else {
       //     return "error";
       // }
    }
}
