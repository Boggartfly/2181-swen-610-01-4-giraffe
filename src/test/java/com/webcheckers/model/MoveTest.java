package com.webcheckers.model;

import org.junit.Test;

/* Author<Hind Alharbi> */

public class MoveTest {


    private Position[] positions;
    private Position setStart;
    public Position setEnd;
    @Test
    public void setStart(Position start) {
        Move move=new Move(start,setEnd);
        move.setStart(start);
        assertEquals(new Position[]{start});
        

    }

    private void assertEquals(Position[] positions) {
    }


    @Test
    public void getStart(Position start) {
        Move move=new Move(start,setEnd);
        assertEquals(new Position[]{start});
    }

    @Test
    public void setStart() {
        Move move=new Move(setStart,setEnd);
        move.setStart(setStart);
    }

    @Test
    public void getEnd( Position end) {
        Move move=new Move(setStart,end);
        assertEquals(new Position[]{end});
    }

    @Test
    public void setEnd() {
        Move move=new Move(setStart,setEnd);
        move.setStart(setStart);
    }
}
