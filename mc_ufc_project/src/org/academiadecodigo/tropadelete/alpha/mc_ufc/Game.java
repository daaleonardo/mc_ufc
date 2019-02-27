package org.academiadecodigo.tropadelete.alpha.mc_ufc;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.Directions;


public class Game {

    private Rectangle rectangle;
    private Rectangle shape;
    private Rectangle armShape;
    private Directions directions;
    private Picture picture;

    public Game() {
        rectangle = new Rectangle(10, 10, 1200, 600);
        rectangle.draw();
        /*picture = new Picture(5, 5, "Resources/mask.png");
        picture.grow(-800, -1100);
        picture.translate(-400, -1070);
        picture.draw();*/
        shape = new Rectangle(30, 310, 10, 300);
        shape.fill();

        armShape = new Rectangle(shape.getX(), shape.getY() + 60, 120, 10);
        this.directions = Directions.NODIRECTION;

    }

    public void start() {

        //rectangle.draw();


    }

    public void move() {

        switch (directions) {
            case RIGHT:
                shape.translate(10, 0);
                armShape.translate(10, 0);
                break;
            case LEFT:
                shape.translate(-10, 0);
                armShape.translate(-10, 0);
                break;
        }

        directions = Directions.NODIRECTION;
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
            Thread.sleep(100);
            armShape.delete();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setDirections(Directions direction) {
        this.directions = direction;
    }
}
