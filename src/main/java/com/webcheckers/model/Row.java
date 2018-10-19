package com.webcheckers.model;

<<<<<<< HEAD
=======
import com.webcheckers.appl.GameCenter;

>>>>>>> master
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Row implements Iterable<Space> {


<<<<<<< HEAD
    int index ;

    List<Space> spaces ;
=======
    private int index ;

    private List<Space> spaces ;
    int indexPosition = 0;
>>>>>>> master

    public Row(int index) {

        this.index = index;

        spaces = new ArrayList<>();

        for(int counter=0; counter<=7; counter++){

<<<<<<< HEAD
            if(index % 2 ==0 && counter % 2 ==0) {

                add(new Space(counter,false,null));

            }
            else {
                add(new Space(counter, true, null));
            }
=======
            if(counter % 2 ==1 && (index<=2||index>=5) && index %2 ==0 ) {

                add(new Space(counter,false,new Piece(PieceTypeEnum.SINGLE, GameCenter.playerColor)));
            }

            else if( (index<=2|| index >=5) && index %2 ==1 &&  counter % 2 ==0){
                add(new Space(counter,true,new Piece(PieceTypeEnum.SINGLE, GameCenter.playerColor)));
            }

/**
            else if(counter % 2 ==0 && index>=5) {
                add(new Space(counter, false, new Piece(PieceTypeEnum.SINGLE,GameCenter.opponentColor)));
            }
**/
            else
                add(new Space(counter,true,null));
>>>>>>> master

        }

    }

    private void add(Space space){

        spaces.add(space);
    }

    @Override
    public Iterator<Space> iterator() {
<<<<<<< HEAD
        return new SpaceIterator<>(spaces);

    }


    private class SpaceIterator<Space> implements Iterator{

        int indexPosition = 0;
        List<Space> internalList ;

        public SpaceIterator(List<Space> internalList) {
            this.internalList = internalList;
        }

        @Override
        public boolean hasNext() {

            if(internalList.size() >=indexPosition +1){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            Space space = internalList.get(indexPosition);
            indexPosition++;

            return space;
        }
    }
=======
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



>>>>>>> master
}
