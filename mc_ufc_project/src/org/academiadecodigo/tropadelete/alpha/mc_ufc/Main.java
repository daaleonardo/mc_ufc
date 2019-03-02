package org.academiadecodigo.tropadelete.alpha.mc_ufc;

import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.KeyboardListener;

public class Main {
    public static void main(String[] args) {


        Game game = new Game();

        //listener is the object that enables input on keyboard
        KeyboardListener listener = new KeyboardListener(game);


        while (true) {
            if (game.isLeftFighterDead() || game.isRightFighterDead()) {
                game.endGame();
                return;
            }
            try {
                Thread.sleep(30);
                game.move();
                Thread.sleep(30);
                game.move2();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
