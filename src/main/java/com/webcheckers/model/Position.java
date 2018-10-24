package com.webcheckers.model;

public class Position {

    private int row;
    private int cell;

    public Position(int row, int cell) {
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

    public boolean isValidPosition(){



                    if((row % 2 ==0) && (cell%2==1)){
                        return true;
                    }

                    else if((row%2 ==1) && (cell%2==0)) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }

    public boolean initialPosition(){

        if(row <=2 || row >=5){
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isOpponentsPosition(){
        if(row >= 5){
            return true;
        }
        else {
            return false;
        }
    }
}
