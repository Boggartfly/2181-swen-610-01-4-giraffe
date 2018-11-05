package com.webcheckers.model;

public class Player {

    private String playerName;

    private String opponentName;

    private boolean isMyTurn;

    private PieceColorEnum playerColor;

    private PieceColorEnum opponentColor;

    private Message message;

    private Board board;

    private Move move;

    public Player(String playerName){
        this.playerName = playerName;
        this.playerColor = PieceColorEnum.RED;
        this.opponentColor = PieceColorEnum.WHITE;
        this.isMyTurn = true;
        this.message = new Message("Hello",MessageTypeEnum.info);
    }

    public Player(String playerName, Player firstPlayer){

        this.playerName = playerName;
        this.playerColor = firstPlayer.opponentColor;
        this.opponentName = firstPlayer.playerName;
        this.opponentColor = firstPlayer.playerColor;
        this.board = firstPlayer.board;
        this.isMyTurn = firstPlayer.isMyTurn?false:true;
        this.message = new Message("Hello",MessageTypeEnum.info);


    }

    public Player(String playerName, String opponentName, PieceColorEnum playerColor, PieceColorEnum opponentColor, boolean isMyTurn, Message message, Board board) {

        if(playerName == null){
            throw new IllegalArgumentException();
        }

        this.playerName = playerName;
        this.opponentName = opponentName;
        this.playerColor = playerColor;
        this.opponentColor = opponentColor;
        this.isMyTurn = isMyTurn;
        this.message = message;
        this.board = board;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public void setOpponentName(String opponentName) {
        this.opponentName = opponentName;
    }

    public PieceColorEnum getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(PieceColorEnum playerColor) {
        this.playerColor = playerColor;
    }

    public PieceColorEnum getOpponentColor() {
        return opponentColor;
    }

    public void setOpponentColor(PieceColorEnum opponentColor) {
        this.opponentColor = opponentColor;
    }

    public boolean isMyTurn() {
        return isMyTurn;
    }

    public void setMyTurn(boolean myTurn) {
        isMyTurn = myTurn;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }


    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }


    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", opponentName='" + opponentName + '\'' +
                ", isMyTurn=" + isMyTurn +
                ", playerColor=" + playerColor +
                ", opponentColor=" + opponentColor +
                ", message=" + message +
                ", board=" + board +
                ", move=" + move +
                '}';
    }

}
