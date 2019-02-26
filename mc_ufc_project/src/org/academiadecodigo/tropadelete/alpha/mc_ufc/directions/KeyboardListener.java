package org.academiadecodigo.tropadelete.alpha.mc_ufc.directions;

import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.Game;


public class KeyboardListener implements KeyboardHandler {

    private Game game;
    private Keyboard keyboard;

    public KeyboardListener(Game game) {
        this.game = game;

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent keyboardLeftArrow = new KeyboardEvent();

        keyboardLeftArrow.setKey(KeyboardEvent.KEY_LEFT);

        keyboardLeftArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardLeftArrow);




        KeyboardEvent keyboardRightArrow = new KeyboardEvent();

        keyboardRightArrow.setKey(KeyboardEvent.KEY_RIGHT);

        keyboardRightArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardRightArrow);

    }

    public void Left(){

        KeyboardEvent keyboardLeft = new KeyboardEvent();

       keyboardLeft.setKey(KeyboardEvent.KEY_LEFT);

        keyboardLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardLeft);

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
               // case KeyboardEvent.KEY_0:
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
