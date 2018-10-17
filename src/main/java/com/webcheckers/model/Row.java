package com.webcheckers.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Row implements Iterable<Space> {


    int index ;

    List<Space> spaces ;

    public Row(int index) {

        this.index = index;

        spaces = new ArrayList<>();

        for(int counter=0; counter<=7; counter++){

            if(index % 2 ==0 && counter % 2 ==0) {

                add(new Space(counter,false,null));

            }
            else {
                add(new Space(counter, true, null));
            }

        }

    }

    private void add(Space space){

        spaces.add(space);
    }

    @Override
    public Iterator<Space> iterator() {
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
}
