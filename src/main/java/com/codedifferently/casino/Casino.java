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
  ScanCatcher scan = new ScanCatcher();
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
    setPlayers(numPlayers);
  }

  public void setPlayers(int numPlayers)
  {
    for (int i = 0; i < numPlayers;i++)
    {
      System.out.println("Hello person "+(i+1));
      Player newPlayer = new Player(setPlayerName(), setPlayerMoney());
      System.out.println("");
      players.add(newPlayer);
    }
  }

  public String setPlayerName()
  {
    System.out.print("What's your name? ");
    String name = scan.next();
    if (name.equals(null) || name.equals(" "))
    {
      System.out.print("You okay?, Let me ask again");
      setPlayerName();
    }
    return name;
  }
  public double setPlayerMoney()
  {
    System.out.print("How much cash do you have on you? (In integers please): $");
    double money = scan.nextDouble();
    if (money < 2)
    {
      System.out.print("You too poor to be here, *throws a $200 worth of cash at you*");
      money += 200;
    }
    return money;
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
    walkToGame(choice);
    playAgain();
  }

  public void walkToGame(int choice)
  {
    //Complete
    if (choice == 1)
    {
      setGame(new BlackJack(players));
    }
    //Complete
    else if (choice == 2)
    {
          canIFish();
          setGame(new GoFish(players));
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
  }

  public void playAgain()
  {
    System.out.println("Would you like to play another game? \n1: Yes \n2:No");
    int choice = scan.nextInt();
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

  public void canIFish()
  {
    while (players.size() < 2)
          {
            System.out.print("Need at least 2 players. Adding a player...");
            players.add(new Player("Newbie",300)); 
          }
  }
    public static void main(String [] args)
    {
      Casino casino = new Casino();
      casino.startCasino();
    }
}
