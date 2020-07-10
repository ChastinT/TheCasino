package com.codedifferently.casino.Utilities;

import java.util.Random;

public class Dice
{
  //the side of the die we look at after rolling
  private int side; 


  //constructor for dice:
  public Dice(){
    this.side = 0; 
  }

  //getter for the side of the die
  public int getSide(){
    return this.side; 
  }
  
  //setter for the side of the die
  public void setSide(int side){
    this.side = side; 
  }
  //method to roll the 6 sided die using a random object, acts like a setter
  public void roll()
  {
    /*The number inside rand.nextInt() ranges from 0-5 then added by 1 to get a range of 1-6
      the number is different each time roll is called*/
    Random rand = new Random();
     this.side = rand.nextInt(6) + 1; 
  }


}