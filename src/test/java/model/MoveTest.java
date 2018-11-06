package model;
import com.webcheckers.model.Move;
import com.webcheckers.model.Position;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveTest {

    private Move move;
    @Ignore
    @Test
    public void getStart(){
        move.setStart(new Position(1,1));
        assertEquals(new Position(1,1),move.getStart());
    }

    @Ignore
    @Test
    public void getEnd(){
        move.setEnd(new Position(1,1));
        assertEquals(new Position(1,1),move.getEnd());
    }
}
