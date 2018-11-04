package com.webcheckers.model;

import org.junit.Test;

/* Author<Hind Alharbi> */

public class MoveTest {


    private Position[] positions;
    private Position setStart;
    private Position setEnd;

    private void assertEquals() {
    }


    @Test
    public void getStart() {
        Move move=new Move(setStart,setEnd);
    }

    @Test
    public void setStart() {
        Move move=new Move(setStart,setEnd);
        move.setStart(setStart);
    }

    @Test
    public void getEnd() {
        Move move=new Move(setStart,setEnd);

    }

    @Test
    public void setEnd() {
        Move move=new Move(setStart,setEnd);
        move.setStart(setStart);
    }
}
