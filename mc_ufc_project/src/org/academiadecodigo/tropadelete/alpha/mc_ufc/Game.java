package org.academiadecodigo.tropadelete.alpha.mc_ufc;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.Grid.GridRing;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.Screen.EndGame;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.Utils.HealthBar;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.Directions;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.DirectionsRightFighter;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.Fighter;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.LeftFighter;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.RightFighter;

import java.awt.*;

public class Game {

    private GridRing ring;

    private Directions directions;
    private DirectionsRightFighter directionsRightFighter;

    private final int JUMP = 100;
    private final int MOVEMENT = 10;

    private Fighter leftFighter;
    private Fighter rightFighter;

    private CollisionDetector collisionDetector;

    private HealthBar leftHealthBar;
    private HealthBar rightHealthBar;

    private boolean gameEnd;

    private Picture backGround;

    private boolean gameStart;

    private EndGame endScreen;

    public Game() {

        //GRID
        ring = new GridRing(120, 60);
        ring.init();


        //BACKGROUND
        backGround = new Picture(10, 10, "Resources/StartScreen.png");
        backGround.draw();

        //LEFT FIGHTER
        leftFighter = new LeftFighter(100, 30);
        ((LeftFighter) leftFighter).drawBodyClosed();
        ((LeftFighter) leftFighter).drawArm();

        //RIGHT FIGHTER
        rightFighter = new RightFighter(100, 1080);
        ((RightFighter) rightFighter).drawBodyClosed();
        ((RightFighter) rightFighter).drawArm();


        this.directionsRightFighter = DirectionsRightFighter.NODIRECTION;
        this.directions = Directions.NODIRECTION;

        collisionDetector = new CollisionDetector(leftFighter, rightFighter);

        leftHealthBar = new HealthBar(leftFighter.getHealth(), 30, 30);
        leftHealthBar.show();


        rightHealthBar = new HealthBar(rightFighter.getHealth(), 1090, 30);
        rightHealthBar.show();

        gameEnd = false;
    }


    public void start() {
        gameStart = true;
    }

    public boolean getGameStart(){
        return gameStart;
    }


