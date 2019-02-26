package org.academiadecodigo.tropadelete.alpha.mc_ufc;

import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.Fighter;

public class Game {

    private Fighter fighter;
    private Fighter fighter1;

    public Game(Fighter fighter, Fighter fighter1){

    }

    public void start() {

        while (!fighter.isDead() || !fighter1.isDead()) {

            fighter.hit(fighter1);
            System.out.println("Player Two Health: " + fighter1.getHealth());
            if (fighter1.isDead()) {
                System.out.println("Player One Wins");
                break;
            }

            fighter1.hit(fighter);
            System.out.println("Player One Health; " + fighter.getHealth());
            if (fighter.isDead()) {
                System.out.println("Player Two Wins.");
                break;
            }
        }
    }

}
