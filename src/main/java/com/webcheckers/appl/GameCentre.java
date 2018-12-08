package com.webcheckers.appl;

/**
 * Author: Ashish, Diego
 */
/**
 * This class holds the state of the Game and is passed to every controller to share
 * state between different controller calls.
 */

import com.webcheckers.model.Game;
import com.webcheckers.model.Move;
import com.webcheckers.model.Player;

import java.util.*;

public class GameCentre {

    /**
     * Represents a Map of "player name"( entered as username during the start of the game) and player Object
     */
    public static Map<String, Player> userPlayerMap;

    /**
     * Holds the  "player name"( entered as username during the start of the game)
     */
    private static Set<String> userSet;

    /**
     * Holds all the current running Game objects
     */
    private static Set<Game> gameList;

    /**
     * Used to identify online players on the game Lobby. Holds the list of player available to play. Once a player is assigned a Game
     * it is no longer in available User Set.
     */
    private Set<String> availableuserSet;

    /**
     * Used to store a List of Moves of a Player during the Validate Move Route call. Once the move is Submitted via SubmitMoveController
     * , All the moves are fetched from this Map and then deleted.
     */
    private  Map<Player, List<Move>> playerMoves;


    /**
     * Constructor to intialize the above Maps and Sets
     */
    public GameCentre() {

        userPlayerMap = new HashMap<>();
        userSet = new HashSet<>();
        gameList = new HashSet<>();
        availableuserSet = new HashSet<>();
        playerMoves = new HashMap<>();
    }

    /**
     * returns the set of users available to play the game
     * @return
     */
    public Set<String> getAvailableuserSet() {
        return availableuserSet;
    }

    /**
     * add a move to the corresponding List of moves for the player
     * @param player
     * @param move
     */

    public void addPlayerMove(Player player, Move move) {

        if (playerMoves.get(player) == null) {

            List<Move> moves = new ArrayList<>();
            moves.add(move);
            playerMoves.put(player, moves);
        } else {
            playerMoves.get(player).add(move);
        }

    }

    /**
     * fetches the first Move from the player Moves
     * @param player
     * @return
     */

    public Move getPlayerMove(Player player) {

        if(playerMoves.get(player)!=null) {

            return playerMoves.get(player).stream().findFirst().get();
        }else
            return null;
    }

    /**
     * removes the move from the corresponding List of player moves
     * @param player
     * @param move
     */

    public void removePlayerMove(Player player, Move move) {

        playerMoves.get(player).
                remove(playerMoves.get(player).stream().filter(move1 -> move1.getStart() == move.getStart() && move1.getEnd() == move.getEnd()).findFirst().get());

    }

    /**
     * Removes all the moves from the List of player moves for the player
     * @param player
     */

    public void removePlayerMoves(Player player){

        playerMoves.put(player,null);

    }

    /**
     * return the list of moves for a player
     * @param player
     * @return
     */

    public List<Move> getPlayerMoves(Player player){

        return playerMoves.get(player);
    }

    /**
     * Identifies if a user is Available to play
     * @param userName
     * @return
     */

    public boolean isUserAvailable(String userName) {
        return !userSet.contains(userName);
    }

    /**
     * Add a user to the available user set
     * @param userName
     */

    public void addUser(String userName) {
        userSet.add(userName);
    }

    /**
     * Removes a user from the available user set
     * @param userName
     */
    public void removeUser(String userName) {
        userSet.remove(userName);
    }

    /**
     * return the Player object based on the player name
     * @param userName
     * @return
     */
    public Player getPlayer(String userName) {
        Player player = null;

        for (String user : userPlayerMap.keySet()) {

            if (userName.equalsIgnoreCase(user)) {
                player = userPlayerMap.get(user);
            }

        }
        return player;
    }

    /**
     * returns the current game of the player
     * @param player
     * @return
     */

    public Game getPlayerGame(Player player) {

        System.out.println("########" + player.toString());

        try {


            return gameList.stream().filter(game -> game.getPlayer().getPlayerName().equalsIgnoreCase(player.getPlayerName()) ||
                    game.getOpponent().getPlayerName().equalsIgnoreCase(player.getPlayerName())).findFirst().get();

        }catch (Exception e){
            return null;
        }
    }

    /**
     * reutrns the type of the player as "player"(Red) or "opponent"(White)
     * @param player
     * @return
     */
    public String getPlayerType(Player player) {
        if (gameList.stream().anyMatch(game -> game.getPlayer().getPlayerName().equalsIgnoreCase(player.getPlayerName()))) {
            return "player";
        } else if (gameList.stream().anyMatch(game -> game.getOpponent().getPlayerName().equalsIgnoreCase(player.getPlayerName()))) {
            return "opponent";
        } else {
            return null;
        }
    }


    /**
     *
     * @param playerName
     * @param player
     */
    public void setUserPlayerMap(String playerName, Player player) {

        userPlayerMap.put(playerName, player);
    }

    public void addAvailableUser(String userName) {

        availableuserSet.add(userName);

    }

    /**
     *
     * @param game
     */

    public void addGame(Game game) {
        gameList.add(game);
    }

    /**
     *
     * @param player
     * @param game
     */
    public void updateGame(Player player, Game game) {
        gameList.remove(getPlayerGame(player));
        gameList.add(game);
    }

    /**
     *
     * @param game
     */
    public void removeGame(Game game) {
        gameList.remove(game);
    }

    /**
     *
     * @param userName
     */
    public void removeAvailableUser(String userName) {

        availableuserSet.remove(userName);
    }


}
