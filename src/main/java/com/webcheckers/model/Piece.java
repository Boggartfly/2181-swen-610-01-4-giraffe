package com.webcheckers.model;

public class Piece {

<<<<<<< HEAD
    PieceTypeEnum pieceType;

    PieceColorEnum pieceColor;

    public Piece(PieceTypeEnum pieceType, PieceColorEnum pieceColor) {
        this.pieceType = pieceType;
        this.pieceColor = pieceColor;
    }

    public PieceTypeEnum getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceTypeEnum pieceType) {
        this.pieceType = pieceType;
    }

    public PieceColorEnum getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColorEnum pieceColor) {
        this.pieceColor = pieceColor;
=======
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
>>>>>>> master
    }
}
