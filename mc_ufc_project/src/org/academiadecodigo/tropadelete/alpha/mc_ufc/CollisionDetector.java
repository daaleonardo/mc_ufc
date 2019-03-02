package org.academiadecodigo.tropadelete.alpha.mc_ufc;


import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.Fighter;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.LeftFighter;
import org.academiadecodigo.tropadelete.alpha.mc_ufc.fighter.RightFighter;

public class CollisionDetector {

    private Fighter leftFighter;
    private Fighter rightFighter;

    public CollisionDetector(Fighter leftFighter, Fighter rightFighter) {
        this.leftFighter = leftFighter;
        this.rightFighter = rightFighter;
    }

    public boolean isUnsafe() {
        return ((LeftFighter) leftFighter).getBodyShape().getX() + 310 == ((RightFighter) rightFighter).getBodyShape().getX();
    }


}
