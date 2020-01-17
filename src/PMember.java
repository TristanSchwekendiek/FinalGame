import org.newdawn.slick.Image;

public abstract class PMember {
    
    int health;
    int Mana=10;
    Image sprite;
    public boolean sleep=false;
    public boolean attackdrop=false;
    public boolean defensedrop=false;
    public boolean dead=false;
    
    public PMember(int hp, Image i){
        health=hp;
        sprite=i;
    }
    
    public void heal(int i){
        health+=i;
    }
    
    public int getHp(){
        return health;
    }
    
    public boolean checkDead(){
        if(health==0){
            dead=true;
        }else{
            dead=false;
        }
        return dead;
    }
    
    public void damage(int d){
        switch (d) {
            case 333:
                sleep=true;
                break;
            case 222:
                attackdrop=true;
                break;
            case 444:
                defensedrop=true;
                sleep=true;
                break;
            default:
                if(health-d<0){
                    health=0;
                    checkDead();
                }else{
                    health-=d;
                }   break;
        }
        
    }
    
    public abstract int attack1();
    
    public abstract int attack2();
    
    public abstract int attack3();
    
    
    
}
