package com.codedifferently.casino.Games;

import com.codedifferently.casino.Player;

import java.util.ArrayList;

public interface Game 
{

  /*
  public String gameName = "Game"; // Should interfaces have fields?
  ArrayList<Player> players = new ArrayList<Player>(); // or belong to classes implemented?
  */

  //returning the name of the Game.Game
  public String getGameName();
  //Checking to see if the game is won
  public boolean isGameWon(); 

  // allows the game to be played
  public void play(); 

  //returns a list of the players
  public ArrayList<Player> getPlayers(); 

  //setting the GameName to a new game
  public String changeGameName(String name);


}