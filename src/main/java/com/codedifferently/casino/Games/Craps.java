package com.codedifferently.casino.Games;

import com.codedifferently.casino.Gamble;
import com.codedifferently.casino.Player;
import com.codedifferently.casino.Utilities.Dice;

import java.util.ArrayList;
import java.util.Scanner;

//Complete
public  class Craps implements Game, Gamble
{
     //we need two die to play craps
      public Dice firstDice = new Dice();
      public Dice secondDice = new Dice();
      public int point;
      public String highOrLow = "String";
      private static String gameName;
      Player shooter = new Player(); //The player that will get input from user
      ArrayList<Player> players = new ArrayList<Player>();
      private boolean gameisWon = false;
     
      
      Scanner scan = new Scanner(System.in);

      public Craps()
      {
        gameName = "Craps";
      }

      public Craps(ArrayList<Player> playerss)
      {
        this.players = playerss;
      }

      public String getGameName()
      {
        return gameName;
      }

      //Complete
      public void play()
      {
        System.out.println("Hello welcome to the Craps Simulation!");
        System.out.println("Enjoy the game!");
      //Add players to game if needed
        if (players.size() == 0)
        {
          setPlayers();
        }
  
        while(gameisWon == false)
        {
          //Ask the user for a bet,
          System.out.println(" ");
          startingBet();
          
          //Players are sorted by their roll and the first ordered player is the shooter
          System.out.println(" ");
          setUpShooter();
          System.out.println(" ");
          passOrNot();
          
          //Method to see if the shooter wins or not and continues the game if wanted
          System.out.println(" ");
          isGameWon(shooter);
          System.out.println(" ");
          continueGame();

          
        }
       
       
        
      }
      
      public void passOrNot()
      {
        for(int i = 1; i < players.size();i++)
        {
            System.out.println("Does "+players.get(i).getName()+" pass or not(Support the shooter or players(0)");
            System.out.println("1: Yes Pass, 2: No Pass");
            int choice = scan.nextInt();
            if (choice == 1 || choice == 2)
            {
              players.get(i).setPass(choice);
            }
            else
            {
              System.out.println("Please choose one of the options");
              i--;
            }
            
        }
      }
      
