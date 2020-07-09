package com.codedifferently.casino.Games;

import com.codedifferently.casino.Dealer;
import com.codedifferently.casino.Games.CardGame;
import com.codedifferently.casino.Player;
import com.codedifferently.casino.Utilities.Card;
import com.codedifferently.casino.Utilities.Value;

import java.util.Scanner;


public class BlackJack extends CardGame
    {

        private Dealer dealer;


        
        public void hit(Player player)
        {
            Card card = deck.drawCard(player);
            player.setSum(card.getValue().getIntValue());
        }

        public void doubleDown(Player player)
        {
            hit(player);
            hit(player);
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
            deck.shuffle();
            //Selecting how many players
            Scanner scan = new Scanner(System.in);
            int choice = 0;

            System.out.println("How many players to add");
            int playersAdd = scan.nextInt();
            addPlayers(playersAdd);
            addPlayer(dealer); //To add the dealer

            //To initially deal two cards to each player and the dealer
            for (int i = 0; i < 2;i++)
            {
                for (int j = 0; j < players.size();j++)
                {
                
                    players.get(j).setSum(deck.drawCard(players.get(j)).getValue().getIntValue());
                }
            }

            while(this.isGameWon() == false)
                {
                    System.out.println(dealer.getHand().get(0).getValue().getIntValue());
                    for (int a = 0; a < players.size();a++)
                    {
                      System.out.print(players.get(a).getName()+"/n"+ players.get(a).getHand());
                    }
                    /*  if(player1.getSum() == player2.getSum()){
                
                        }
                        else{
                            compareTo(player1, player2)
                        }*/
                }
        }
        
}