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

        gameCentre.addPlayerMove(player,move);


        Message message =  new Message("Valid Move", MessageTypeEnum.info);



        return JsonUtils.toJson(message);



    }
}
