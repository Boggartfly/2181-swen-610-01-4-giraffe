package model;

import com.webcheckers.model.Piece;
import com.webcheckers.model.PieceColorEnum;
import com.webcheckers.model.PieceTypeEnum;
import com.webcheckers.model.Space;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class SpaceTest {

    private Space space;

    public SpaceTest(){
        space =  new Space(1,true,new Piece(PieceTypeEnum.SINGLE, PieceColorEnum.RED));
    }

    @Ignore
    @Test
    public void getCellIdx(){
        space.setCellIdx(1);
        assertEquals(1,space.getCellIdx());
    }

    @Ignore
    @Test
    public void getValid(){
        space.setValid(true);
        assertTrue(space.isValid());
    }

    @Ignore
    @Test
    public void getPiece(){
        space.setPiece(new Piece(PieceTypeEnum.SINGLE, PieceColorEnum.RED));
        assertTrue(space.getPiece().getType()==PieceTypeEnum.SINGLE && space.getPiece().getColor()==PieceColorEnum.RED);
    }
}
