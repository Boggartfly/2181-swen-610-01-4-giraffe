package model;

import com.webcheckers.model.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.when;



public class BoardTest {

    @Before
    public void testSetUp(){
        Piece piece = new Piece(PieceTypeEnum.SINGLE,PieceColorEnum.RED);
    }

    @Ignore
    @Test
    public void fetchPiece(){

        Board CuT = new Board();
        Position position = mock(Position.class);

        position.setCell(1);
        position.setRow(1);
        Piece piece = mock(Piece.class);

        piece.setColor(PieceColorEnum.RED);
        piece.setType(PieceTypeEnum.SINGLE);

        CuT.setPiece(position,piece);


        System.out.println("###### " +CuT.fetchPiece(position).getType());


     //   board.setPiece(new Position(1,1),new Piece(PieceTypeEnum.SINGLE, PieceColorEnum.RED));
     //   assertEquals(board.fetchPiece(new Position(1,1)),board.fetchPiece(new Position(1,1)));
    }

    @Ignore

    @Test
    public void iterator(){
    //    assertTrue(board.iterator().getClass().getTypeName().equalsIgnoreCase("Iterator<Row>"));
    }

}
