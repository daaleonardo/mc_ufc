package org.academiadecodigo.tropadelete.alpha.mc_ufc.directions;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.Game;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.Fighter;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.LeftFighter;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.RightFighter;


public class KeyboardListener implements KeyboardHandler {

    private Game game;


    public KeyboardListener(Game game) {

        this.game = game;

        Keyboard keyboard = new Keyboard(this);

        /**
         * KEYS FOR
         * LEFTFIGHTER
         */


        //MOVE LEFT
        KeyboardEvent keyboardAbuttonPress = new KeyboardEvent();

        keyboardAbuttonPress.setKey(KeyboardEvent.KEY_A);

        keyboardAbuttonPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardAbuttonPress);


        //MOVE RIGHT
        KeyboardEvent keyboardDbuttonPress = new KeyboardEvent();

        keyboardDbuttonPress.setKey(KeyboardEvent.KEY_D);

        keyboardDbuttonPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardDbuttonPress);


        //PUNCH
        KeyboardEvent keyboardRbuttonPress = new KeyboardEvent();

        keyboardRbuttonPress.setKey(KeyboardEvent.KEY_R);

        keyboardRbuttonPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardRbuttonPress);


        //RESET PUNCH
        KeyboardEvent keyboardRbuttonRelease = new KeyboardEvent();

        keyboardRbuttonRelease.setKey(KeyboardEvent.KEY_R);

        keyboardRbuttonRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(keyboardRbuttonRelease);


        //MOVE UP
        KeyboardEvent keyboardWArrowPress = new KeyboardEvent();

        keyboardWArrowPress.setKey(KeyboardEvent.KEY_W);

        keyboardWArrowPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardWArrowPress);

        /**
         * KEYS FOR
         * RIGHTFIGHTER
         */

        //MOVE LEFT
        KeyboardEvent keyboardLeftArrow = new KeyboardEvent();

        keyboardLeftArrow.setKey(KeyboardEvent.KEY_LEFT);

        keyboardLeftArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardLeftArrow);


        //MOVE RIGHT
        KeyboardEvent keyboardRightArrow = new KeyboardEvent();

        keyboardRightArrow.setKey(KeyboardEvent.KEY_RIGHT);

        keyboardRightArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardRightArrow);


        //PUNCH
        KeyboardEvent keyboardSpacebuttonPress = new KeyboardEvent();

        keyboardSpacebuttonPress.setKey(KeyboardEvent.KEY_SPACE);

        keyboardSpacebuttonPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardSpacebuttonPress);


        //RESET PUNCH
        KeyboardEvent keyboardSpacebuttonRelease = new KeyboardEvent();

        keyboardSpacebuttonRelease.setKey(KeyboardEvent.KEY_SPACE);

        keyboardSpacebuttonRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(keyboardSpacebuttonRelease);


        //MOVE UP
        KeyboardEvent keyboardUpArrowPress = new KeyboardEvent();

        keyboardUpArrowPress.setKey(KeyboardEvent.KEY_UP);

        keyboardUpArrowPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardUpArrowPress);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {


            // LEFT FIGHTER
            case KeyboardEvent.KEY_A:
                game.setDirections(Directions.LEFT);
                break;

            case KeyboardEvent.KEY_D:
                game.setDirections(Directions.RIGHT);
                break;

            case KeyboardEvent.KEY_W:
                game.setDirections(Directions.UP);
                break;

            case KeyboardEvent.KEY_R:
                game.punch();
                break;


            // RIGHT FIGHTER
            case KeyboardEvent.KEY_LEFT:
                game.setDirectionsRightFighter(DirectionsRightFighter.LEFT);
                break;

            case KeyboardEvent.KEY_RIGHT:
                game.setDirectionsRightFighter(DirectionsRightFighter.RIGHT);
                break;

            case KeyboardEvent.KEY_UP:
                game.setDirectionsRightFighter(DirectionsRightFighter.UP);
                break;

            case KeyboardEvent.KEY_SPACE:
                game.punch2();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

       switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_R:
                game.resetPunch();
                break;



            case KeyboardEvent.KEY_SPACE:
                game.resetPunch2();
                break;
        }
    }
}
