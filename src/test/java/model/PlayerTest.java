package model;

import com.webcheckers.model.Board;
import com.webcheckers.model.Message;
import com.webcheckers.model.PieceColorEnum;
import com.webcheckers.model.Player;
import org.junit.Test;
import spark.Session;

import static org.mockito.Mockito.mock;

public class PlayerTest {

    @Test(expected = IllegalArgumentException.class)
    public void nullPlayerName() {

        final Session session = mock(Session.class);
        final Message message = mock(Message.class);
        final Board board = mock(Board.class);

        String playerName = null;
        String opponentName = "team";
        boolean ismyTurn = true;

        new Player(playerName, opponentName, PieceColorEnum.RED, PieceColorEnum.WHITE, ismyTurn, message, board);


    }


    @Test(expected = IllegalArgumentException.class)
    public void nullOpponentName() {

        final Session session = mock(Session.class);
        final Message message = mock(Message.class);
        final Board board = mock(Board.class);


        String playerName = "test";
        String opponentName = null;
        boolean ismyTurn = true;

        new Player(playerName, opponentName, PieceColorEnum.RED, PieceColorEnum.WHITE, ismyTurn, message, board);


    }


    @Test(expected = IllegalArgumentException.class)
    public void nullMessage() {

        final Session session = mock(Session.class);
        final Message message = mock(Message.class);
        final Board board = mock(Board.class);


        String playerName = "test";
        String opponentName = null;
        boolean ismyTurn = true;
        Message message1 = null;

        new Player(playerName, opponentName, PieceColorEnum.RED, PieceColorEnum.WHITE, ismyTurn, message, board);

    }
}