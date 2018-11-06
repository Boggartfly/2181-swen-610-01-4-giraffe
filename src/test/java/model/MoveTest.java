package model;
import com.webcheckers.model.Move;
import com.webcheckers.model.Position;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveTest {

    private Move move;
    @Test
    public void getStart(){
        move.setStart(new Position(1,1));
        assertEquals(new Position(1,1),move.getStart());
    }

    @Test
    public void getEnd(){
        move.setEnd(new Position(1,1));
        assertEquals(new Position(1,1),move.getEnd());
    }
}
