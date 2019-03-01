package org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.Grid.GridRing;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.Directions;

public class RightFighter extends Fighter {

    private Picture rightFighterArm;


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

    private Picture shape;

    public RightFighter(int health, int posX) {

        super(health, posX);

        rightFighterArm = new Picture(getX() + 40, getY(), "Resources/rightfighterglove.png");

        shape = new Picture(800, 200 + 40, "Resources/fighterRight.png");

        this.directions = Directions.NODIRECTION;

    }


    public void punch() {

        try {
            Thread.sleep(30);
            rightFighterArm.draw();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resetPunch() {

        try {
            Thread.sleep(250);
            rightFighterArm.delete();

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

    public Picture getRightFighterArm(){
        return rightFighterArm;
    }

}
