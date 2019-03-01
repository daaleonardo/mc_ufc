package org.academiadecodigo.tropadelete.alpha.mc_ufc;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.Grid.GridRing;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.Directions;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.DirectionsRightFighter;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.Fighter;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.LeftFighter;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.RightFighter;


public class Game {

    private GridRing ring;

    private Picture leftFighterArm;
    private Picture rightFighterArm;

    private Directions directions;
    private DirectionsRightFighter directionsRightFighter;

    private final int FIGHTER_SIZE = 300;
    private final int ARM = 120;
    private final int JUMP = 100;
    private final int MOVEMENT = 10;

    private Fighter leftFighter;
    private Fighter rightFighter;

    public Game() {

        //GRID
        ring = new GridRing(120, 60);
        ring.init();

        leftFighter = new LeftFighter(100, 30);
        ((LeftFighter) leftFighter).draw();

        rightFighter = new RightFighter(100, 700);
        ((RightFighter) rightFighter).draw();


        //leftFighterArm = new Picture(leftFighter.getX() + 240, leftFighter.getY(), "Resources/leftfighterglove.png");
        //rightFighterArm = new Picture(rightFighter.getX() + 40, rightFighter.getY(), "Resources/rightfighterglove.png");

        this.directionsRightFighter = DirectionsRightFighter.NODIRECTION;
        this.directions = Directions.NODIRECTION;

    }

    public void move() {

        switch (directions) {

            case RIGHT:
                if (leftFighter.getX() >= ring.getWidth()) { // BLOCKS THE PLAYER FROM GETTING OF
                    return;
                }
                ((LeftFighter) leftFighter).getShape().translate(MOVEMENT, 0);
                ((LeftFighter) leftFighter).getLeftFighterArm().translate(MOVEMENT, 0);
                break;

            case LEFT:
                if (leftFighter.getX() <= ring.PADDING) { // BLOCKS THE PLAYER FROM GETTING OF
                    return;
                }
                ((LeftFighter) leftFighter).getShape().translate(-MOVEMENT, 0);
                ((LeftFighter) leftFighter).getLeftFighterArm().translate(-MOVEMENT, 0);
                break;

            case UP:
                ((LeftFighter) leftFighter).getShape().translate(0, -JUMP);
                ((LeftFighter) leftFighter).getLeftFighterArm().translate(0, -JUMP);
                try {
                    Thread.sleep(JUMP);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ((LeftFighter) leftFighter).getShape().translate(0, JUMP);
                ((LeftFighter) leftFighter).getLeftFighterArm().translate(0, JUMP);
        }

        directions = Directions.NODIRECTION;
    }

    public void punch() {
        ((LeftFighter) leftFighter).punch();
    }

    public void resetPunch() {
        ((LeftFighter) leftFighter).resetPunch();
    }


    public void setDirections(Directions direction) {

        this.directions = direction;
    }

    public void move2() {

        switch (directionsRightFighter) {

            case RIGHT:
                if (rightFighter.getX() >= ring.getWidth()) { // BLOCKS THE PLAYER FROM GETTING OF

                    return;
                }
                ((RightFighter) rightFighter).getShape().translate(MOVEMENT, 0);
                ((LeftFighter) leftFighter).getLeftFighterArm().translate(MOVEMENT, 0);
                break;

            case LEFT:
                if (rightFighter.getX() <= ring.PADDING) { // BLOCKS THE PLAYER FROM GETTING OF
                    return;
                }
                ((RightFighter) rightFighter).getShape().translate(-MOVEMENT, 0);
                ((LeftFighter) leftFighter).getLeftFighterArm().translate(-MOVEMENT, 0);
                break;

            case UP:
                ((RightFighter) rightFighter).getShape().translate(MOVEMENT, 0);
                ((LeftFighter) leftFighter).getLeftFighterArm().translate(0, -JUMP);
                try {
                    Thread.sleep(JUMP);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ((RightFighter) rightFighter).getShape().translate(MOVEMENT, 0);
                ((RightFighter) rightFighter).getRightFighterArm().translate(0, JUMP);
        }

        directionsRightFighter = DirectionsRightFighter.NODIRECTION;

    }

    public void punch2() {

        ((RightFighter) rightFighter).punch();
    }

    public void resetPunch2() {

        ((RightFighter) rightFighter).resetPunch();
    }

    public void setDirectionsRightFighter(DirectionsRightFighter directionRightFighter) {
        this.directionsRightFighter = directionRightFighter;
    }


}
