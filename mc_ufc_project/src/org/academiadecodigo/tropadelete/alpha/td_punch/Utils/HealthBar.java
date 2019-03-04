package org.academiadecodigo.tropadelete.alpha.td_punch.Utils;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;


public class HealthBar {

    private HealthText text;
    private Rectangle healthBar;
    private int health;

    public HealthBar(int health, int posX, int posY) {

        healthBar = new Rectangle(posX, posY, health, 20);
        healthBar.setColor(Color.GREEN);
        this.health = health;
        this.text = new HealthText(posX, posY, stringHealth());
    }

    public void show() {
        healthBar.fill();
        text.drawText();
    }

    public void delete() {
        healthBar.delete();
        text.deleteText();
    }

    public String stringHealth() {
        String s = health + "%";
        return s;
    }

    private class HealthText {

        private Text text;

        public HealthText(int posX, int posY, String health) {

            this.text = new Text(posX, posY, health);
        }

        public void drawText() {
            text.draw();
        }

        public void deleteText() {
            text.delete();
        }
    }
}
