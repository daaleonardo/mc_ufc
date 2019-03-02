package org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.Grid.GridRing;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.Directions;

public abstract class Fighter {

    private int health;
    private final int DAMAGE = 30;
    private int randomDamage;
    private boolean dead;
    private Directions directions;
    private Rectangle armShape;

    final int ARM = 120;
    final int JUMP = 100;
    final int MOVEMENT = 10;

    GridRing ring;

    private final int FIGHTER_SIZE = 300;


    public Fighter(int health, int posX) {

        this.health = health;
        dead = false;
        this.directions = Directions.NODIRECTION;

    }

    public boolean isDead() {
        return dead;
    }

    public int getHealth() {
        return health;
    }

    public void hit(Fighter fighter) {

        fighter.sufferDamage();
    }

    public void sufferDamage() {
        randomDamage = (int) (Math.random() * DAMAGE);

        if (randomDamage > health) {
            health = 0;
            dead = true;
            return;
        }
        health -= randomDamage;

    }

    public abstract int getX();

    public abstract int getY();

    //public void setPosX {

    //}


}
