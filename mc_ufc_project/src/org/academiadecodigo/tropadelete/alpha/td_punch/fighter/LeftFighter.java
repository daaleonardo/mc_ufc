package org.academiadecodigo.tropadelete.alpha.td_punch.fighter;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class LeftFighter extends Fighter {

    private Picture bodyShapeClosed;
    private Picture bodyShapeOpen;

    private Picture leftFighterArm;
    private Picture leftFighterArm_2;
    private Picture leftFighterArm_3;
    private Picture leftFighterArm_4;


    public LeftFighter(int health, int posX) {
        super(health, posX);

        bodyShapeClosed = new Picture(posX + 70, 160, "Resources/fighters/fighterLeftClosed.png");
        bodyShapeOpen = new Picture(posX - 20, 160, "Resources/fighters/fighterLeftOpen.png");

        leftFighterArm = new Picture(getX() + 76, getY() + 33, "Resources/fighters/punch-left-1.png");
        leftFighterArm_2 = new Picture(getX() + 76, getY() + 33, "Resources/fighters/punch-left-2.png");
        leftFighterArm_3 = new Picture(getX() + 76, getY() + 33, "Resources/fighters/punch-left-3.png");
        leftFighterArm_4 = new Picture(getX() + 76, getY() + 33, "Resources/fighters/punch-left-4.png");
    }

    public void punch() {

        try {
            leftFighterArm.delete();
            leftFighterArm_2.draw();
            Thread.sleep(50);
            leftFighterArm_2.delete();
            leftFighterArm_3.draw();
            Thread.sleep(50);
            leftFighterArm_3.delete();
            leftFighterArm_4.draw();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resetPunch() {

        try {
            Thread.sleep(60);
            leftFighterArm_4.delete();
            leftFighterArm.draw();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deletePunch(){
        leftFighterArm.delete();
        leftFighterArm_2.delete();
        leftFighterArm_3.delete();
        leftFighterArm_4.delete();
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
        leftFighterArm.draw();
    }

    public Picture getBodyShapeClosed() {
        return bodyShapeClosed;
    }

    public Picture getBodyShapeOpen() {
        return bodyShapeOpen;
    }

    public Picture getLeftFighterArm() {
        return leftFighterArm;
    }

    public Picture getLeftFighterArm_2() {
        return leftFighterArm_2;
    }

    public Picture getLeftFighterArm_3() {
        return leftFighterArm_3;
    }

    public Picture getLeftFighterArm_4() {
        return leftFighterArm_4;
    }

    public int getArmX() {
        return leftFighterArm_4.getX();
    }


    public int getX() {
        return bodyShapeClosed.getX();
    }

    public int getY() {
        return bodyShapeClosed.getY();
    }

}
