package com.webcheckers.model;

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
            add(new Row(counter));
        }

    }

    /**
     *
     * @param row
     */
    private void add(Row row){

        rowList.add(row);
    }

    @Override
    public Iterator<Row> iterator() {

        return new RowIterator<>(rowList);
    }



    /**This class is an iterator
     *
     * @param <Row>
     */
    private class RowIterator<Row> implements Iterator<Row>{

        int indexPosition =0;
        List<Row> rowList;

        public RowIterator(List<Row> rowList) {
            this.rowList = rowList;
        }


        @Override
        public boolean hasNext() {

            if(rowList.size() >= indexPosition+1){
                return true;
            }
            return false;
        }

        @Override
        public Row next() {
            Row row = rowList.get(indexPosition);
            indexPosition++;

            return row;

        }
    }




}
