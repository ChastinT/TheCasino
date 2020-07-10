package com.codedifferently.casino.Games;

import com.codedifferently.casino.Player;

import java.util.ArrayList;

public interface Game 
{

  public String gameName = "Game";
  public boolean gameisWon = false;

  //returning the name of the Game.Game
 // public String getGameName();
  //Checking to see if the game is won
  public boolean isGameWon();

  // allows the game to be played
  public void play(); 

  //returns a list of the players
  public ArrayList<Player> getPlayers(); 


}