package com.webcheckers.model;

public class Position {

    private int row;
    private int cell;

    public Position(int row, int cell) {
        if(row > 7 || cell >7 || row <0 || cell <0 ){
            throw new IllegalArgumentException();
        }
        this.row = row;
        this.cell = cell;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCell() {
        return cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }

    public boolean isValidPosition() {

        if ((row % 2 == 0) && (cell % 2 == 1)) {
            return true;
        } else return (row % 2 == 1) && (cell % 2 == 0);
    }

    public boolean initialPosition() {

        return row <= 2 || row >= 5;
    }

    public boolean isOpponentsPosition() {
        return row >= 5;
    }

    @Override
    public boolean equals(Object position) {
        Position pos = (Position) position;
        return pos.row == this.row && pos.cell == this.cell;
    }
}
