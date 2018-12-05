package com.webcheckers.model;

/**
 * Author : Ashish
 */

import java.util.*;

/**
 * Board is an iterable
 * <p>
 * An iterable should have an iterator to iterate over
 */

public class Board  implements Iterable<Row> {


    private List<Row> rowList;

    /**
     *
     */
    public Board() {

        rowList = new ArrayList<>();

        for (int counter = 0; counter <= 7; counter++) {

            rowList.add(new Row(counter));
        }

        System.out.println("Row List Size " + rowList.size());


    }

    /**
     * @param row
     */
    private void add(Row row) {

        rowList.add(row);
    }

    public void getRow(int rowIndex, int spaceIndex) {
        rowList.stream().filter(row -> row.getIndex() == rowIndex).findFirst().get()
                .getSpaces().stream().filter(space -> space.getCellIdx() == spaceIndex).findFirst().get().getPiece();
    }

    @Override
    public Iterator<Row> iterator() {

        return rowList.iterator();
    }


    public Piece fetchPiece(Position position) {

        return rowList.stream().filter(row -> row.getIndex() == position.getRow()).findFirst().get().getSpaces()
                .stream().filter(space -> space.getCellIdx() == position.getCell()).findFirst().get().getPiece();

    }

    public void setPiece(Position position, Piece piece) {
        rowList.stream().filter(row -> row.getIndex() == position.getRow()).findFirst().get().getSpaces()
                .stream().filter(space -> space.getCellIdx() == position.getCell()).findFirst().get().setPiece(piece);
    }


    public Boolean isValidJump(Move move, String playerType){

        Boolean result= false;

        try {
            Position position = new Position((move.getEnd().getRow() + move.getStart().getRow()) / 2, (move.getEnd().getCell() + move.getStart().getCell()) / 2);

            Piece piece = fetchPiece(position);

            if (piece != null && piece.getColor().equals(PieceColorEnum.getOpponentColor(playerType))) {

                result = true;
            }
        }catch (Exception e){

        }

        return result;
    }


    public List<Position> generateMoveEndPositions(Position startPosition, PieceColorEnum pieceColorEnum,String playerType) {

        List<Position> positionList = new ArrayList<>();

        switch (playerType) {
            case "player":
                try {
                    Position pos = new Position(startPosition.getRow() + 2, startPosition.getCell() + 2);
                    if (fetchPiece(pos) == null) {
                        positionList.add(pos);
                    }
                } catch (Exception e) {
                }
                try {
                    Position pos = new Position(startPosition.getRow() + 2, startPosition.getCell() - 2);
                    if (fetchPiece(pos) == null) {
                        positionList.add(pos);
                        break;
                    }
                } catch (Exception e) {
                    break;
                }
            case "opponent":
                try {
                    Position pos = new Position(startPosition.getRow() - 2, startPosition.getCell() + 2);
                    if (fetchPiece(pos) == null) {
                        positionList.add(pos);
                    }
                } catch (Exception e) {
                }
                try {
                    Position pos = new Position(startPosition.getRow() - 2, startPosition.getCell() - 2);
                    if (fetchPiece(pos) == null) {
                        positionList.add(pos);
                    }
                    break;
                } catch (Exception e) {
                    break;
                }

        }
        return positionList;
    }

    public List<Move> generateAvailableJumpMoves(PieceColorEnum pieceColor, String playerType){

        List<Position> availableSinglePiecesPositions = new ArrayList<>();
        List<Move> moves = new ArrayList<>();

        rowList.stream().forEach(row -> {
            row.getSpaces().stream().filter(space -> space.getPiece() != null
                    && space.getPiece().getColor().equals(pieceColor)
                    && space.getPiece().getType().equals(PieceTypeEnum.SINGLE)).forEach(
                    space -> availableSinglePiecesPositions.add(new Position(row.getIndex(), space.getCellIdx())));
        });

         for(Position startPostion: availableSinglePiecesPositions){
            for(Position endPosition: generateMoveEndPositions(startPostion,pieceColor,playerType)){

                Move move = new Move(startPostion,endPosition);
                 if(move.isValidJumpMove(playerType) && isValidJump(move,playerType)){
                    moves.add(move);
                }
            }
        }

        return moves;
    }

    public Boolean isOpponentPieceLeft(String playerType){
        List<Position> availablePosition = new ArrayList<>();

        rowList.stream().forEach(row -> {
            row.getSpaces().stream().filter(space -> space.getPiece() != null
                    && space.getPiece().getColor().equals(PieceColorEnum.getOpponentColor(playerType))
                   ).forEach(
                    space -> availablePosition.add(new Position(row.getIndex(), space.getCellIdx())));
        });

        return availablePosition.size() ==0 ?true :false;

    }

    public Board removePieces(){
        List<Position> availablePosition = new ArrayList<>();

        rowList.stream().forEach(row -> {
            row.getSpaces().stream().filter(space -> space.getPiece() != null).forEach(
                    space -> availablePosition.add(new Position(row.getIndex(), space.getCellIdx())));
        });



        for(Position p: availablePosition){

            if((p.getRow()==2 && p.getCell() ==1) || (p.getRow()==5 && p.getCell()==0)){

            }
            else {
                this.setPiece(p, null);
            }
        }
        return this;

    }

    public Board removePiecesForKing(){

        List<Position> availablePosition = new ArrayList<>();

        rowList.stream().forEach(row -> {
            row.getSpaces().stream().filter(space -> space.getPiece() != null).forEach(
                    space -> availablePosition.add(new Position(row.getIndex(), space.getCellIdx())));
        });

        for(Position p: availablePosition){

            if( (p.getRow()==0 && p.getCell() ==3) || (p.getRow()==1 && p.getCell() ==0) || (p.getRow()==5 && p.getCell() ==0) ){

                this.setPiece(p, null);

            }
            else if(p.getRow()==3 && p.getCell() ==0) {

                this.setPiece(p,new Piece(PieceTypeEnum.SINGLE,PieceColorEnum.RED));

            }
            else if(p.getRow()==2 && p.getCell() ==1) {
                this.setPiece(p,new Piece(PieceTypeEnum.SINGLE,PieceColorEnum.WHITE));

            }
        }
        return this;



    }



}