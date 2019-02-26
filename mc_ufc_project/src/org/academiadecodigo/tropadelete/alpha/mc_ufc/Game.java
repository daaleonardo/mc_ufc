package org.academiadecodigo.tropadelete.alpha.mc_ufc;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.Directions;


public class Game {

    private Rectangle rectangle;
    private Rectangle shape;
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
        //shape.fill();
        this.directions = Directions.NODIRECTION;
        rectangle.grow(10,10);
    }

    public void start() {

        //rectangle.draw();


    }

    public void move() {

        switch (directions) {
            case RIGHT:
                shape.translate(10, 0);
                break;
            case LEFT:
                shape.translate(-10, 0);
                break;
        }

        directions = Directions.NODIRECTION;
    }

    public void setDirections(Directions direction) {
        this.directions = direction;
    }
}
