package com.codedifferently.casino.Games;

import com.codedifferently.casino.Dealer;
import com.codedifferently.casino.Gamble;
import com.codedifferently.casino.Games.CardGame;
import com.codedifferently.casino.Player;
import com.codedifferently.casino.Utilities.Card;
import com.codedifferently.casino.Utilities.Deck;
import com.codedifferently.casino.Utilities.Value;

import java.util.Scanner;


public class BlackJack extends CardGame 
    {

        public Dealer dealer = new Dealer();
        private int turn = 0;

        public BlackJack()
        {

        }


        /*Gives the player a card and sums up the point value of their hand*/
        public void hit(Player player)
        {
            Card card = deck.drawCard(player);
            player.setSum();
        }

        /*Method so a player can double their bet mid game, needs to be worked on*/
        public void doubleDown(Player player)
        {
            hit(player);
            hit(player);
        }

        public void stand()
        {
            turn++;
            if (turn >= players.size())
            {
                turn = 0;
            }
        }
       
        public boolean isBigger21(Player player){
           return (player.getSum() > 21);
        }

        public boolean compareTo(Player player1, Player player2){
            if(isBigger21(player1) && !isBigger21(player2)){
                return false;
            }
            else if (!isBigger21(player1) && isBigger21(player2)){
               return true;
            }
            else if(player1.getSum() == 21 && player2.getSum() < 21){
                return true;
            }
            else if(player1.getSum() < 21 && player2.getSum() == 21){
                return false;
            }
            else if(player1.getSum() > player2.getSum()){
                return true;
            }
            return false;
        }
        
        public void play()
        {
            //setUpGame();
            Scanner scan = new Scanner(System.in);
            while(this.isGameWon() == false)
                {
                    System.out.println(dealer.getHand().get(0).getValue().getIntValue());
                    for (int a = 0; a < players.size();a++)
                    {
                      System.out.print(players.get(a).getName()+"/n"+ players.get(a).getHand());
                    }
                    
                   
                        if (players.get(turn).equals(dealer)) //Will decide dealers actions
                        {
                            
                        }
                        
                    }
                    /*  if(player1.getSum() == player2.getSum()){
                
                        }
                        else{
                            compareTo(player1, player2)
                        }*/
                }
        

        public void setUpGame()
    {
            //If a game was already played puts the cards back in the deck
            if (deck.getDeck().size() < 52)
            {
                deck = new Deck();
            }
            deck.shuffle();
            //Selecting how many players
            setPlayers();
            dealCards();
           
    }
    /*Sets up a viewable board with player names and handValue, need to make shorter*/
    public void getBoard()
    {
        System.out.println(dealer.getName()+" the Dealer"+"\n"+"Hand is worth: "+dealer.getHand().get(0).getValue().getIntValue());

        for (int i = 0; i < players.size();i++)
        {
            System.out.println(players.get(i).getName()+"\n"+"Hand is worth: "+players.get(i).getSum());
        }
        
    }
    /*To initially deal two cards from a shuffled deck to each player and the dealer*/
    public void dealCards()
    {
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

    public void setPlayers()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many players to add");
            int playersAdd = scan.nextInt();
            addPlayers(playersAdd);
           
    }

    /*Method to go through every players turn and give them options depending on handValue*/
    public void playersTurn()
    {
        Scanner scan = new Scanner(System.in);
        for (;turn < players.size();)
        {
            System.out.println("It's "+players.get(turn).getName()+" turn");
            System.out.println("What will they do");
            if (players.get(turn).getSum() < 21) 
            {
                System.out.println("1: DRAW"+" 2: STAND"+ " 3: Double Down");
                int choice = scan.nextInt();

                if (choice == 1)
                {
                    hit(players.get(turn));
                    scan.close();
                    playersTurn();
                }
                if (choice == 2)
                {
                    stand();
                }
                if (choice == 3)
                {

                }
            }
            else
            {
                stand();
            }
        }
    }

    public void dealersTurn()
    {

    }



    
        
}