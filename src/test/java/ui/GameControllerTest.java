package ui;

import com.webcheckers.model.Game;
import com.webcheckers.model.Player;
import com.webcheckers.ui.GameController;
import com.webcheckers.appl.GameCentre;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameControllerTest {


    private GameController CuT ;

    private Request request;
    private Response response;

    /**
     * Setup new mock objects for each test.
     */
    @Before
    public void setup() {
        request = mock(Request.class);
        Session session = mock(Session.class);
        when(request.session()).thenReturn(session);
        response = mock(Response.class);
    }

    @Test
    public void check_new_game(){



        GameCentre gameCenter = mock(GameCentre.class);

        when(GameCentre.userPlayerMap).thenReturn(new HashMap<>());


        when(request.queryParams("player")).thenReturn("Ashish");
        when(request.queryParams("opponent")).thenReturn("Chhabra");

        CuT = new GameController(gameCenter);

        final ModelAndView result= CuT.handle(request,response);


        Assert.assertNotNull(result);

        //   * model is a non-null Map
        final Object model = result.getModel();
        assertNotNull(model);
        //  assertTrue(model instanceof Map);

        //   * model contains all necessary View-Model data
        final Map<String, Object> vm = (Map<String, Object>) model;
        assertEquals("Ashish", vm.get("playerName"));
        assertEquals("Chhabra", vm.get("opponentName"));


        //   * test view name
        assertEquals("game.ftl", result.getViewName());
    }

}
