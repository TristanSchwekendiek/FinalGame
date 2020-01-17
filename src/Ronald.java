
import org.newdawn.slick.Image;

public class Ronald extends PMember{

    public Ronald(int hp, Image i) {
        super(hp, i);
    }
    int atkmod=3;
    
    @Override
    public int attack1() {
        int damage = 0;
        Mana-=2;
        int swing = (int) (Math.random() * (21 - 1) + 1);
        if (swing > 7) {
            damage = (int) (Math.random() * (5 - 1) + 1) + atkmod;
            damage += (int) (Math.random() * (5 - 1) + 1);
            damage += (int) (Math.random() * (5 - 1) + 1);
            if (swing == 20) {
                int crit = (int) (Math.random() * (101 - 1) + 1);
                if (crit == 100) {
                    damage *= 4;
                } else {
                    damage *= 2;
                }
            }
        } else {
            damage = 0;
        }
        return damage;
    }

    @Override
    public int attack2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int attack3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
