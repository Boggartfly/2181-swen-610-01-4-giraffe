package ui;

import com.webcheckers.appl.GameCentre;
import com.webcheckers.ui.GameController;
import com.webcheckers.ui.LandingController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LandingControllerTest {

    private LandingController CuT ;

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

    @Ignore
    @Test
    public void check_landing_page(){

        GameCentre gameCentre = mock(GameCentre.class);

        CuT = new LandingController(gameCentre);
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
        assertEquals("landing.ftl", result.getViewName());

    }
}
