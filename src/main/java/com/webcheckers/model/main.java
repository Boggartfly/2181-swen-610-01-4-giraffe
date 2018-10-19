package com.webcheckers.model;

public class main {


    public static void main(String[] args) {

        Board board = new Board();


        Player player = new Player("Ashish","Comp", PieceColorEnum.RED,PieceColorEnum.WHITE,true,new Message("Hello", MessageTypeEnum.info),board);

        Row row = player.getBoard().iterator().next();


        row = player.getBoard().iterator().next();

    }


}
