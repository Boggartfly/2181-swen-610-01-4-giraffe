package ui;

import com.webcheckers.appl.GameCentre;
import com.webcheckers.model.Player;
import com.webcheckers.ui.LandingController;
import com.webcheckers.ui.StartGameController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartGameControllerTest {

    private StartGameController CuT ;

    private Request request;
    private Response response;
    @InjectMocks
    private Player player;

    /**
     * Setup new mock objects for each test.
     */
    @Before
    public void setup() {
        request = mock(Request.class);
        Session session = mock(Session.class);
        when(request.session()).thenReturn(session);
        when(request.body()).thenReturn("player=Ashish&control=test");
        response = mock(Response.class);
    }

    @Ignore
    @Test

    public void check_landing_page(){

        GameCentre gameCentre = mock(GameCentre.class);

      //  Mockito.when(new Player(anyString.class).thenReturn(null)));

        Mockito.when(new Player(any(String.class))).thenReturn(null);

        CuT = new StartGameController(gameCentre);
        final ModelAndView result= CuT.handle(request,response);

        Assert.assertNotNull(result);




        //   * model is a non-null Map
        final Object model = result.getModel();
        assertNotNull(model);
        //  assertTrue(model instanceof Map);

        //   * model contains all necessary View-Model data
        final Map<String, Object> vm = (Map<String, Object>) model;
        assertEquals("Checkers Game", vm.get("title"));


        //   * test view name
        assertEquals("game.ftl", result.getViewName());

    }
}
