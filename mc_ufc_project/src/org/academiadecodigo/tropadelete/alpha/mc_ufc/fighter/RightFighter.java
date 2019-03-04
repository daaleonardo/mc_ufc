package org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class RightFighter extends Fighter {

    private Picture bodyShapeClosed;
    private Picture bodyShapeOpen;

    private Picture rightFighterArm;
    private Picture rightFighterArm_2;
    private Picture rightFighterArm_3;
    private Picture rightFighterArm_4;


    public RightFighter(int health, int posX) {
        super(health, posX);

        bodyShapeClosed = new Picture(posX - 80, 131, "Resources/fighters/fighterRightClosed.png");
        bodyShapeOpen = new Picture(posX - 140, 131, "Resources/fighters/fighterRightOpen.png");

        rightFighterArm = new Picture(getX() - 70, getY() + 61, "Resources/fighters/punch-right-1.png");
        rightFighterArm_2 = new Picture(getX() - 90, getY() + 61, "Resources/fighters/punch-right-2.png");
        rightFighterArm_3 = new Picture(getX() - 120, getY() + 61, "Resources/fighters/punch-right-3.png");
        rightFighterArm_4 = new Picture(getX() - 150, getY() + 61, "Resources/fighters/punch-right-4.png");
    }

    public void punch() {

        try {
            rightFighterArm.delete();
            rightFighterArm_2.draw();
            Thread.sleep(50);
            rightFighterArm_2.delete();
            rightFighterArm_3.draw();
            Thread.sleep(50);
            rightFighterArm_3.delete();
            rightFighterArm_4.draw();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resetPunch() {

        try {
            Thread.sleep(60);
            rightFighterArm_4.delete();
            rightFighterArm.draw();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deletePunch() {
        rightFighterArm.delete();
        rightFighterArm_2.delete();
        rightFighterArm_3.delete();
        rightFighterArm_4.delete();
    }

    public void drawBodyClosed() {
        bodyShapeClosed.draw();
    }

    public void deleteBodyClosed() {
        bodyShapeClosed.delete();
    }

    public void drawBodyOpen() {
        bodyShapeOpen.draw();
    }

    public void deleteBodyOpen() {
        bodyShapeOpen.delete();
    }

    public void drawArm() {
        rightFighterArm.draw();
    }


    public Picture getRightFighterArm() {
        return rightFighterArm;
    }

    public Picture getRightFighterArm_2() {
        return rightFighterArm_2;
    }

    public Picture getRightFighterArm_3() {
        return rightFighterArm_3;
    }

    public Picture getRightFighterArm_4() {
        return rightFighterArm_4;
    }

    public Picture getBodyShapeClosed() {
        return bodyShapeClosed;
    }

    public Picture getBodyShapeOpen() {
        return bodyShapeOpen;
    }

    public int getArmX() {
        return rightFighterArm.getX(); //FIZ
    }


    public int getX() {
        return bodyShapeClosed.getX();
    }

    public int getY() {
        return bodyShapeClosed.getY();
    }
}
