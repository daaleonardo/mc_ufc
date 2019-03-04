package org.academiadecodigo.tropadelete.alpha.td_punch.directions;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.tropadelete.alpha.td_punch.Game;

public class KeyboardListener implements KeyboardHandler {

    private Game game;


    public KeyboardListener(Game game) {

        this.game = game;


        Keyboard keyboard = new Keyboard(this);


        //START GAME

        KeyboardEvent keyboardStart = new KeyboardEvent();

        keyboardStart.setKey(KeyboardEvent.KEY_SPACE);

        keyboardStart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardStart);


        /**
         * KEYS FOR
         * LEFTFIGHTER
         */


        //MOVE LEFT
        KeyboardEvent keyboardAbuttonPress = new KeyboardEvent();

        keyboardAbuttonPress.setKey(KeyboardEvent.KEY_A);

        keyboardAbuttonPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardAbuttonPress);

        //RESET LEFT
        KeyboardEvent keyboardAbuttonRelease = new KeyboardEvent();

        keyboardAbuttonRelease.setKey(KeyboardEvent.KEY_A);

        keyboardAbuttonRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(keyboardAbuttonRelease);


        //MOVE RIGHT
        KeyboardEvent keyboardDbuttonPress = new KeyboardEvent();

        keyboardDbuttonPress.setKey(KeyboardEvent.KEY_D);

        keyboardDbuttonPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardDbuttonPress);


        //RESET RIGHT
        KeyboardEvent keyboardDbuttonRelease = new KeyboardEvent();

        keyboardDbuttonRelease.setKey(KeyboardEvent.KEY_D);

        keyboardDbuttonRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(keyboardDbuttonRelease);


        //PUNCH
        KeyboardEvent keyboardRbuttonPress = new KeyboardEvent();

        keyboardRbuttonPress.setKey(KeyboardEvent.KEY_W);

        keyboardRbuttonPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardRbuttonPress);


        //RESET PUNCH
        KeyboardEvent keyboardRbuttonRelease = new KeyboardEvent();

        keyboardRbuttonRelease.setKey(KeyboardEvent.KEY_W   );

        keyboardRbuttonRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(keyboardRbuttonRelease);

        /**
         * KEYS FOR
         * RIGHTFIGHTER
         */

        //MOVE LEFT
        KeyboardEvent keyboardLeftArrow = new KeyboardEvent();

        keyboardLeftArrow.setKey(KeyboardEvent.KEY_LEFT);

        keyboardLeftArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardLeftArrow);


        //RESET LEFT
        KeyboardEvent keyboardLeftArrowRelease = new KeyboardEvent();

        keyboardLeftArrowRelease.setKey(KeyboardEvent.KEY_LEFT);

        keyboardLeftArrowRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(keyboardLeftArrowRelease);


        //MOVE RIGHT
        KeyboardEvent keyboardRightArrow = new KeyboardEvent();

        keyboardRightArrow.setKey(KeyboardEvent.KEY_RIGHT);

        keyboardRightArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardRightArrow);


        //RESET RIGHT
        KeyboardEvent keyboardRightArrowRelease = new KeyboardEvent();

        keyboardRightArrowRelease.setKey(KeyboardEvent.KEY_RIGHT);

        keyboardRightArrowRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(keyboardRightArrowRelease);


        //PUNCH
        KeyboardEvent keyboardSpacebuttonPress = new KeyboardEvent();

        keyboardSpacebuttonPress.setKey(KeyboardEvent.KEY_UP);

        keyboardSpacebuttonPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardSpacebuttonPress);


        //RESET PUNCH
        KeyboardEvent keyboardSpacebuttonRelease = new KeyboardEvent();

        keyboardSpacebuttonRelease.setKey(KeyboardEvent.KEY_UP);

        keyboardSpacebuttonRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(keyboardSpacebuttonRelease);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {


            // START GAME
            case KeyboardEvent.KEY_SPACE:
                game.start();
                break;


            // LEFT FIGHTER
            case KeyboardEvent.KEY_A:
                game.setDirections(Directions.LEFT);
                break;

            case KeyboardEvent.KEY_D:
                game.setDirections(Directions.RIGHT);
                break;

            case KeyboardEvent.KEY_W:
                if (game.isGameEnd()) {
                    break;
                }
                game.setPunchLeftFighter(true);
                break;


            // RIGHT FIGHTER
            case KeyboardEvent.KEY_LEFT:
                game.setDirectionsRightFighter(DirectionsRightFighter.LEFT);
                break;

            case KeyboardEvent.KEY_RIGHT:
                game.setDirectionsRightFighter(DirectionsRightFighter.RIGHT);
                break;

            case KeyboardEvent.KEY_UP:
                if (game.isGameEnd()) {
                    break;
                }
                game.setPunchRightFighter(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_W:
                if (game.isGameEnd()) {
                    game.deleteArm();
                    return;
                }
                game.setPunchLeftFighter(false);
                break;


            case KeyboardEvent.KEY_UP:
                if (game.isGameEnd()) {
                    game.deleteArm2();
                    return;
                }
                game.setPunchRightFighter(false);
                break;

            case KeyboardEvent.KEY_A:
            case KeyboardEvent.KEY_D:
                game.setDirections(Directions.NODIRECTION);
                break;

            case KeyboardEvent.KEY_LEFT:
            case KeyboardEvent.KEY_RIGHT:
                game.setDirectionsRightFighter(DirectionsRightFighter.NODIRECTION);
                break;
        }
    }
}
