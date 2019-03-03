package org.academiadecodigo.tropadelete.alpha.mc_ufc.Utils;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class HealthBar {

    private Rectangle healthBar;
    private int health;

    public HealthBar(int health, int posX, int posY) {

        healthBar = new Rectangle(posX, posY, health, 20);
        healthBar.setColor(Color.GREEN);
        this.health = health;
    }

    public void show() {
        healthBar.fill();
    }

    public void delete() {
        healthBar.delete();
    }

}
