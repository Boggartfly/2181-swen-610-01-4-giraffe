package com.webcheckers.model;

public enum PieceColorEnum {


    RED("player"),
    WHITE("opponent");

    public  String playetType;

    /**
     *
     * @param playerType
     * @return
     */
    public static PieceColorEnum getOpponentColor(String playerType){

        if(playerType.equalsIgnoreCase("player")){
            return WHITE;
        }
        else {
            return RED;
        }
    }

    /**
     *
     * @param playerType
     */

    PieceColorEnum(String playerType){
        this.playetType = playerType;
    }








}
