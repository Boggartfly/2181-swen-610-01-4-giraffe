package com.webcheckers.ui;

import static spark.Spark.*;

import com.webcheckers.appl.GameCentre;
import com.webcheckers.appl.GameConstants;
import spark.Request;
import spark.TemplateEngine;


/**
 * The server that initializes the set of HTTP request handlers.
 * This defines the <em>web application interface</em> for this
 * guessing game application.
 *
 * <p>
 * There are multiple ways in which you can have the client issue a
 * request and the application generate responses to requests. If your team is
 * not careful when designing your approach, you can quickly create a mess
 * where no one can remember how a particular request is issued or the response
 * gets generated. Aim for consistency in your approach for similar
 * activities or requests.
 * </p>
 *
 * <p>Design choices for how the client makes a request include:
 * <ul>
 *     <li>Request URL</li>
 *     <li>HTTP verb for request (GET, POST, PUT, DELETE and so on)</li>
 *     <li><em>Optional:</em> Inclusion of request parameters</li>
 * </ul>
 * </p>
 *
 * <p>Design choices for generating a response to a request include:
 * <ul>
 *     <li>View templates with conditional elements</li>
 *     <li>Use different view templates based on results of executing the client request</li>
 *     <li>Redirecting to a different application URL</li>
 * </ul>
 * </p>
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */
public class WebServer {

    //
    // Constants
    //

    /**
     * The URL pattern to request the Home page.
     */
    public static final String LANDING_URL = "/";
    public static final String LOGIN_URL = "/login";
    public static final String GAMELOBBY_URL = "/gameLobby";
    public static final String GAME_URL = "/game";
    public static final String GAME_REQUEST_URL = "/requestMatch";
    public static final String START_GAME_URL = "/startGame";
    public static final String VALIDATION_URL = "validateMove";
    public static final String CHECKTURN_URL = "checkTurn";
    public static final String BACKUPMOVE_URL = "backupMove";
    public static final String SUBMITTURN_URL = "submitTurn";

    //
    // Attributes
    //

    private final TemplateEngine templateEngine;

    //
    // Constructor
    //

    /**
     * The constructor for the Web Server.
     *
     * @param templateEngine
     *    The default {@link TemplateEngine} to render views.
     */
    public WebServer(
            final TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    //
    // Public methods
    //

    /**
     * Initialize all of the HTTP routes that make up this web application.
     *
     * <p>
     * Initialization of the web server includes defining the location for static
     * files, and defining all routes for processing client requests. The method
     * returns after the web server finishes its initialization.
     * </p>
     */
    public void initialize() {
        // Configuration to serve static files
        staticFileLocation("/public");

        //// Setting any route (or filter) in Spark triggers initialization of the
        //// embedded Jetty web server.

        //// A route is set for a request verb by specifying the path for the
        //// request, and the function callback (request, response) -> {} to
        //// process the request. The order that the routes are defined is
        //// important. The first route (request-path combination) that matches
        //// is the one which is invoked. Additional documentation is at
        //// http://sparkjava.com/documentation.html and in Spark tutorials.

        //// Each route (processing function) will check if the request is valid
        //// from the client that made the request. If it is valid, the route
        //// will extract the relevant data from the request and pass it to the
        //// application object delegated with executing the request. When the
        //// delegate completes execution of the request, the route will create
        //// the parameter map that the response template needs. The data will
        //// either be in the value the delegate returns to the route after
        //// executing the request, or the route will query other application
        //// objects for the data needed.

        //// FreeMarker defines the HTML response using templates. Additional
        //// documentation is at
        //// http://freemarker.org/docs/dgui_quickstart_template.html.
        //// The Spark FreeMarkerEngine lets you pass variable values to the
        //// template via a map. Additional information is in online
        //// tutorials such as
        //// http://benjamindparrish.azurewebsites.net/adding-freemarker-to-java-spark/.

        //// These route definitions are examples. You will define the routes
        //// that are appropriate for the HTTP client interface that you define.
        //// Create separate Route classes to handle each route; this keeps your
        //// code clean; using small classes.

        GameCentre gameCentre = new GameCentre();


        before("/", (request, response) -> {
            // ... check if new user
            System.out.println("Landing Filter");

            if(validateLoggedInUser(request)){
                response.redirect("/gameLobby");
            }else if(validateInGameUser(request)){
                response.redirect("/game");
            }

         });


        before("/login", (request, response) -> {
            // ... check if new user
            System.out.println("Login Before Filter");

            if(validateLoggedInUser(request)){
                response.redirect("/gameLobby");
            }else if(validateInGameUser(request)){
                response.redirect("/game");
            }

        });

        after("/login", (request, response) -> {
            System.out.println("Login After Filter");
            if(!request.session().isNew() && request.queryParams().contains("username")){
                System.out.println("User name " +request.queryParams("username"));
            response.header("playerName",request.queryParams("username"));
            response.cookie("playerName",request.queryParams("username"));
            request.session().attribute("playerName",request.queryParams("username"));
                System.out.println("After putting header and cookie ");}


        });


        before("/gameLobby",((request, response) -> {
            if(GameLobbyController.awaitingPlayer.contains(request.session().attribute("playerName"))){
                response.redirect("/game");
            }



        }));

        before("/submitTurn",(((request, response) -> {
            response.redirect("/game");

        })));











        // Shows the Checkers game Home page.


        get(LANDING_URL,new LandingController(gameCentre),templateEngine);

        get(LOGIN_URL,new LoginController(gameCentre),templateEngine);
        post(LOGIN_URL,new ValidateLoginController(gameCentre),templateEngine);

        get(GAMELOBBY_URL,new GameLobbyController(gameCentre),templateEngine);

        post(GAME_REQUEST_URL,new GameRequestController(gameCentre));

        post(START_GAME_URL,new StartGameController(gameCentre),templateEngine);

        get(GAME_URL,new GameController(gameCentre),templateEngine);

        //Validate the move
        post(VALIDATION_URL, new ValidateMoveRoute(gameCentre));
        //Validate the move
        post(CHECKTURN_URL, new CheckTurnRoute(gameCentre));
        //Validate the move
        //Validate the move
        post(SUBMITTURN_URL, new CheckTurnRoute(gameCentre));
        //Validate the move
        post(BACKUPMOVE_URL, new BackUpMoveRoute());



    }

    public boolean validateLoggedInUser(Request request){

        if(!request.session().isNew() && request.session().attributes().contains(GameConstants.playerHeaderName)){
            return true;
        }else {
            return false;
        }

    }

    public boolean validateInGameUser(Request request){

        if(!request.session().isNew() &&
                request.session().attributes().contains(GameConstants.playerHeaderName) &&
                request.session().attributes().contains(GameConstants.opponentHeaderName)){
            return true;
        }else {
            return false;
        }

    }

}