    //                                                   LEFT FIGHTER
    public void move() {

        switch (directions) {

            case RIGHT:
                if (collisionDetector.isUnsafe()) {
                    if (rightFighter.getX() >= ring.getWidth() - 310) {
                        return;
                    }
                    ((RightFighter) rightFighter).getBodyShapeClosed().translate(MOVEMENT, 0);
                    ((RightFighter) rightFighter).getBodyShapeOpen().translate(MOVEMENT, 0);
                    ((RightFighter) rightFighter).getRightFighterArm().translate(MOVEMENT, 0);
                    ((RightFighter) rightFighter).getRightFighterArm_2().translate(MOVEMENT, 0);
                    ((RightFighter) rightFighter).getRightFighterArm_3().translate(MOVEMENT, 0);
                    ((RightFighter) rightFighter).getRightFighterArm_4().translate(MOVEMENT, 0);
                }
                try {
                    ((LeftFighter) leftFighter).deleteBodyClosed();
                    ((LeftFighter) leftFighter).drawBodyOpen();
                    Thread.sleep(70);
                    ((LeftFighter) leftFighter).deleteBodyOpen();
                    ((LeftFighter) leftFighter).drawBodyClosed();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                ((LeftFighter) leftFighter).getBodyShapeClosed().translate(MOVEMENT, 0);
                ((LeftFighter) leftFighter).getBodyShapeOpen().translate(MOVEMENT, 0);
                ((LeftFighter) leftFighter).getLeftFighterArm().translate(MOVEMENT, 0);
                ((LeftFighter) leftFighter).getLeftFighterArm_2().translate(MOVEMENT, 0);
                ((LeftFighter) leftFighter).getLeftFighterArm_3().translate(MOVEMENT, 0);
                ((LeftFighter) leftFighter).getLeftFighterArm_4().translate(MOVEMENT, 0);
                break;

            case LEFT:
                if (leftFighter.getX() <= ring.PADDING) { // BLOCKS THE PLAYER FROM GETTING OF
                    return;
                }

                ((LeftFighter) leftFighter).getBodyShapeClosed().translate(-MOVEMENT, 0);
                ((LeftFighter) leftFighter).getLeftFighterArm().translate(-MOVEMENT, 0);
                ((LeftFighter) leftFighter).getBodyShapeOpen().translate(-MOVEMENT, 0);
                ((LeftFighter) leftFighter).getLeftFighterArm_2().translate(-MOVEMENT, 0);
                ((LeftFighter) leftFighter).getLeftFighterArm_3().translate(-MOVEMENT, 0);
                ((LeftFighter) leftFighter).getLeftFighterArm_4().translate(-MOVEMENT, 0);
                break;

            case UP:
                ((LeftFighter) leftFighter).getBodyShapeClosed().translate(0, -JUMP);
                ((LeftFighter) leftFighter).getLeftFighterArm().translate(0, -JUMP);
                try {
                    Thread.sleep(JUMP);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ((LeftFighter) leftFighter).getBodyShapeClosed().translate(0, JUMP);
                ((LeftFighter) leftFighter).getLeftFighterArm().translate(0, JUMP);
        }

        directions = Directions.NODIRECTION;
    }


    public void punch() {
        ((LeftFighter) leftFighter).punch();

        if (rightFighter.getX() + 200 >= ring.getWidth()) {

            if (collisionDetector.leftPunch()) {
                leftFighter.hit(rightFighter);
                System.out.println("Right Fighter health is: " + rightFighter.getHealth());
                System.out.println("Is Right Fighter dead? " + rightFighter.isDead());
            }

            ((RightFighter) rightFighter).getBodyShapeClosed().translate(0, 0);
            ((RightFighter) rightFighter).getRightFighterArm().translate(0, 0);
            rightHealthBar.delete();
            rightHealthBar = new HealthBar(rightFighter.getHealth(), 1090, 30);
            rightHealthBar.show();
            if (rightFighter.isDead()) {
                endGame();
            }
            return;
        }
        if (collisionDetector.leftPunch()) {
            leftFighter.hit(rightFighter);
            System.out.println("Right Fighter health is: " + rightFighter.getHealth());
            System.out.println("Is right Fighter dead? " + rightFighter.isDead());
            ((RightFighter) rightFighter).getBodyShapeClosed().translate(80, 0);
            ((RightFighter) rightFighter).getRightFighterArm().translate(80, 0);
            ((RightFighter) rightFighter).getBodyShapeOpen().translate(80, 0);
            ((RightFighter) rightFighter).getRightFighterArm_2().translate(80, 0);
            ((RightFighter) rightFighter).getRightFighterArm_3().translate(80, 0);
            ((RightFighter) rightFighter).getRightFighterArm_4().translate(80, 0);
        }
        rightHealthBar.delete();
        rightHealthBar = new HealthBar(rightFighter.getHealth(), 1090, 30);
        rightHealthBar.show();
        if (rightFighter.isDead()) {
            endGame();
        }
    }

    public void resetPunch() {
        ((LeftFighter) leftFighter).resetPunch();
    }


    public void setDirections(Directions direction) {

        this.directions = direction;
    }


    //                                      RIGHT FIGHTER
    public void move2() {

        switch (directionsRightFighter) {

            case RIGHT:
                if (rightFighter.getX() + 220 >= ring.getWidth()) { // BLOCKS THE PLAYER FROM GETTING OFF
                    return;
                }
                ((RightFighter) rightFighter).getBodyShapeClosed().translate(MOVEMENT, 0);
                ((RightFighter) rightFighter).getRightFighterArm().translate(MOVEMENT, 0);
                ((RightFighter) rightFighter).getBodyShapeOpen().translate(MOVEMENT, 0);
                ((RightFighter) rightFighter).getRightFighterArm_2().translate(MOVEMENT, 0);
                ((RightFighter) rightFighter).getRightFighterArm_3().translate(MOVEMENT, 0);
                ((RightFighter) rightFighter).getRightFighterArm_4().translate(MOVEMENT, 0);
                break;

            case LEFT:
                if (collisionDetector.isUnsafe()) {
                    if (leftFighter.getX() <= ring.PADDING) { // BLOCKS THE PLAYER FROM GETTING OFF
                        return;
                    }
                    ((LeftFighter) leftFighter).getBodyShapeClosed().translate(-MOVEMENT, 0);
                    ((LeftFighter) leftFighter).getLeftFighterArm().translate(-MOVEMENT, 0);
                    ((LeftFighter) leftFighter).getBodyShapeOpen().translate(-MOVEMENT, 0);
                    ((LeftFighter) leftFighter).getLeftFighterArm_2().translate(-MOVEMENT, 0);
                    ((LeftFighter) leftFighter).getLeftFighterArm_3().translate(-MOVEMENT, 0);
                    ((LeftFighter) leftFighter).getLeftFighterArm_4().translate(-MOVEMENT, 0);

                }
                try {
                    ((RightFighter) rightFighter).deleteBodyClosed();
                    ((RightFighter) rightFighter).drawBodyOpen();
                    Thread.sleep(70);
                    ((RightFighter) rightFighter).deleteBodyOpen();
                    ((RightFighter) rightFighter).drawBodyClosed();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ((RightFighter) rightFighter).getBodyShapeClosed().translate(-MOVEMENT, 0);
                ((RightFighter) rightFighter).getRightFighterArm().translate(-MOVEMENT, 0);
                ((RightFighter) rightFighter).getBodyShapeOpen().translate(-MOVEMENT, 0);
                ((RightFighter) rightFighter).getRightFighterArm_2().translate(-MOVEMENT, 0);
                ((RightFighter) rightFighter).getRightFighterArm_3().translate(-MOVEMENT, 0);
                ((RightFighter) rightFighter).getRightFighterArm_4().translate(-MOVEMENT, 0);
                break;

            case UP:
                ((RightFighter) rightFighter).getBodyShapeClosed().translate(0, -JUMP);
                ((RightFighter) rightFighter).getRightFighterArm().translate(0, -JUMP);
                try {
                    Thread.sleep(JUMP);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ((RightFighter) rightFighter).getBodyShapeClosed().translate(0, JUMP);
                ((RightFighter) rightFighter).getRightFighterArm().translate(0, JUMP);
        }

        directionsRightFighter = DirectionsRightFighter.NODIRECTION;

    }

    public void punch2() {

        ((RightFighter) rightFighter).punch();


        if (leftFighter.getX() - 20 <= ring.PADDING + 30) { // BLOCKS THE PLAYER FROM GETTING OFF

            if (collisionDetector.rightPunch()) {
                rightFighter.hit(leftFighter);
                System.out.println("Left Fighter health is: " + leftFighter.getHealth());
                System.out.println("Is Left Fighter dead? " + leftFighter.isDead());
            }

            ((LeftFighter) leftFighter).getBodyShapeClosed().translate(0, 0);
            ((LeftFighter) leftFighter).getLeftFighterArm().translate(0, 0);
            leftHealthBar.delete();
            leftHealthBar = new HealthBar(leftFighter.getHealth(), 30, 30);
            leftHealthBar.show();
            if (leftFighter.isDead()) {
                endGame();
            }

            return;
        }
        if (collisionDetector.rightPunch()) {
            rightFighter.hit(leftFighter);
            System.out.println("Left Fighter health is: " + leftFighter.getHealth());
            System.out.println("Is Left Fighter dead? " + leftFighter.isDead());
            ((LeftFighter) leftFighter).getBodyShapeClosed().translate(-80, 0);
            ((LeftFighter) leftFighter).getLeftFighterArm().translate(-80, 0);
            ((LeftFighter) leftFighter).getBodyShapeOpen().translate(-80, 0);
            ((LeftFighter) leftFighter).getLeftFighterArm_2().translate(-80, 0);
            ((LeftFighter) leftFighter).getLeftFighterArm_3().translate(-80, 0);
            ((LeftFighter) leftFighter).getLeftFighterArm_4().translate(-80, 0);
        }
        leftHealthBar.delete();
        leftHealthBar = new HealthBar(leftFighter.getHealth(), 30, 30);
        leftHealthBar.show();
        if (leftFighter.isDead()) {
            endGame();
        }
    }

    public void resetPunch2() {

        ((RightFighter) rightFighter).resetPunch();
    }

    public void setDirectionsRightFighter(DirectionsRightFighter directionRightFighter) {
        this.directionsRightFighter = directionRightFighter;
    }


    public void endGame() {
        if (rightFighter.isDead() || leftFighter.isDead()) {

            ((RightFighter) rightFighter).getBodyShapeClosed().delete();
            ((LeftFighter) leftFighter).getBodyShapeClosed().delete();
            ((RightFighter) rightFighter).getRightFighterArm().delete();
            ((LeftFighter) leftFighter).getLeftFighterArm().delete();
            leftHealthBar.delete();
            rightHealthBar.delete();


            gameEnd = true;
        }
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

}
