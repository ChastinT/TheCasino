package com.codedifferently.casino;


import com.codedifferently.casino.Games.Game;

public class Casino
{
  //I'm going to create an account for the casino storing the money 
  private String casinoName; 
  private Double casinoAccount = 500000000.00; 


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
  
  //not sure what this does exactly
  public Game playGame(Game game){
    return game; 
  }
  
  //is this necessary?? Because of the interface
  /*
  public String changeGame(Game gameName)
  {
    return gameName; 
  }
  */



}