      public ArrayList<Player> getPlayers()
      {
          return players;
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
      
      /*To set each  players starting roll value to select who'll be the shooter*/
      public void getStartingRoll()
      {
         
       for (int i = 0; i < players.size();i++)
       {
          sumOfDie(players.get(i));
       }
      }
       
      /*method determines if game is won*/
      public boolean isGameWon(Player player)
      {
        //the First roll sum
        System.out.println(player.getName()+" needs to roll \n press any number to roll");
        int contGame = scan.nextInt(); //Doesn't do anything but stops the code till input
        int fSum = sumOfDie(player);
        if((fSum == 7 || fSum == 11 ))
        { 
          //automatic win if in favor of shooter and numbers are rolled
          shooterWins();
          return true;
        }
        else if((fSum == 2 || fSum == 3 || fSum == 12))
        { 
          //automatic loss if not in favor of shooter and numbers are rolled
          shooterLoses();
          return true;
        }
        else
        {
          //Otherwise keep rolling until we can match the first roll sum which is now the point 
          point = fSum;
          int secSum = 0;
          

          while(secSum != point)
          {
            System.out.println(shooter.getName()+" needs to roll "+point+" to win");
            System.out.println("Press any number to roll");
            contGame = scan.nextInt(); //Doesn't do anything but stops the code till input
            secSum = sumOfDie(player);
            if(secSum == 7)
            {//win if not in favor of shooter
              shooterLoses();
              return false;
            }
            if(secSum == point)
            {//win if in favor of shooter
              shooterWins();
              return true;
            }
          }
          }
          return false;
        }
        public void shooterWins()
        {
          System.out.println(players.get(0).getName()+" wins");
          dealMoney(players.get(0)); //To make sure the person who is the shooter gets their money
          for (int i = 1;i < players.size();i++)
          {
            if (players.get(i).pass() == true)
            {
              System.out.print(players.get(i).getName()+" who supported ");
              System.out.println(players.get(0).getName()+" wins $"+players.get(i).getBet()*2);
              dealMoney(players.get(i));
            }
          }
        }

      public void shooterLoses()
      {
        System.out.println(players.get(0).getName()+" loses");
        for (int i = 1;i < players.size();i++)
        {
          if (players.get(i).pass() == false)
          {
            
            System.out.print(players.get(i).getName()+" who didn't support ");
            System.out.println(players.get(0).getName()+" wins: $"+players.get(i).getBet()*2);
            dealMoney(players.get(i));
          }
        }
      }

      public boolean isGameWon() {
        for(Player eachPlayer : players) {
          if(isGameWon(eachPlayer))
            return true;
        }
        return false;
      }
      
      
      public void rollDice()
      {
        firstDice.roll();
        secondDice.roll();
      }

  /*Method to ask for starting bet from each player to add to the pool,Complete*/
  public void startingBet()
  {

      for (int i = 0; i < players.size();)
      {

          System.out.println(players.get(i).getName()+" Place a  bet: (Limit: 5 to 500)");
          int amount = scan.nextInt();
          if(amount >= 5 && amount <=500 && amount <= players.get(i).getMoney())
          {
              bet(players.get(i), amount);
              i++;
          }
          else
          {
              System.out.println("Invalid Bet.");
          }

      }
  }

      
      
      /*Rearranges the players depending on their roll, used after getStartingRoll in play method*/
      public Player decideWhoIsShooter()
      {
        
        //Sorting algorithim to sort players by their first roll
        for (int i = 0; i < players.size()-1;i++)
        {
          if (highOrLow.equals("High"))
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
          if (highOrLow.equals("Low"))
          {
            int min_idx = i;
            for (int j = i+1; j < players.size(); j++)
            {
              if (players.get(j).getDice() < players.get(min_idx).getDice())
              {
                min_idx = j; 
              }
            }
            Player temp = players.remove(min_idx); 
            players.add(i, temp); 
          }
            
        }
        
        return players.get(0);
      }
      
      public void bet(Player player, int amount) 
      {
        player.setBet(amount);

      }

      public void dealMoney(Player player) 
      {
        player.setMoney(player.getMoney()+(player.getBet()*2));

      }

      public void callHighOrLow()
      {
          System.out.println("Time to decide player order, call 1: High or 2: Low");
          int choice = scan.nextInt();
          if (choice == 1)
          {
            System.out.println("You have chosen to call high");
            highOrLow = "High";
          }
         else if (choice == 2)
          {
            System.out.println("You have chosen to call low");
            highOrLow = "Low";
          }
          else
          {
            System.out.println("Please put in the correct options");
            callHighOrLow();
          }
      }

    /*To add players to the game, use 0 if continueing a game*/
    public void setPlayers()
    {
      System.out.println("How many players to add, use 0 if continuing a game with no new players");
      int playersAdd = scan.nextInt();
      if (playersAdd != 0)
      {
          addPlayers(playersAdd); 
      }
      else if(playersAdd == 0 && players.size() == 0)
      {
          System.out.println("Sorry you can't play if you don't exist");
          setPlayers();
      }
      else
      {
          System.out.println("Continuing with current people");
      }     
    }




      
        // add one new player to a  game
    public void addPlayer() {
        Player newPlayer = new Player("Player", 500);
      players.add(newPlayer);
    }

      // add one new player to a game
      public void addPlayer(Player player) 
      {
          players.add(player);
      }

      // add a specified number of players to a game
      public void addPlayers(int numOfPlayers)
      {
          for(int i = 0; i < numOfPlayers; i++)
          {
              //Will create player with their name being their position, ie: Player 1, Player 2
              Player newPlayer = new Player("Player "+(i+1), 500);
              players.add(newPlayer);
          }
      }

      public void setUpShooter()
      {
        callHighOrLow();
        getStartingRoll();
        shooter = decideWhoIsShooter();
        System.out.println("The shooter is "+shooter.getName());
      }

      //method for testing  Craps Class
      public int getFirstDie(){
        return firstDice.getSide();
      }

      //method for testing  Craps Class
      public int getSecondDie(){
        return secondDice.getSide();
      }

      //method for testing  Craps Class
      public int getSumOfDie(Player player){
        return player.getDice();
      }


      public void continueGame()
      {
          System.out.println("Do you want to continue playing Craps 1: Yes 2:No");
          int choice = scan.nextInt();
          if(choice == 1)
          {
            System.out.println("Time for a new round");
          }
         else if(choice == 2)
          {
            System.out.println("Thank you for playing craps"); 
            gameisWon = true;
          }
      }
      
}