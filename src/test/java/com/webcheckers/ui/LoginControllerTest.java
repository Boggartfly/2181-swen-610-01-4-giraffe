package com.webcheckers.ui;

import org.junit.Before;
import org.junit.Test;
import spark.*;

import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LoginControllerTest {


    String invalidUserName = "The user name entered is invalid!";
    String unavailableUserName = "The user name is already taken!";

    private Request request;
    private Session session;
    private Response response;

    private LoginController CuT = new LoginController();

    @Before
    public void setup() {
        request = mock(Request.class);
        session = mock(Session.class);
        when(request.session()).thenReturn(session);

        response = mock(Response.class);
    }


    @Test
    public void handle() {
        //todo
    }

    @Test
    public void error(){
        final ModelAndView result = CuT.handle(request, response);
        final Object model = result.getModel();
        @SuppressWarnings("unchecked")
        final Map<String, Object> vm = (Map<String, Object>) model;
        assertEquals("Error returns the correct view", "login.ftl", CuT.error(vm, "test").getViewName());
    }

    @Test
    public void makeBadArgMessage(){
        assertEquals("Message for invalid UserName", invalidUserName, LoginController.makeBadArgMessage());
        assertNotEquals("Message for invalid UserName", "test", LoginController.makeBadArgMessage());
    }

    @Test
    public void makeUnavailableUserMessage(){
        assertEquals("Message for invalid UserName", unavailableUserName, LoginController.makeUnavailableUserMessage());
        assertNotEquals("Message for invalid UserName", "test", LoginController.makeUnavailableUserMessage());
    }
}