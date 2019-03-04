package org.academiadecodigo.tropadelete.alpha.mc_ufc;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.Screen.EndGame;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.Screen.StartGame;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.KeyboardListener;

public class Main {
    public static void main(String[] args) {

        Sound sound = new Sound("/Resources/soundfx/boxing-ring-sound.wav");
        Sound sound1 = new Sound("/Resources/soundfx/burningHeart.wav");
        Sound sound2 = new Sound("/Resources/soundfx/victory.wav");


        StartGame startScreen = new StartGame();


        //Sound sound = new Sound(" ");

        //sound.play(true);


        Game game = new Game();

        //listener is the object that enables input on keyboard
        KeyboardListener listener = new KeyboardListener(game);

        sound1.play(true);
        while (!game.getGameStart()) {

            startScreen.show();
        }


        Picture controlsScreen = new Picture(10, 10, "Resources/screen/game-controls.png");


        controlsScreen.draw();
        startScreen.delete();

        try {
            Thread.sleep(4000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        controlsScreen.delete();


        sound1.stop();
        sound.play(true);
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

                //sound.stop();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        EndGame endGame = new EndGame();

        sound2.play(true);

        if (game.isRightFighterDead()) {
            endGame.redNeck();
            System.exit(0);
        }
        endGame.latino();
        System.exit(0);
    }
}
