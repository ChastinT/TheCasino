package com.codedifferently.casino.Utilities;

public class Dice
{
  //the side of the die we look at after rolling
  private int side; 
  //making sure we create a random number to get sides of the die
  protected double random = Math.random();

  //constructor for dice:
  public Dice(){
    this.side = 0; 
  }

  //getter for the side of the die
  public int getSide(){
    return this.side; 
  }
  
  //method to roll the 6 sided die, acts like a setter
  public void roll(){
     this.side = (int)random*6 + 1;
  }


}