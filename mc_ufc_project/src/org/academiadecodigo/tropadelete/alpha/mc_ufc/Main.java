package org.academiadecodigo.tropadelete.alpha.mc_ufc;

import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.Fighter;

public class Main {
    public static void main(String[] args) {
        Fighter fighter = new Fighter(100);
        Fighter fighter1 = new Fighter(100);
       Game game = new Game(fighter, fighter1);

       game.start();
    }
}
