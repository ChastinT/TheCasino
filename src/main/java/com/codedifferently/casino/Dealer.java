package com.codedifferently.casino;

    public class Dealer extends Player implements Gamble
    {

        private int betMoney;
        private int sum;

        public Dealer()
        {
            super("John", 1500);
            betMoney = 0;
        }

        public void bet(Player player, int amount)
        {
            player.setMoney(player.getMoney()-amount);
            betMoney += amount;
            player.setBet(amount);
        }

        public int getBetMoney()
        {
            return betMoney;
        }

        public void dealMoney(Player player) 
        {
            player.setMoney(player.getMoney()+(player.getBet()*2));
        }

        public int getSum()
        {
          return sum;
        }

    }
