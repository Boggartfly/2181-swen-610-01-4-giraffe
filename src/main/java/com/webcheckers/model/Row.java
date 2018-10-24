package com.webcheckers.model;


import com.webcheckers.appl.GameCenter;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Row implements Iterable<Space> {


    private int index ;

    private List<Space> spaces ;
    int indexPosition = 0;

    public Row(int index) {

        this.index = index;

        spaces = new ArrayList<>();

        Position p = new Position(0,0);

        p.setRow(index);

        for(int counter=0; counter<=7; counter++){
                p.setCell(counter)  ;

                if(p.isValidPosition() && p.initialPosition()){
                    if(p.isOpponentsPosition()) {
                        add(new Space(counter, false, new Piece(PieceTypeEnum.SINGLE, GameCenter.opponentColor)));
                    }
                    else {

                        add(new Space(counter, false, new Piece(PieceTypeEnum.SINGLE, GameCenter.playerColor)));
                    }
                }
                else if(p.isValidPosition()) {
                    add(new Space(counter, true, null));
                }
                else {
                    add(new Space(counter, false, null));
                }


            /**
            Position position = new Position(counter,)
            if(counter % 2 ==1 && index<=2 && index %2 ==0 ) {

                add(new Space(counter,false,new Piece(PieceTypeEnum.SINGLE, GameCenter.playerColor)));
            }

            else if( (index<=2 && index %2 ==1 &&  counter % 2 ==0))    {
                add(new Space(counter,true,new Piece(PieceTypeEnum.SINGLE, GameCenter.playerColor)));
            }
            else if(counter % 2 ==1 && index>=5 && index %2 ==0){
                add(new Space(counter,false,new Piece(PieceTypeEnum.SINGLE, GameCenter.opponentColor)));
            }
            else if(  index >=5 && index %2 ==1 &&  counter % 2 ==0){
                add(new Space(counter,true,new Piece(PieceTypeEnum.SINGLE, GameCenter.opponentColor)));
            }
            else {
                add(new Space(counter, false, null));
            }

            **/


        }

    }

    private void add(Space space){

        spaces.add(space);
    }

    @Override
    public Iterator<Space> iterator() {
        return new Iterator<Space>() {

            @Override
            public boolean hasNext() {
                if(spaces.size() >=indexPosition +1){
                    return true;
                }
                return false;
            }

            @Override
            public Space next() {
                Space space = spaces.get(indexPosition);
                indexPosition++;

                return space;
            }
        };

    }
}
