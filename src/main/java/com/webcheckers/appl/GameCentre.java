package com.webcheckers.appl;

/**
 * Author: Ashish, Diego
 */

import com.webcheckers.model.Game;
import com.webcheckers.model.Player;

import java.util.*;

public class GameCentre {

    public  static Map<String, Player> userPlayerMap ;

    private  static Set<String> userSet;

    public Set<String> getAvailableuserSet() {
        return availableuserSet;
    }

    private  Set<String> availableuserSet;


    private  static Set<Game> gameList;


    public GameCentre(){

        userPlayerMap = new HashMap<>();
        userSet = new HashSet<>();
        gameList = new HashSet<>();
        availableuserSet = new HashSet<>();
    }


    public  boolean isUserAvailable(String userName){
        return userSet.contains(userName)?false:true;
    }

    public  void addUser(String userName){
        userSet.add(userName);
    }
    public  void removeUser(String userName){
        userSet.remove(userName);
    }

    public  Player getPlayer(String userName){
        Player player = null;

        for(String user: userPlayerMap.keySet()){

            if(userName.equalsIgnoreCase(user)){
                player = userPlayerMap.get(user);
            }

        }
        return player;
    }

    public  Game getPlayerGame(Player player){

        System.out.println("########"+ player.toString());


       return gameList.stream().filter(game -> game.getPlayer().getPlayerName().equalsIgnoreCase(player.getPlayerName()) ||
                game.getOpponent().getPlayerName().equalsIgnoreCase(player.getPlayerName())).findFirst().get();

    }

    public void setUserPlayerMap(String playerName, Player player){

        userPlayerMap.put(playerName,player);
    }

    public void addAvailableUser(String userName){

        availableuserSet.add(userName);

    }

    public void addGame(Game game){
        gameList.add(game);
    }

    public void updateGame(Player player, Game game){
        gameList.remove(getPlayerGame(player));
        gameList.add(game);
    }

    public void removeGame(Game game){
        gameList.remove(game);
    }

    public void removeAvailableUser(String userName){

        availableuserSet.remove(userName);
    }



}
