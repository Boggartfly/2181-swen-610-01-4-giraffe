package com.webcheckers.model;

public class Move {

    Position start;
    Position end;

    public Move(Position start, Position end) {
        this.start = start;
        this.end = end;
    }

    public Position getStart() {
        return start;
    }

    public void setStart(Position start) {
        this.start = start;
    }

    public Position getEnd() {
        return end;
    }

    public void setEnd(Position end) {
        this.end = end;
    }


    public boolean isValidMove(String playerType) {
        switch (playerType) {
            case "player":
                if (this.getEnd().getRow() == this.getStart().getRow() + 1
                        && Math.abs(this.getEnd().getCell() - this.getStart().getCell()) == 1) {
                    return true;

                } else {
                    return false;
                }
            case "opponent":
                if (this.getEnd().getRow() == this.getStart().getRow() - 1
                        && Math.abs(this.getEnd().getCell() - this.getStart().getCell()) == 1) {
                    return true;

                } else {
                    return false;
                }

            default:
                return false;

        }
    }

    public boolean isValidJumpMove(String playerType) {

        switch (playerType) {
            case "player":
                if (this.getEnd().getRow() == this.getStart().getRow() + 2
                        && Math.abs(this.getEnd().getCell() - this.getStart().getCell()) == 2) {
                    return true;
                } else {
                    return false;
                }

            case "opponent":
                if (this.getEnd().getRow() == this.getStart().getRow() - 2
                        && Math.abs(this.getEnd().getCell() - this.getStart().getCell()) == 2) {
                    return true;
                } else {
                    return false;
                }

            default:
                return false;


        }

    }

    public boolean isKing(String playerType) {
        switch (playerType) {
            case "player":
                if (this.getEnd().getRow() == 7) {
                    return true;
                } else {
                    return false;
                }

            case "opponent":
                if (this.getEnd().getRow() == 0) {
                    return true;
                } else {
                    return false;
                }

            default:
                return false;
        }
    }
}
