package com.codedifferently.casino;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import com.codedifferently.casino.Games.*;

public class Casino
{
  //I'm going to create an account for the casino storing the money 
  private String casinoName; 
  private Double casinoAccount = 500000000.00; 
  Scanner scan = new Scanner(System.in);
  Game game;
  BlackJack blackJack = new BlackJack();
  GoFish goFish = new GoFish();
  Craps craps = new Craps();
  ArrayList <Player> players = new ArrayList<Player>();

  public void playersEnterCasino()
  {
    System.out.println("Welcome to the Casino!");
    System.out.println("How many people are we expecting today");
    int numPlayers = scan.nextInt();
    if (numPlayers == 0)
    {
      System.out.println("You okay? \n Let's start over");
      playersEnterCasino();
    }
    for (int i = 0; i < numPlayers;i++)
    {
      System.out.println("Hello person "+(i+1));
      System.out.print("What's your name? ");
      String name = scan.next();
      
      System.out.print("How much cash do you have on you? (In integers please): $");
      double money = scan.nextDouble();
      if (money < 2)
      {
        System.out.print("You too poor to be here, *throws a $100 worth of cash at you*");
        money += 100;
      }
     
      System.out.println("");
      
      Player newPlayer = new Player(name, money);
      players.add(newPlayer);


    }
  }


  public Casino(Double money)
  {
    this.casinoName = "The Casino";
    this.casinoAccount = money;  
  }

  public Casino()
  {
    this.casinoName = "The Casino"; 
  }

  public void setCasinoName(String name){
    this.casinoName = name;
  }

  public String getCasinoName(){
    return this.casinoName;

  }

  public void removeCasinoMoney(double removal)
  {
    if(this.casinoAccount >= removal)
    {
      System.out.println("Not enough money to give player");
    } else 
    {
    this.casinoAccount -= removal; 
    } 
  }

  public void addCasinoMoney(double addition){
    this.casinoAccount += addition; 
  }
  
  
  private void playGame()
  {
    if (game != null)
    {
    game.play(); 
    }
    else
    {
      System.out.println("You haven't chosen a game yet");
    }
  }

  public void setGame(Game game)
  {
    this.game = game;
    playGame();
  }

  public void giveDealer(Dealer dealer)
  {
    dealer.setMoney(1500);
    removeCasinoMoney(1500);
  }

 

  public void chooseGame()
  {
    
    System.out.println("What games would you like to play, anything else other than these choices will make you leave");
    System.out.println("1: BlackJack \n2: Go Fish \n3: Craps");
    int choice = scan.nextInt();
    //Complete
    if (choice == 1)
    {
      setGame(new BlackJack(players));
    }
    //Complete
    else if (choice == 2)
    {
      //System.out.println("How many players for GoFish");
      boolean passed = false;
      while(!passed) { 
        try{
          int numOfPlayers = players.size();
          while(numOfPlayers < 2)
          {
            System.out.print("Need at least 2 players. Adding a player...");
            players.add(new Player("Newbie",300)); 
            numOfPlayers = players.size();
          }
          setGame(new GoFish(players));
          passed = true; 
        } catch (InputMismatchException e){
          System.out.print("Invalid Number. Please enter an integer: " + e);
          scan.nextLine();
        }
      }
      
    }
    //Complete
    else if (choice == 3)
    {
      setGame(new Craps(players));
    }
    else
    {
      System.out.println("Don't be silly choose a game");
      chooseGame();
    }
    System.out.println("Would you like to play another game? \n1: Yes \n2:No");
    choice = scan.nextInt();
    if (choice == 1)
    {
      chooseGame();
    }
    else
    {
      System.out.println("Thank you so much for visiting the Casino, your money is in safe hands");
    }


  }

  public void startCasino()
  {
    playersEnterCasino();
    chooseGame();
  }
    public static void main(String [] args)
    {
      Casino casino = new Casino();
      casino.startCasino();
    }
}
