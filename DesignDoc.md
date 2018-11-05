## Link for the full document with images added: https://docs.google.com/document/d/17i0GBq-aOGfx6zWmA-9hy5hxdTxaCsxSVtESq3ZvLMM/edit?usp=sharing

# PROJECT Design Documentation

## Executive Summary


### Purpose
> The main goal of the project is to build a functioning Web Checkers application. The application should allow for 2 players to play a game of checkers following the American rules. We (the team) will focus on creating the application while learning the necessary technologies and implementing what was learned. 

>This design documentation contains all the decisions the team took in order to build the web checkers application. The team did not have decision making opportunities on some of the design decisions. For example, the architecture and technologies were decided by the product owner (the professor of the class).



### Glossary and Acronyms
> Provide a table of terms and acronyms.

| Term | Definition |
|------|------------|
| VO | Value Object |
| MVP | Minimum Viable Product |


## Requirements
### Definition of MVP
> The WebCheckers Vision Document, defines the minimal set of features the application needs to implement and provides a brief description of what the application is to accomplish.

> The description says: “The application must allow players to play checkers with other players who are currently signed-in. The game user interface (UI) will support a game experience using drag-and-drop browser capabilities for making moves.”

> This minimal set of features is referred to as MVP or Minimum Viable Product. The set of features are the following: 

* Every player must sign-in before playing a game.
* Two players must be able to play a game of checkers based upon the American rules.
* Either player of a game may choose to resign, which ends the game.


### MVP Features
> The team analysed the MVP set of features and determined that, while short and concise, in order to fully implement it, the features needed to be broken down in multiple shorter more easily achieved set of smaller features. In order to do this, the team created a set of user stories per feature and placed them on the team trello board. The team created the user stories with the common description template “As a [...] I want to [...] so that I [...]”. At the beginning of each sprint, in the sprint planning, the selected user stories are then more specifically detailed and explained adding Definition of Done checklist, Acceptance Criteria checklist and Solution Tasks checklist.

1. Games can be stored for later review.
2. A player may play more than one game at a time.
3. Players can play asynchronously.
4. Other players may view an on-going game that they are not playing.
5. Players can play in checkers tournaments.
6. Players may play a game against an AI player.

### Roadmap of Enhancements
> After the completion of the MVP features, the team will decide upon which extra or set of extra features (also called enhancements) will be added to the application. This decision will take place after feedback for the application implementing the MVP is obtained from the stakeholders of the project (professor and classmates). While the team hasn’t made any decisions onto which enhancements will be implemented, we have sorted the list of the possible enhancements. The team made a top to bottom list where the top placed enhancements is the more likely to be added to the application and the bottom one is the less likely. The list ended up as:



## Application Domain
### Overview of Major Domain Areas
> As an overview of the Major Domain Areas we designed a Model Domain Diagram. This diagram includes the domain for the top priority enhancement (Games can be stored for later review).


### Details of each Domain Area
> While the diagram does not include any reference to possible attributes of the entities, we detail each entity briefly below.

* User: Any person after completion of a successful log in
* Player: A user that has entered a game.
* Game: The main entity, it joins the users as player and opponent. It contains a board and for each movement, it validates with the Rules to check whether is a valid one or not.
* Rules: Entity that contains all the rules. The game will validate with it to see if the movements are valid.
* Board: Where the game is played. It will be updated for the player and opponent based on the moves of each other.
* Square: The board contains squares (64) out of which, on only 32 of them, the dark ones, are made available for players to move their pieces on.
* Piece: Each player has a set 12 pieces, these are used to play the game and are differentiated by color
  *Soldier: At the beginning of the game all the pieces are soldiers
  *Kings: When a soldier reaches the farthest row on the opponent side, it becomes a King. A King has more movement sets available.
*Review Game: Entity to manage everything related to storing the games. The stored games are based on Games and the Users should be able to access them.



## Architecture
### Summary
> The team did not have a saying on the selection of the architecture or base set of technologies to be used. The following are the decisions that were not made by the team.

The architecture to be used is divided as:
- UI (Client and Server)
- Application
- Model
- The WebCheckers application will use a Java-based web server 
- The team will use the Spark web micro framework and FreeMarker template engine to handle HTTP requests and generate HTML responses
- Maven is to be used for building the application
- The team may include additional third party technologies, this requires approval of the Product Owner.

> The team was also instructed to use the OpenUP method for planning activities across the lifespan of the project and to also use the Scrum process for day-to-day operations. 

> It is also important to mention that the team was provided with some of the base structure (classes, view templates, etc) for the Game view (the actual game with the board and pieces). The team also makes use of the provided JavaScript files to handle the Game view.

> Below is a diagram of the architecture the team uses for the WebCheckers app. The team did not create this diagram but instead was provided to us via the Product Owner.


### Overview of User Interface
> The team created mockups for the interface of the WebCheckers app. These mockups are not mean to be followed strictly by the team on the implementation but to serve as a guide. Below we place the mockups and how the screen was actually implemented. Note that the implementation of the MVP features is not yet completed so the design may vary. The mockups were created using LucidChart tool.

> For each screen, the first picture is the mockup and the second one is what was implemented.


### Overview of Client UI
> Basically everything that a user can see. All the HTMLs, CSS & Javascript. This layer is accessed via any web browser on any operating system. 
> We have three client UI :
1. Game.ftl - It represents the board that the user is going to see. All the actions related to the board are rendered by Game UI.
2. GameLobby.ftl - Game Lobby helps players to see other online players, send them request to play a game.
3. Landing.ftl - This is the  first UI displayed to the user when he hits the url . This is more like a welcome screen for the user.
4. Login.ftl - This UI is rendered to the user when he wish to logs in from the landing UI page. The use could use a non-existing user name to enter to the Game Lobby UI.

### Overview of Server UI
Contains the controllers that, depending on user interactions, will get information from the models, do operations and display them to the user. 

#### Route:
* BackUpMoveRoute
* CheckTurnRoute
* ValidateMoveRoute

#### Controller:
* GameController
* GameLobbyController
* GameRequestController
* LandingController
* LoginController
* StartGameController
* ValidateLoginController

### Overview of Application
> Application layer helps to regulate the state of the game. 
> We have GameCentre class which is passed to every controller to know the current state of the game on each request. On every request the state of the game is modified is accessible to the next request from the GameCentre. 

### Overview of Model
> Holds the core domain entities the of the game.
* Board
* Game
* main
* Message
* MessageTypeEnum
* Move
* Piece
* PieceColorEnum
* PieceTypeEnum
* Player
* Position
* Row
* Space
* UserStateEnum



## Diagrams
> The team created a set of diagrams that are to be used to guide the implementation. This diagrams are also updated based on new decisions taken during implementation. The diagrams were created using LucidChart tool.

### Static Model(s) 

> Class Diagram of the Model classes. It shows the relations between the model classes and some of their attributes. Note that this diagram can change as the implementation advances.

### Dynamic Model(s)

#### Sequence Diagram for Game Start feature. 
> It shows the calls that are made from the login until a game is started.

#### Statechart Diagram. 
> It shows the views as states and the multiple http methods that are used as transitions. Note that this might change as the implementation advances.

