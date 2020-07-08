package com.codedifferently.casino;

    public class Dealer extends Player implements Gamble
    {

        private double betMoney;

        public Dealer()
        {
            super("John", 1500);
            betMoney = 0;
        }

        //Created an add to player to add card dealt to
        public void deal(Player player, int cardCount)
        {

        }

        public void bet(Player player, int amount)
        {
            player.setMoney(player.getMoney()-amount);
            betMoney += amount;
        }

        public void dealMoney(Player player, double amount)
        {

        }

        public void dealMoney(Player player)
        {
          player.setMoney(player.getMoney()+betMoney);
        }

    }
