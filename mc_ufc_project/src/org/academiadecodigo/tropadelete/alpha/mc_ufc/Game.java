package org.academiadecodigo.tropadelete.alpha.mc_ufc;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.Grid.Grid;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.Grid.GridRing;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.Directions;


public class Game {

    private GridRing ring;
    private Rectangle shape;
    private Rectangle armShape;
    private Directions directions;

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

        armShape = new Rectangle(shape.getX(), shape.getY() + 60, ARM, ring.getCellSize());
        this.directions = Directions.NODIRECTION;

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


    public void punch() {

        try {
            Thread.sleep(30);
            armShape.fill();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resetPunch() {

        try {
            Thread.sleep(250);
            armShape.delete();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setDirections(Directions direction) {

        this.directions = direction;
    }
}
