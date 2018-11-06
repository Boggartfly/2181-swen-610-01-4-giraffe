package com.webcheckers.model;

/**
 * Author : Ashish
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Board is an iterable
 *
 * An iterable should have an iterator to iterate over
 *
 */

public class Board  implements Iterable<Row>  {

    private List<Row> rowList;

    /**
     *
     */
    public Board() {

        rowList = new ArrayList<>();

        for(int counter =0; counter <=7; counter ++ )
        {

            rowList.add(new Row(counter));
        }

        System.out.println("Row List Size " +rowList.size());


    }

    /**
     *
     * @param row
     */
    private void add(Row row){

        rowList.add(row);
    }

    public void getRow(int rowIndex,int spaceIndex){
        rowList.stream().filter(row->row.getIndex()==rowIndex).findFirst().get()
                .getSpaces().stream().filter(space -> space.getCellIdx()==spaceIndex).findFirst().get().getPiece();
    }

    @Override
    public Iterator<Row> iterator() {

        return rowList.iterator();
    }


    public Piece fetchPiece(Position position){

        return rowList.stream().filter(row-> row.getIndex() == position.getRow()).findFirst().get().getSpaces()
                .stream().filter(space -> space.getCellIdx() == position.getCell()).findFirst().get().getPiece();

    }

    public void setPiece(Position position, Piece piece){
        rowList.stream().filter(row-> row.getIndex() == position.getRow()).findFirst().get().getSpaces()
                .stream().filter(space -> space.getCellIdx() ==position.getCell()).findFirst().get().setPiece(piece);
    }

}
