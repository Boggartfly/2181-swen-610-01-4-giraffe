package model;

import com.webcheckers.model.Game;
import com.webcheckers.model.Player;
import org.junit.Test;
import static org.junit.Assert.*;
public class GameTest {
    Game game;
    public GameTest(){
        game = new Game(new Player("A"),new Player("B"));
    }

    @Test
    public void getPlayer(){
        game.setPlayer(new Player("A"));
        assertEquals(game.getPlayer().getPlayerName(),"A");
    }

    @Test
    public void getOpponent(){
        game.setOpponent(new Player("B"));
        assertEquals(game.getOpponent().getPlayerName(),"B");
    }

    @Test
    public void isOpponentAvailable(){
        game.setOpponent(new Player("C"));
        assertTrue(game.isOpponentAvailable());
    }

    @Test
    public void getMyTurn(){
        game.setMyTurn(0);
        assertEquals(0, game.getMyTurn());
    }

    @Test
    public void getBoard(){
        assertNotNull(game.getBoard());
    }
}