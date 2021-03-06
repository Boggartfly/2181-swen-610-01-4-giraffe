package com.webcheckers.model;

/**
 * Author Ashish
 */
public class Game {

    private Player player;
    private Player opponent;
    private Board board;
    private int myTurn;
    private Player winner;


    public Game(Player player, Player opponent) {
        this.player = player;
        this.opponent = opponent;

        board = new Board();
        player.setBoard(board);
        opponent.setBoard(board);

        // 0- player, 1 - Opponent
        myTurn = 0;
    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }


    public boolean isOpponentAvailable() {

        return opponent != null;
    }

    public int getMyTurn() {
        return myTurn;
    }

    public void setMyTurn(int myTurn) {
        this.myTurn = myTurn;
    }

    public Board getBoard() {
        return board;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "Game{" +
                "player=" + player +
                ", opponent=" + opponent +
                ", board=" + board +
                ", myTurn=" + myTurn +
                '}';
    }
}
