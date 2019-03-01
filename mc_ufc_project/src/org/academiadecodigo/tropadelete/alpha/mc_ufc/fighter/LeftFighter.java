package org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter;

import org.academiadecodigo.tropadelete.alpha.mc_ufc.Grid.GridRing;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.Directions;

import java.awt.*;

public class LeftFighter extends Fighter {

    private int health;
    private Rectangle armShape;


    private Directions directions;
    private final int ARM = 120;


    public LeftFighter(int health, int posX) {
        super(health, posX);


        armShape = new Rectangle(getX(), getY() + 60, ARM, 10);
        this.directions = Directions.NODIRECTION;
    }

    public void punch() {

        try {
            Thread.sleep(30);
           // armShape.fill();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resetPunch() {

        try {
            Thread.sleep(250);
           // armShape.delete();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
