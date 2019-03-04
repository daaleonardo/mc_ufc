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
        return leftFighter.getX() + 260 >= rightFighter.getX();
    }

    public boolean leftPunch() {
        return ((LeftFighter) leftFighter).getArmX() >= rightFighter.getX() - 220;
    }

    public boolean rightPunch() {
        return ((RightFighter) rightFighter).getArmX() <= leftFighter.getX() + 220;
    }


}
