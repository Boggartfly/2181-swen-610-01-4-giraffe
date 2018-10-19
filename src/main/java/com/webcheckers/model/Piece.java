package com.webcheckers.model;

public class Piece {

    PieceTypeEnum type;

    PieceColorEnum color;

    public Piece(PieceTypeEnum pieceType, PieceColorEnum pieceColor) {
        this.type = pieceType;
        this.color = pieceColor;
    }

    public PieceTypeEnum getType() {
        return type;
    }

    public void setType(PieceTypeEnum type) {
        this.type = type;
    }

    public PieceColorEnum getColor() {
        return color;
    }

    public void setColor(PieceColorEnum color) {
        this.color = color;
    }
}
