import java.util.ArrayList;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public abstract class Enemy {
    
    int health;
    Image sprite;
    public boolean dead = false;
    
    public Enemy(int hp, Image i){
        health = hp;
        sprite = i;
    }
    
    public int getHp(){
        return health;
    }
    
    public void setHp(int i){
        health -= i;
    }
    
    public int damage(int d){
        if((health-d)>0){
            health-=d;
            return health;
        }else{
            return 0;
        }
    }
    
    public boolean checkDead(){
        if(health==0){
            dead=true;
        }else{
            dead=false;
        }
        return dead;
    }
    
    public abstract int attack1();
    
    public abstract int attack2();
    
    public abstract int attack3();
    
    public abstract void draw();
    
    
    public int selectTarget() {
        int target;
        target = (int) (Math.random() * (4 - 1) + 1);
        return target;
    }


    public void selectAttack() {
        int attack;
        attack = (int) (Math.random() * (4 - 1) + 1);
        if (attack == 1) {
            attack1();
        } else if (attack == 2) {
            attack2();
        } else if (attack == 3) {
            attack3();
        } else {
            System.out.println("Error - No attack chosen");
        }
    }
    
}
