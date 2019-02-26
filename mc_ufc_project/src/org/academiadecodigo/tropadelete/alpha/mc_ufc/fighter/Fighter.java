package org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter;

public class Fighter {
    private int health;
    private final int DAMAGE = 30;
    private int randomDamage;
    private boolean dead;


    public Fighter(int health) {
        this.health = health;
        dead = false;
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

    public void movement(){

    }

}
