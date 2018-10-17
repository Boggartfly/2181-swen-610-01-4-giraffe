import com.webcheckers.model.Piece;
import com.webcheckers.model.PieceColorEnum;
import com.webcheckers.model.PieceTypeEnum;
import org.junit.Test;
import static org.junit.Assert.*;
public class PieceTest {
    private Piece piece;
    public PieceTest(){
        piece = new Piece(PieceTypeEnum.SINGLE, PieceColorEnum.RED);
    }
    @Test
    public void setColor(){
        piece.setColor(PieceColorEnum.WHITE);
    }
    @Test
    public void getColor(){
        assertEquals(PieceColorEnum.RED,piece.getColor());
    }

    @Test
    public void setType(){
        piece.setType(PieceTypeEnum.KING);
    }

    @Test
    public void getType(){
        assertEquals(PieceTypeEnum.SINGLE,piece.getType());
    }

}
