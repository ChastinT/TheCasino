package com.codedifferently.casino.Games;

import com.codedifferently.casino.Player;
import com.codedifferently.casino.Utilities.Dice;

import java.util.ArrayList;

public  class Craps implements Game
{
     //we need two die to play craps
      public Dice firstDice;
      public Dice secondDice;
      private static String gameName;

      public Craps(){
        gameName = "Craps";
      }

      public String getGameName(){
        return gameName;
      }

      public void play(){
        System.out.print("Hello welcome to the Craps.Craps Simulation!");
        System.out.println("Enjoy the game!");
      }

    public ArrayList<Player> getPlayers() {
        return null;
    }

    public String changeGameName(String name) {
        return null;
    }

    //method checking the sum of the two die
      public  int sumOfDie()
      {
          firstDice.roll();
          secondDice.roll();
        int x = firstDice.getSide();
        int y = secondDice.getSide();
        return x + y;
      }

      /* Note we can definetly change this method:
      */

      //method determines if game is won
      public boolean isGameWon(){
        //the First roll sum
        int sum = sumOfDie();
        if(sum == 7 || sum == 11){ //automatic win
          return true;
        }
        if(sum == 2 || sum == 3 || sum == 12){ //automatic loss
          return false;
        }
        //Otherwise keep rolling until we can match the first roll sum
        while(true){
          int sum2 = sumOfDie();
          if(sum2 == 7){
            return false;
          }
          if(sum == sum2){
            return true;
          }
        }
      }
}