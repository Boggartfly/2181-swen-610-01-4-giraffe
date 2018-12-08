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

    /**
     *
     * @param playerType
     * @return
     */

    public boolean isValidMove(String playerType) {
        switch (playerType) {
            case "player":
                return this.getEnd().getRow() == this.getStart().getRow() + 1
                        && Math.abs(this.getEnd().getCell() - this.getStart().getCell()) == 1;
            case "opponent":
                return this.getEnd().getRow() == this.getStart().getRow() - 1
                        && Math.abs(this.getEnd().getCell() - this.getStart().getCell()) == 1;

            default:
                return false;

        }
    }


    /**
     *
     * @param playerType
     * @param pieceTypeEnum
     * @return
     */

    public boolean isValidMove(String playerType,PieceTypeEnum pieceTypeEnum){

        switch (pieceTypeEnum){

            case SINGLE:
                return isValidMove(playerType);

            case KING:
                if((this.getEnd().getRow() == this.getStart().getRow() +1
                    && Math.abs(this.getEnd().getCell()-this.getStart().getCell()) ==1)
                    || (this.getEnd().getRow() == this.getStart().getRow() -1
                    && Math.abs(this.getEnd().getCell()-this.getStart().getCell()) ==1)){
                        return true;

                    }else {
                       return false;

                    }
            default:
                return false;
        }


    }


    /**
     *
     * @param playerType
     * @return
     */
    public boolean isValidJumpMove(String playerType ){


        switch (playerType) {
            case "player":
                return this.getEnd().getRow() == this.getStart().getRow() + 2
                        && Math.abs(this.getEnd().getCell() - this.getStart().getCell()) == 2;

            case "opponent":
                return this.getEnd().getRow() == this.getStart().getRow() - 2
                        && Math.abs(this.getEnd().getCell() - this.getStart().getCell()) == 2;

                default:
                    return false;
        }


    }

    /**
     *
     * @param playerType
     * @param pieceTypeEnum
     * @return
     */
    public boolean isValidJumpMove(String playerType , PieceTypeEnum pieceTypeEnum ){

        switch (pieceTypeEnum){
            case SINGLE:
                return isValidJumpMove(playerType);
            case KING:
                if( Math.abs(this.getEnd().getRow()-this.getStart().getRow()) ==2
                        && Math.abs(this.getEnd().getCell()-this.getStart().getCell()) ==2){
                    return true;
                }else {
                    return false;
                }


            default:
                return false;
        }

    }

    /**
     *
     * @param playerType
     * @return
     */
    public boolean isKing(String playerType) {
        switch (playerType) {
            case "player":

                return this.getEnd().getRow()==7 ? true:false;

            case "opponent":
                return this.getEnd().getRow() ==0 ? true :false;

             default:
                 return false;

        }
    }
}
