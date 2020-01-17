
import org.newdawn.slick.Image;

public class BurgerKing extends Enemy {

    public BurgerKing(int hp, Image i) {
        super(hp, i);
    }

    @Override
    public int attack1() {
        int damage = 0;
        int swing = (int) (Math.random() * (21 - 1) + 1);
        if (swing > 3) {
            damage = (int) (Math.random() * (7 - 1) + 1) + 4;
            damage += (int) (Math.random() * (7 - 1) + 1) + 4;
            if (swing == 20) {
                int crit = (int) (Math.random() * (101 - 1) + 1);
                if (crit == 100) {
                    damage = 999;
                } else {
                    damage *= 2;
                }
            }
        } else {
            damage = 0;
        }
        if(health<10){
            damage*=2;
        }
        return damage;
    }

    @Override
    public int attack2() {
        return 333;
    }

    @Override
    public int attack3() {
        int damage = 0;
        int swing = (int) (Math.random() * (21 - 1) + 1);
        if (swing > 5) {
            damage = (int) (Math.random() * (7 - 1) + 1) + 4;
            if (swing == 20) {
                int crit = (int) (Math.random() * (101 - 1) + 1);
                if (crit == 100) {
                    damage = 999;
                } else {
                    damage *= 2;
                }
            }
        } else {
            damage = 0;
        }
        if(health<10){
            damage*=2;
        }
        setHp(-damage);
        return damage;
    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




}
