package com.webcheckers.ui;

import com.webcheckers.model.Move;
import com.webcheckers.model.Position;
import spark.*;


public class ValidationController implements Route {


    public String handle(Request request, Response response) {




        Move move = JsonUtils.fromJson(request.body(),Move.class);

        if(move.getEnd().isValidPosition() && (move.getEnd().getRow()>move.getStart().getRow())){
            return "success";

        }
        else {
            return "error";
        }
    }
}
