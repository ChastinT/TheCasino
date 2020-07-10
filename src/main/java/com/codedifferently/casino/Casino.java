package com.codedifferently.casino;

import java.util.Scanner;

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
  


  public Casino(Double money){
    this.casinoName = "The Casino";
    this.casinoAccount = money;  
  }

  public Casino(){
    this.casinoName = "The Casino"; 
  }

  public void setCasinoName(String name){
    this.casinoName = name;
  }

  public String getCasinoName(){
    return this.casinoName;

  }

  public void removeCasinoMoney(double removal){
    if(this.casinoAccount >= removal){
      System.out.println("Not enough money to give player");
    } else {
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
    
    System.out.println("\nWelcome to the Casino \nWhat games would you like to play");
    System.out.println("1: BlackJack \n2: Go Fish \n3: Craps");
    int choice = scan.nextInt();
    //Complete
    if (choice == 1)
    {
      setGame(new BlackJack());
    }
    /*Needs more testing*/
    else if (choice == 2)
    {
      System.out.println("How many players for GoFish");
      setGame(new GoFish(scan.nextInt()));
    }
    /*Needs more work done*/
    else if (choice == 3)
    {
      setGame(new Craps());
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
    public static void main(String [] args)
    {
      Casino casino = new Casino();
      casino.chooseGame();
    }
}
