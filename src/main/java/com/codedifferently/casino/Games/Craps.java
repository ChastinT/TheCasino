package com.codedifferently.casino.Games;

import com.codedifferently.casino.Gamble;
import com.codedifferently.casino.Player;
import com.codedifferently.casino.Utilities.Dice;

import java.util.ArrayList;
import java.util.Scanner;

public  class Craps implements Game, Gamble
{
     //we need two die to play craps
      public Dice firstDice = new Dice();
      public Dice secondDice = new Dice();
      public int point;
      private static String gameName;
      Scanner scan = new Scanner(System.in);

      public Craps()
      {
        gameName = "Craps";
      }

      public String getGameName()
      {
        return gameName;
      }

      public void play()
      {
        System.out.println("Hello welcome to the Craps Simulation!");
        System.out.println("Enjoy the game!");
       //Ask the user for a bet
       //Roll the dice
       //Get the first sum
        while(isGameWon());
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
          
        int x = firstDice.getSide();
        int y = secondDice.getSide();
        System.out.println("Sum: "+ (x+y));
        return x + y;
      }

      /* Note we can definetly change this method:
      */

      //method determines if game is won
      public boolean isGameWon()
      {
        //the First roll sum
        int fSum = sumOfDie();
        if(fSum == 7 || fSum == 11){ //automatic win
          return true;
        }
        if(fSum == 2 || fSum == 3 || fSum == 12){ //automatic loss
          return false;
        }
        //Otherwise keep rolling until we can match the first roll sum
        while(true){
          int secSum = sumOfDie();
          if(secSum == 7){
            return false;
          }
          if(fSum == secSum){
            return true;
          }
        }
      }
      public void rollDice()
      {
        firstDice.roll();
        secondDice.roll();
      }

      public void bet(Player player, double amount) 
      {
        player.setBet(amount);

      }

      public void dealMoney(Player player) 
      {
        player.setMoney(player.getBet());

      }
}