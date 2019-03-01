package org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.Grid.GridRing;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.Directions;

import java.awt.*;

public class LeftFighter extends Fighter {

    private Picture leftFighterArm;
    private Picture shape;


    private Directions directions;
    private final int ARM = 120;


    public LeftFighter(int health, int posX) {
        super(health, posX);

        shape = new Picture(posX, 200 - 50, "Resources/fighterLeft.png");

        leftFighterArm = new Picture(getX() + 240, getY(), "Resources/leftfighterglove.png");

        this.directions = Directions.NODIRECTION;
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
        shape.draw();
    }

    public Picture getShape() {
        return shape;
    }

    public Picture getLeftFighterArm() {
        return leftFighterArm;
    }


    public int getX(){
        return shape.getX();
    }

    public int getY(){
        return shape.getY();
    }

}
