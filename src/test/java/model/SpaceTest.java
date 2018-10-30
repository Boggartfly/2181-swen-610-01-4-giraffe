
package model;


import com.webcheckers.model.Piece;
import com.webcheckers.model.Space;
import org.junit.Test;
import spark.Session;

import static org.mockito.Mockito.mock;


public class SpaceTest {

    @Test(expected = IllegalArgumentException.class)
    public void nullCellIdx(){
        final Session session = mock(Session.class);
        final Piece piece = mock(Piece.class);


        int cellIdx = 300;
        boolean isValid =false;
        new Space(cellIdx, isValid, piece);

    }

}
