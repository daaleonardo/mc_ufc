package org.academiadecodigo.tropadelete.alpha.mc_ufc;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.Grid.GridRing;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.Directions;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.DirectionsRightFighter;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.Fighter;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.LeftFighter;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.RightFighter;


public class Game {

    private GridRing ring;
    private Rectangle shape;// PLAYER ON LEFT SIDE
    private Rectangle form; // PLAYER ON RIGHT SIDE

    private Rectangle armShape;
    private Rectangle armShape2;

    private Directions directions;
    private DirectionsRightFighter directionsRightFighter;

    private final int FIGHTER_SIZE = 300;
    private final int ARM = 120;
    private final int JUMP = 100;
    private final int MOVEMENT = 10;


    public Game() {

        //GRID
        ring = new GridRing(120, 60);
        ring.init();

        shape = new Rectangle(30, 310, ring.getCellSize(), FIGHTER_SIZE);
        shape.fill();

        form = new Rectangle(1000, 310, ring.getCellSize(), FIGHTER_SIZE);
        form.fill();

        armShape = new Rectangle(shape.getX(), shape.getY() + 60, ARM, ring.getCellSize());
        this.directions = Directions.NODIRECTION;

        armShape2 = new Rectangle(form.getX(), form.getY() + 60, ARM, ring.getCellSize());
        this.directionsRightFighter = DirectionsRightFighter.NODIRECTION;

    }

    public void move() {

        switch (directions) {

            case RIGHT:
                if (shape.getX() >= ring.getWidth()) { // BLOCKS THE PLAYER FROM GETTING OF
                    return;
                }
                shape.translate(MOVEMENT, 0);
                armShape.translate(MOVEMENT, 0);
                break;

            case LEFT:
                if (shape.getX() <= ring.PADDING) { // BLOCKS THE PLAYER FROM GETTING OF
                    return;
                }
                shape.translate(-MOVEMENT, 0);
                armShape.translate(-MOVEMENT, 0);
                break;

            case UP:
                shape.translate(0, -JUMP);
                armShape.translate(0, -JUMP);
                try {
                    Thread.sleep(JUMP);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                shape.translate(0, JUMP);
                armShape.translate(0, JUMP);
        }

        directions = Directions.NODIRECTION;
    }

    public void move2() {

        switch (directionsRightFighter) {

            case RIGHT:
                if (form.getX() >= ring.getWidth()) { // BLOCKS THE PLAYER FROM GETTING OF
                    return;
                }
                form.translate(MOVEMENT, 0);
                armShape2.translate(MOVEMENT, 0);
                break;

            case LEFT:
                if (form.getX() <= ring.PADDING) { // BLOCKS THE PLAYER FROM GETTING OF
                    return;
                }
                form.translate(-MOVEMENT, 0);
                armShape2.translate(-MOVEMENT, 0);
                break;

            case UP:
                form.translate(0, -JUMP);
                armShape2.translate(0, -JUMP);
                try {
                    Thread.sleep(JUMP);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                form.translate(0, JUMP);
                armShape2.translate(0, JUMP);
        }

        directionsRightFighter = DirectionsRightFighter.NODIRECTION;

    }

    public void setDirections(Directions direction) {

        this.directions = direction;
    }

    public void setDirectionsRightFighter (DirectionsRightFighter directionRightFighter) {
        this.directionsRightFighter = directionRightFighter;
    }

}