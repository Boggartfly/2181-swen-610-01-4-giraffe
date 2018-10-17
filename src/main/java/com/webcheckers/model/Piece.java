package com.webcheckers.model;

public class Piece {

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
    }
}
