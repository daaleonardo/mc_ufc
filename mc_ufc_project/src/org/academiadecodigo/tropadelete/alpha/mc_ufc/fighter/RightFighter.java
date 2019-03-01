package org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.Grid.GridRing;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.Directions;

public class RightFighter extends Fighter {

    private int health;
    private Rectangle armShape;


    private final int DAMAGE = 30;
    private int randomDamage;
    private boolean dead;
    //private Rectangle shape;
    private GridRing ring;
    private Directions directions;
    private final int FIGHTER_SIZE = 300;
    private final int ARM = 120;
    private final int JUMP = 100;
    private final int MOVEMENT = 10;

    public RightFighter(int health, int posX) {

        super(health, posX);

        armShape = new Rectangle(getX(), getY() + -60, ARM, 10);

        this.directions = Directions.NODIRECTION;

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

}
