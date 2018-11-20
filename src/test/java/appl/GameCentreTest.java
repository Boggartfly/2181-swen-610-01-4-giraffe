package appl;

import com.webcheckers.appl.GameCentre;
import com.webcheckers.model.Move;
import com.webcheckers.model.Player;
import com.webcheckers.model.Position;
import org.junit.Test;
import static org.junit.Assert.*;
public class GameCentreTest {
    private GameCentre gameCentre;
    public GameCentreTest(){
        gameCentre = new GameCentre();
    }

    @Test
    public void getPlayerMoveTest(){
        Player player = new Player("PlayerTest");
        Position position1 = new Position(1,1);
        Position position2 = new Position(1,2);
        Move move = new Move(position1,position2);
        gameCentre.addPlayerMove(player,move);
        assertEquals(gameCentre.getPlayerMove(player), move);
    }

    @Test
    public void isUserAvailableTest(){
        Player player = new Player("PlayerTest");
        gameCentre.addUser(player.getPlayerName());
        assertTrue(gameCentre.isUserAvailable(player.getPlayerName()));
    }

    @Test
    public void getPlayerTest(){
        gameCentre.addUser("PlayerTest");
        assertEquals(gameCentre.getPlayer("PlayerTest"),new Player("PlayerTest"));
    }
}
