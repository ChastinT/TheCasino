package com.codedifferently.casino.Utilities;

import com.codedifferently.casino.Utilities.Dice;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class DiceTest
{

        @Test
        public void constructorTest() {
                // Given
                int expectedSide = 0;
                
                // When
                Dice dice = new Dice();
                int actualSide = dice.getSide();

                // Then
                Assert.assertEquals(expectedSide, actualSide);
        }
        
        Dice dice;
        @Before
        public void initialize()
        {
                dice = new Dice();
        }

        //Test for dice roll and getSide methods
        @Test
        public void rollSideTest()
        {
                dice.roll();
                if (dice.getSide() == 0)
                {

                    System.out.println("Dice.getRoll() doesn't work");
                }
                else
                {
                        System.out.println("Dice.getRoll() works");
                }
        }

        @Test
        public void getSideTest() {
                // Given
                int expectedSide = 4;
                dice.setSide(expectedSide);
                
                // When
                int actualSide = dice.getSide();
                
                // Then
                Assert.assertEquals(expectedSide, actualSide);
        }

        @Test
        public void setSideTest() {
                // Given
                int expectedSide = 3;
                
                // When
                dice.setSide(expectedSide);
                int actualSide = dice.getSide();
                
                // Then
                Assert.assertEquals(expectedSide, actualSide);
        }

}