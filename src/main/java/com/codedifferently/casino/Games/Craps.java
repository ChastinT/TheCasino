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
      public String highOrLow = "";
      private static String gameName;
      ArrayList<Player> players = new ArrayList<Player>();
      
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
        
      }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public String changeGameName(String name) {
        return null;
    }

    //method checking the sum of the two die
      public  int sumOfDie(Player player)
      {
          rollDice();
        int x = firstDice.getSide();
        int y = secondDice.getSide();
        player.setDice(x + y);
        System.out.println(player.getName()+" Has rolled a sum of: "+ player.getDice());
        return player.getDice();
      }

      /* Note we can definetly change this method:
      */

      /*method determines if game is won
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
      */
      public void rollDice()
      {
        firstDice.roll();
        secondDice.roll();
      }

      public void startBet()
      {
        for (int i = 0; i < players.size();i++)
        {
          players.get(i).setBet(scan.nextInt());
        }
      } 

      /*Rearranges the players depending on their roll*/
      public void decideWhoIsFirst()
      {
        //To set each  players starting roll value
       for (int i = 0; i < players.size();i++)
       {
          sumOfDie(players.get(i));
       }
        
        //Sorting algorithim to sort players by their first roll
        for (int i = 0; i < players.size()-1;i++)
        {
          int max_idx = i;
          for (int j = i+1; j < players.size(); j++)
          {
            if (players.get(j).getDice() > players.get(max_idx).getDice())
            {
              max_idx = j; 
            }
          }

          Player temp = players.remove(max_idx); 
            players.add(i, temp); 
            
        }
      }
      public void bet(Player player, int amount) 
      {
        player.setBet(amount);

      }

      public void dealMoney(Player player) 
      {
        player.setMoney(player.getBet());

      }

      public boolean isGameWon() {
        // TODO Auto-generated method stub
        return false;
      }
}