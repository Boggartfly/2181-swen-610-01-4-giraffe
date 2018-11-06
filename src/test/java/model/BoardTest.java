package model;

import com.webcheckers.model.*;
import org.junit.Test;
import static org.junit.Assert.*;
public class BoardTest {
    Board board;
    public BoardTest(){
        board = new Board();
    }

    @Test
    public void fetchPiece(){
        board.setPiece(new Position(1,1),new Piece(PieceTypeEnum.SINGLE, PieceColorEnum.RED));
        assertEquals(board.fetchPiece(new Position(1,1)),board.fetchPiece(new Position(1,1)));
    }

    @Test
    public void iterator(){
        assertTrue(board.iterator().getClass().getTypeName().equalsIgnoreCase("Iterator<Row>"));
    }

}
