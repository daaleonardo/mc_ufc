package org.academiadecodigo.tropadelete.alpha.td_punch;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.alpha.td_punch.Grid.GridRing;
import org.academiadecodigo.tropadelete.alpha.td_punch.Screen.EndGame;
import org.academiadecodigo.tropadelete.alpha.td_punch.Utils.HealthBar;
import org.academiadecodigo.tropadelete.alpha.td_punch.directions.Directions;
import org.academiadecodigo.tropadelete.alpha.td_punch.directions.DirectionsRightFighter;
import org.academiadecodigo.tropadelete.alpha.td_punch.fighter.Fighter;
import org.academiadecodigo.tropadelete.alpha.td_punch.fighter.LeftFighter;
import org.academiadecodigo.tropadelete.alpha.td_punch.fighter.RightFighter;


public class Game {

    private GridRing ring;

    private Directions directions;
    private DirectionsRightFighter directionsRightFighter;

    private final int JUMP = 100;
    private final int MOVEMENT = 20;

    private Fighter leftFighter;
    private Fighter rightFighter;

    private CollisionDetector collisionDetector;

    private HealthBar leftHealthBar;
    private HealthBar rightHealthBar;

    private boolean gameEnd;

    private Picture backGround;

    private boolean gameStart;

    private EndGame endScreen;

    private boolean punchLeftFighter;
    private boolean punchRightFighter;
    private Sound[] sound = {new Sound("/Resources/soundfx/punch.wav"),
            new Sound("/Resources/soundfx/grunt.wav"),
            new Sound("/Resources/soundfx/Woosh.wav")};


    public Game() {


        //GRID
        ring = new GridRing(120, 60);
        ring.init();


        //BACKGROUND
        backGround = new Picture(10, 10, "Resources/screen/ring.png");
        backGround.draw();

        //LEFT FIGHTER
        leftFighter = new LeftFighter(100, 80);
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

        punchLeftFighter = false;
        punchRightFighter = false;
    }


    public void start() {
        gameStart = true;
    }

    public boolean getGameStart() {
        return gameStart;
    }


    //                                                   LEFT FIGHTER
    public void move() {

        switch (directions) {

            case RIGHT:
                if (collisionDetector.isUnsafe()) {
                    if (rightFighter.getX() >= ring.getWidth() - 200) {
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
                    ((LeftFighter) leftFighter).getLeftFighterArm().delete();
                    ((LeftFighter) leftFighter).drawBodyOpen();
                    ((LeftFighter) leftFighter).getLeftFighterArm().draw();
                    Thread.sleep(60);
                    ((LeftFighter) leftFighter).deleteBodyOpen();
                    ((LeftFighter) leftFighter).getLeftFighterArm().delete();
                    ((LeftFighter) leftFighter).drawBodyClosed();
                    ((LeftFighter) leftFighter).getLeftFighterArm().draw();

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
                if (leftFighter.getX() <= 130) { // BLOCKS THE PLAYER FROM GETTING OF
                    return;
                }

                ((LeftFighter) leftFighter).getBodyShapeClosed().translate(-MOVEMENT, 0);
                ((LeftFighter) leftFighter).getLeftFighterArm().translate(-MOVEMENT, 0);
                ((LeftFighter) leftFighter).getBodyShapeOpen().translate(-MOVEMENT, 0);
                ((LeftFighter) leftFighter).getLeftFighterArm_2().translate(-MOVEMENT, 0);
                ((LeftFighter) leftFighter).getLeftFighterArm_3().translate(-MOVEMENT, 0);
                ((LeftFighter) leftFighter).getLeftFighterArm_4().translate(-MOVEMENT, 0);
                break;
        }

    }

    public void setPunchLeftFighter(boolean state) {
        punchLeftFighter = state;
    }

    public boolean getPunchLeftFighter() {
        return punchLeftFighter;
    }


    public void punch() {


        ((LeftFighter) leftFighter).punch();
        if (!collisionDetector.leftPunch()) {
            sound[2].play(true);
        }

        if (rightFighter.getX() + 200 >= ring.getWidth() - 50) {


            if (collisionDetector.leftPunch()) {
                sound[0].play(true);
                sound[1].play(true);
                leftFighter.hit(rightFighter);
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
            sound[0].play(true);
            sound[1].play(true);
            leftFighter.hit(rightFighter);
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

    public void deleteArm() {
        ((LeftFighter) leftFighter).deletePunch();
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
                    if (leftFighter.getX() <= 130) { // BLOCKS THE PLAYER FROM GETTING OFF
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
                    ((RightFighter) rightFighter).getRightFighterArm().delete();
                    ((RightFighter) rightFighter).drawBodyOpen();
                    ((RightFighter) rightFighter).getRightFighterArm().draw();
                    Thread.sleep(60);
                    ((RightFighter) rightFighter).deleteBodyOpen();
                    ((RightFighter) rightFighter).getRightFighterArm().delete();
                    ((RightFighter) rightFighter).drawBodyClosed();
                    ((RightFighter) rightFighter).getRightFighterArm().draw();

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
        }


    }

    public void setPunchRightFighter(boolean state) {
        punchRightFighter = state;
    }

    public boolean getPunchRightFighter() {
        return punchRightFighter;
    }

    public void punch2() {

        ((RightFighter) rightFighter).punch();

        if (!collisionDetector.rightPunch()) {
            sound[2].play(true);
        }
        if (leftFighter.getX() - 80 <= 80) { // BLOCKS THE PLAYER FROM GETTING OFF
            if (collisionDetector.rightPunch()) {
                sound[0].play(true);
                sound[1].play(true);
                rightFighter.hit(leftFighter);
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
            sound[0].play(true);
            sound[1].play(true);
            rightFighter.hit(leftFighter);
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

    public void deleteArm2() {
        ((RightFighter) rightFighter).deletePunch();
    }

    public void setDirectionsRightFighter(DirectionsRightFighter directionRightFighter) {
        this.directionsRightFighter = directionRightFighter;
    }


    public void endGame() {
        if (rightFighter.isDead() || leftFighter.isDead()) {

            try {
                Thread.sleep(20);
                ((RightFighter) rightFighter).getBodyShapeClosed().delete();
                ((LeftFighter) leftFighter).getBodyShapeClosed().delete();
                ((RightFighter) rightFighter).getRightFighterArm().delete();
                ((LeftFighter) leftFighter).getLeftFighterArm().delete();
                leftHealthBar.delete();
                rightHealthBar.delete();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            gameEnd = true;
        }
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public boolean isLeftFighterDead() {
        return leftFighter.isDead();
    }

    public boolean isRightFighterDead() {
        return rightFighter.isDead();
    }

}
