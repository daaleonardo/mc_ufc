package org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class LeftFighter extends Fighter {

    private Picture leftFighterArm;
    private Picture bodyShape;


    //private Directions directions;
    private final int ARM = 120;


    public LeftFighter(int health, int posX) {
        super(health, posX);

        bodyShape = new Picture(posX, 200 - 50, "Resources/fighterLeft.png");

        leftFighterArm = new Picture(getX() + 240, getY() + 130, "Resources/leftfighterglove.png");

      //  this.directions = Directions.NODIRECTION;
    }

    public void punch() {

        try {
            Thread.sleep(30);
            leftFighterArm.draw();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resetPunch() {

        try {
            Thread.sleep(250);
            leftFighterArm.delete();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void draw() {
        bodyShape.draw();
    }

    public Picture getBodyShape() {
        return bodyShape;
    }

    public Picture getLeftFighterArm() {
        return leftFighterArm;
    }


    public int getX(){
        return bodyShape.getX();
    }

    public int getY(){
        return bodyShape.getY();
    }

}
