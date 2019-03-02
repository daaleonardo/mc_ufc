package org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter;

import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.Directions;

public abstract class Fighter {

    private int health;
    private final int DAMAGE = 30;
    private int randomDamage;
    private boolean dead;
    private Directions directions;




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

        if (randomDamage >= health) {
            health = 0;
            dead = true;
            return;
        }
        health -= randomDamage;


    }


    public abstract int getX();

    public abstract int getY();



}
