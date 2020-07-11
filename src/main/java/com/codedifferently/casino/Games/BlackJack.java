package com.codedifferently.casino.Games;

import com.codedifferently.casino.*;
import com.codedifferently.casino.Gamble;
import com.codedifferently.casino.Games.CardGame;
import com.codedifferently.casino.Player;
import com.codedifferently.casino.Utilities.*;

import java.util.ArrayList;
import java.util.Scanner;

//Complete
public class BlackJack extends CardGame 
    {

        Scanner scan = new Scanner(System.in); //To get input
        public Dealer dealer = new Dealer(); //To compare against players and take and deal money
        private int turn; //To decide the players turn
        public boolean loopedAlready = false;
        int sumChecker = 0;


        public BlackJack()
        {
            turn = 0;
        }

        public BlackJack(ArrayList<Player> players)
        {
            this.players = players;
            turn = 0;
        }


        /*Gives the player a card and sums up the point value of their hand*/
        public void hit(Player player)
        {
            deck.drawCard(player);
            setPlayerSum(player); //Will set the sum of the players hand, need to take into account an ACE card being one or eleven
        }

        /*Method so a player can double their bet mid game, needs to be worked on*/
        public void doubleDown(Player player)
        {
            dealer.bet(players.get(turn), dealer.getBetMoney()*2);
            hit(players.get(turn));
            stand();
        }

        public void stand()
        {
            turn++;
        }
       
        public boolean isBust(Player player){
           return (player.getSum() > 21);
        }

        /*Method to compare each players Value against dealer*/
        public boolean compareTo(Player player1, Player player2)
        {
            if(isBust(player1) && !isBust(player2))
            {
                return false;
            }
            else if (!isBust(player1) && isBust(player2))
            {
               return true;
            }
            else if(player1.getSum() == 21 && player2.getSum() < 21)
            {
                return true;
            }
            else if(player1.getSum() < 21 && player2.getSum() == 21)
            {
                return false;
            }
            else if(player1.getSum() > player2.getSum())
            {
                return true;
            }
            return false;
        }
        
        /*To start the game*/
        public void play()
        {
            
            System.out.println("How many rounds do you want to play, selecting 0 will make you leave the game");
           
            int rounds = scan.nextInt();
                 
            //To set players up if there are none
            if (players.size() == 0)
            {
            setPlayers();
            }
            
            //To set up for five rounds
            for(int i = 0; i < rounds;i++)
            {
                System.out.println("Starting round: "+(i+1) +" out of "+rounds);
                    setUpGame();
                   playersTurn();
                   dealersTurn();
                   gameResult();
                   resetGame();
            }

            System.out.println("Thank you for playing");

                
                       
        }
        
        /*Method to set up the game for play*/
        public void setUpGame()
    {
       
            //Sets up the bet for each player
            startingBet();
            //Deal cards to players
            dealCards();
            //Shows the board
            getBoard();
        
           
    }

    /*Sets up a viewable board with player names and handValue, need to make shorter*/
    public void getBoard()
    {
        String board = "";
        board += dealer.getName()+" the Dealer"+"\n"+"Hand is worth: "+dealer.getHand().get(0).getValue().getIntValue();
        board += "\n"+"\n";
        
        for (int i = 0; i < players.size();i++)
        {
            board += String.format("%-22s",players.get(i).getName()+" ");//Prints out all players name in a single line
           
        }
        board += "\n";
        for (int i = 0; i < players.size();i++)
        {
            players.get(i).getSum();
            board += String.format("%-22s","Hand is worth: "+players.get(i).getSum()+" ");//Prints out all players name in a single line
        }
        board += "\n";
        for (int i = 0; i < players.size();i++)
        {
            board += String.format("%-22s","Currently has $ "+players.get(i).getMoney()+" ");
        }
        

        System.out.println(board);
        
    }
    /*To initially deal two cards from a shuffled deck to each player and the dealer*/
    public void dealCards()
    {
         //If a game was already played puts the cards back in the deck
         if (deck.getDeck().size() < 52)
         {
             deck = new Deck();
         }
        deck.shuffle();
         players.add(dealer);
         for (int i = 0; i < 2;i++)
         {
             for (int j = 0; j < players.size();j++)
             {
                 hit(players.get(j));
                 
             }
         }
        
         //Will remove dealer who is always the last one added to players
         players.remove(players.size()-1);
    }

    /*To add players to the game, use 0 if continueing a game*/
    public void setPlayers()
    {
       
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
    }

    /*Method to go through every players turn and give them options depending on handValue*/
    public void playersTurn()
    {
        System.out.println("");
        for (turn = 0;turn < players.size();) //Cycles through players, turn is only increased when a player chooses to stand
        {
    
            playersChoice();
        }
           
    }
    /*Method that takes an input and gives players an action depending on that choice*/
    public void playersChoice()
    {
        if ((!isBust(players.get(turn)) && players.get(turn).getSum() != 21)) 
        {
            System.out.println("It's "+players.get(turn).getName()+" turn");
            setPlayerSum(players.get(turn));
            System.out.println("Their hand is worth: "+players.get(turn).getSum());
            System.out.println("What will they do");
            System.out.println("1: DRAW \n2: STAND \n3: Double Down \n4: Check Hand");
            
            int choice = scan.nextInt();
            System.out.println("");
            //Will hit the player and allow them to choose again if their card value is less than 21
            if (choice == 1) 
            {
                hit(players.get(turn));
                playersChoice();
            }
            //Will go to the next player in the players array
            else if (choice == 2)
            {
                stand();
            }
            //Will double the players bet, then draw one card and then stand
           else if (choice == 3)
            {
              doubleDown(players.get(turn));
            }
           else if (choice == 4)
            {
                System.out.println(players.get(turn).checkHand());
            }
            else
            {
              System.out.println("Please put in the correct options");
            }
        }
         else if (players.get(turn).getSum() == 21)
        {
            System.out.println(players.get(turn).getName()+" has 21");
            stand();
        }
        else if (isBust(players.get(turn)))
        {
            System.out.println(players.get(turn).getName()+" has busted");
            stand();
        }
        System.out.println("");
    }
    
    /*Dealers turn where they'll hit themselves until they get a value of 21*/
    public void dealersTurn()
    {
        System.out.println("It's dealers turn");

        while (dealer.getSum() < 17) //Dealer will hit till they get over 17
        {

            hit(dealer);
        }
    }

    /*Method to ask for starting bet from each player to add to the pool*/
    public void startingBet()
    {

        for (int i = 0; i < players.size();)
        {
 
            System.out.println(players.get(i).getName()+" Place a  bet: (Limit: 2 to 500)");
            int amount = scan.nextInt();
            if(amount >= 2 && amount <=500 && amount <= players.get(i).getMoney())
            {
                dealer.bet(players.get(i), amount);
                i++;
            }
            else
            {
                System.out.println("Invalid Bet.");
            }

        }
    }
    //Works but doesn't printout when dealer wins
    public void gameResult()
    {
        
        System.out.println("The dealer has: "+dealer.getSum());
        for (int i = 0; i < players.size();i++)
        {
            if (compareTo(players.get(i), dealer))
            {
              System.out.println(players.get(i).getName()+" wins");
              dealer.dealMoney(players.get(i));
            }
        
        }
        

    }

    /*Method to get rid of players hands each round*/
    public void resetGame()
    {
        players.add(dealer);
        for (int i = 0; i < players.size();i++)
        {
            for (int j = 0; j < players.get(i).getHand().size();j++)
            {
                players.get(i).getHand().clear();
            }
        }
        players.remove(players.size()-1);
        System.out.println("");
    }

    //to test the stand method
    public int getTurn(){
        return turn;
    }

  /* Adds the values from all cards in the hand to the players sum*/
  public void setPlayerSum(Player player)
  {
   
    sumChecker = 0;
    for (int i = 0; i < player.getHand().size();i++)
    {
     
      sumChecker += player.getHand().get(i).getValue().getIntValue();
    }
    
        player.setSum(sumChecker);
      if (loopedAlready == false)
      {
        checkAce(player, player.getSum());
        loopedAlready = true; 
        setPlayerSum(player);
      }
        
  }
  public void checkAce(Player player,int playerSum)
  {
    if (loopedAlready == false && playerSum > 21 )
    {
      for (int i = 0; i< player.getHand().size();i++)
      {
        if (player.getHand().get(i).getValue() == Value.ACE && player.getHand().get(i).getValue().getIntValue() == 11)
        {
          player.getHand().get(i).getValue().switchAceValue();
        }
      }
    }
   
  }
}


