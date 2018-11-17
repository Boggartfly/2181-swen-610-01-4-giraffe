package model;
import com.webcheckers.model.Move;
import com.webcheckers.model.Position;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.junit.Assert.*;

public class MoveTest {

    private Move CuT;

    @InjectMocks
    Position position;

    @Ignore
    @Test
    public void getStart(){

        CuT = new Move(position,position);
        CuT.setStart(new Position(1,1));
        assertEquals(new Position(1,1),CuT.getStart());
    }

    @Ignore
    @Test
    public void getEnd(){
        CuT.setEnd(new Position(1,1));
        assertEquals(new Position(1,1),CuT.getEnd());
    }
}
