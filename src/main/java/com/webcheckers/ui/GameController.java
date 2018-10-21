package com.webcheckers.ui;


import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.*;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class GameController implements TemplateViewRoute {

    @Override
    public ModelAndView handle(Request request, Response response) {


        GameCenter.opponentColor = PieceColorEnum.WHITE;
        GameCenter.playerColor = PieceColorEnum.RED;
        Board board = new Board();

        String playerName = UserManagement.users.get(request.session().id());

        //String playerName2 = request.session().attribute("playerName");

        if (playerName == null)
            response.redirect("/");
        Player player = new Player(playerName, "Comp", GameCenter.playerColor, GameCenter.opponentColor, true, new Message("Finally Our Game page is Up", MessageTypeEnum.info), board);


        Map<String, Object> vm = new HashMap<>();

        vm.put("title", "Welcome to Game");
        vm.put("currentPlayer", player);
        vm.put("playerName", player.getPlayerName());
        vm.put("playerColor", player.getPlayerColor());
        vm.put("opponentName", player.getOpponentName());
        vm.put("opponentColor", player.getOpponentColor());
        vm.put("isMyTurn", player.isMyTurn());
        vm.put("message", player.getMessage());
        vm.put("board", player.getBoard());
        return new ModelAndView(vm, "game.ftl");
    }
}
