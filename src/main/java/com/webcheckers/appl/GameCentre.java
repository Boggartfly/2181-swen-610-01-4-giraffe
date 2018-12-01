package com.webcheckers.appl;

/**
 * Author: Ashish, Diego
 */

import com.webcheckers.model.Game;
import com.webcheckers.model.Move;
import com.webcheckers.model.Player;

import java.util.*;

public class GameCentre {

    public static Map<String, Player> userPlayerMap;

    private static Set<String> userSet;
    private static Set<Game> gameList;
    private Set<String> availableuserSet;

    private  Map<Player, List<Move>> playerMoves;


    public GameCentre() {

        userPlayerMap = new HashMap<>();
        userSet = new HashSet<>();
        gameList = new HashSet<>();
        availableuserSet = new HashSet<>();
        playerMoves = new HashMap<>();
    }

    public Set<String> getAvailableuserSet() {
        return availableuserSet;
    }

    public void addPlayerMove(Player player, Move move) {

        if (playerMoves.get(player) == null) {

            List<Move> moves = new ArrayList<>();
            moves.add(move);

            playerMoves.put(player, moves);
        } else {
            playerMoves.get(player).add(move);
        }


    }

    public Move getPlayerMove(Player player) {

        if(playerMoves.get(player)!=null) {

            return playerMoves.get(player).stream().findFirst().get();
        }else
            return null;
    }

    public void removePlayerMove(Player player, Move move) {

        playerMoves.get(player).
                remove(playerMoves.get(player).stream().filter(move1 -> move1.getStart() == move.getStart() && move1.getEnd() == move.getEnd()).findFirst().get());

    }

    public void removePlayerMoves(Player player){

        playerMoves.put(player,null);

    }

    public List<Move> getPlayerMoves(Player player){

        return playerMoves.get(player);
    }


    public boolean isUserAvailable(String userName) {
        return !userSet.contains(userName);
    }

    public void addUser(String userName) {
        userSet.add(userName);
    }

    public void removeUser(String userName) {
        userSet.remove(userName);
    }

    public Player getPlayer(String userName) {
        Player player = null;

        for (String user : userPlayerMap.keySet()) {

            if (userName.equalsIgnoreCase(user)) {
                player = userPlayerMap.get(user);
            }

        }
        return player;
    }

    public Game getPlayerGame(Player player) {

        System.out.println("########" + player.toString());


        return gameList.stream().filter(game -> game.getPlayer().getPlayerName().equalsIgnoreCase(player.getPlayerName()) ||
                game.getOpponent().getPlayerName().equalsIgnoreCase(player.getPlayerName())).findFirst().get();

    }

    public String getPlayerType(Player player) {
        if (gameList.stream().anyMatch(game -> game.getPlayer().getPlayerName().equalsIgnoreCase(player.getPlayerName()))) {
            return "player";
        } else if (gameList.stream().anyMatch(game -> game.getOpponent().getPlayerName().equalsIgnoreCase(player.getPlayerName()))) {
            return "opponent";
        } else {
            return null;
        }
    }

    public void setUserPlayerMap(String playerName, Player player) {

        userPlayerMap.put(playerName, player);
    }

    public void addAvailableUser(String userName) {

        availableuserSet.add(userName);

    }

    public void addGame(Game game) {
        gameList.add(game);
    }

    public void updateGame(Player player, Game game) {
        gameList.remove(getPlayerGame(player));
        gameList.add(game);
    }

    public void removeGame(Game game) {
        gameList.remove(game);
    }

    public void removeAvailableUser(String userName) {

        availableuserSet.remove(userName);
    }


}
