package com.webcheckers.model;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Row implements Iterable<Space> {


    private List<Space> spaces;
    private int index;


    public Row(int index) {

        this.index = index;

        spaces = new ArrayList<>();

        Position p = new Position(0, 0);

        p.setRow(index);

        for (int counter = 0; counter <= 7; counter++) {
            p.setCell(counter);

            if (p.isValidPosition() && p.initialPosition()) {
                if (p.isOpponentsPosition()) {
                    add(new Space(counter, true, new Piece(PieceTypeEnum.SINGLE, PieceColorEnum.WHITE)));
                } else {

                    add(new Space(counter, true, new Piece(PieceTypeEnum.SINGLE, PieceColorEnum.RED)));
                }
            } else if (p.isValidPosition()) {
                add(new Space(counter, true, null));
            } else {
                add(new Space(counter, false, null));
            }

        }

    }

    private void add(Space space) {

        spaces.add(space);
    }

    public List<Space> getSpaces() {
        return spaces;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public Iterator<Space> iterator() {
        return spaces.iterator();

    }
}
