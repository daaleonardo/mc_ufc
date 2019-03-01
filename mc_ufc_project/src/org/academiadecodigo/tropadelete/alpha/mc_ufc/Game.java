package org.academiadecodigo.tropadelete.alpha.mc_ufc;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.Grid.GridRing;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.Directions;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.DirectionsRightFighter;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.Fighter;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.LeftFighter;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.RightFighter;


public class Game {

    private GridRing ring;
    private Picture shape;// PLAYER ON LEFT SIDE
    private Picture form; // PLAYER ON RIGHT SIDE

    private Picture armShape;
    private Picture armShape2;

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

        shape = new Picture(30, 200 -50, "Resources/fighterLeft.png");
        shape.draw();

        form = new Picture(800, 200+ 40, "Resources/fighterRight.png");
        form.draw();

        armShape = new Picture(shape.getX()+240,shape.getY()+ 120,"Resources/leftfighterglove.png");
        armShape2 = new Picture(form.getX()-60, form.getY()+ 65, "Resources/rightfighterglove.png");

        this.directionsRightFighter = DirectionsRightFighter.NODIRECTION;
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
            armShape.draw();


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

    public void punch2() {

        try {
            Thread.sleep(30);
            armShape2.draw();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resetPunch2() {

        try {
            Thread.sleep(250);
            armShape2.delete();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setDirectionsRightFighter(DirectionsRightFighter directionRightFighter) {
        this.directionsRightFighter = directionRightFighter;
    }


}
