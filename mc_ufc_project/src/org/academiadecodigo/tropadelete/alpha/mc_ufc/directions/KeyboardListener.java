package org.academiadecodigo.tropadelete.alpha.mc_ufc.directions;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.Game;


public class KeyboardListener implements KeyboardHandler {

    private Game game;

    public KeyboardListener(Game game) {
        this.game = game;

        Keyboard keyboard = new Keyboard(this);

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
        KeyboardEvent keyboardZbuttonPress = new KeyboardEvent();

        keyboardZbuttonPress.setKey(KeyboardEvent.KEY_Z);

        keyboardZbuttonPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardZbuttonPress);


        //RESET PUNCH
        KeyboardEvent keyboardZbuttonRelease = new KeyboardEvent();

        keyboardZbuttonRelease.setKey(KeyboardEvent.KEY_Z);

        keyboardZbuttonRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(keyboardZbuttonRelease);


        //MOVE UP
        KeyboardEvent keyboardUpArrowPress = new KeyboardEvent();

        keyboardUpArrowPress.setKey(KeyboardEvent.KEY_UP);

        keyboardUpArrowPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardUpArrowPress);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_LEFT:
                game.setDirections(Directions.LEFT);
                break;

            case KeyboardEvent.KEY_RIGHT:
                game.setDirections(Directions.RIGHT);
                break;

            case KeyboardEvent.KEY_UP:
                game.setDirections(Directions.UP);
                break;

            case KeyboardEvent.KEY_Z:
                game.punch();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_Z:
                game.resetPunch();
                break;
        }
    }
}
