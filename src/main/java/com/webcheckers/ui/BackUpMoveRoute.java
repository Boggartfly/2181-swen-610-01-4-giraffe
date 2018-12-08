package com.webcheckers.ui;

import com.webcheckers.appl.GameCentre;
import com.webcheckers.model.Message;
import com.webcheckers.model.MessageTypeEnum;
import com.webcheckers.model.Player;
import spark.Request;
import spark.Response;
import spark.Route;

public class BackUpMoveRoute implements Route {

    private GameCentre gameCentre;

    public BackUpMoveRoute(GameCentre gameCentre) {
        this.gameCentre = gameCentre;
    }

    /**
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object handle(Request request, Response response) {

        String playerName = request.session().attribute("playerName");
        Player player = gameCentre.getPlayer(playerName);

        gameCentre.removePlayerMoves(player);
        gameCentre.updateGame(player, gameCentre.getPlayerGame(player));


        Message message = new Message("Backed move", MessageTypeEnum.info);

        return JsonUtils.toJson(message);
    }
}
