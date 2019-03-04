package org.academiadecodigo.tropadelete.alpha.mc_ufc;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.Screen.StartGame;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.KeyboardListener;

public class Main {
    public static void main(String[] args) {


        StartGame startScreen = new StartGame();


        //Sound sound = new Sound(" ");

        //sound.play(true);


        Game game = new Game();

        //listener is the object that enables input on keyboard
        KeyboardListener listener = new KeyboardListener(game);

        while (!game.getGameStart()) {

            startScreen.show();
        }

        Picture controlsScreen = new Picture(10, 10, "Resources/control-screen.png");

        //sound.stop();

        controlsScreen.draw();
        startScreen.delete();

        try {
            Thread.sleep(4000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        controlsScreen.delete();


        while (true) {


            if (game.isGameEnd()) {
                game.endGame();
                break;
            }
            try {
                game.move();
                if (game.getPunchLeftFighter()) {
                    game.punch();
                    game.resetPunch();
                }
                Thread.sleep(30);
                game.move2();
                if (game.getPunchRighFighter()) {
                    game.punch2();
                    game.resetPunch2();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
