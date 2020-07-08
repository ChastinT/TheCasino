# StayReady-Casino
* Objective:
  * To create a casino simulation.

## Minimum Viable Product (MVP)
* Your application must have at the very least 3 games:
  * Go Fish a card game
  * BlackJack.BlackJack a card game
  * Craps.Craps a dice game

## Specs
* The project should include some concept of
  * `Player.Player` class
    * `Player.Player` objects should be created upon input from a user.
  * `Game.Game` interface
    * Contract which ensures that a class enforces some aspect of _playing_.
  * `Gamble.Gamble` interface
    * Contract which ensures that a class enforces some aspect of _waging money_.
  
 

## Developmental Notes
* Go fish is a friendly game and should not involve gambling.
* `BlackJack.BlackJack` and `GoFish.GoFish` are both Card.Card Games and should therefore inherit from a common `CardGame.CardGame`.
* Any common logic or fields between the games should live CardGame.CardGame class, **not** BlackJack.BlackJack **nor** GoFish.GoFish.
* The UML provided is missing classes, properties, and definitions required to complete this project.
* You must have a completed and approved UML diagram before you proceed to do any development
* You can either work by yourself , or in a group no bigger than 3.
* All public methods should be tested.
