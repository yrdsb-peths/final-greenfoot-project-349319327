import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class BossOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossOne extends Actor
{
    /**
     * Act - do whatever the BossOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int shootingDelay = 60;
    private int shootingTimer = 0;
    int bossHp = 100;
    public void act()
    {
        // Add your action code here.
        
        hit();
        die();
        shootSpeed();
        
    }
    
    public void shootSpeed()
    {
        if (shootingTimer <= 0) 
        {
            atkOne();
            shootingTimer = shootingDelay;
        } 
        else 
        {
            shootingTimer--;
        }
    }
    public void hit()
    {
        if(isTouching(Bullet.class))
        {   
            removeTouching(Bullet.class);
            bossHp -= 2;
            
        }
    }
    
    public void die()
    {
        if(bossHp <= 0)
        {
            MyWorld world = (MyWorld) getWorld();
            if (world != null) 
            {   
                world.gameWin();
                world.removeObject(this);
            }
        }
    }
    
    public void atkOne()
    {      
        List<Frog> frogs = getWorld().getObjects(Frog.class);
         if (getWorld().getObjects(Frog.class).size() > 0) {
        // Access the first Frog (index 0) from the list
        Frog croc = frogs.get(0);
        
        // Create and shoot BossBulletOne towards the Frog
        BossBulletOne bullet = new BossBulletOne();
        getWorld().addObject(bullet, getX(), getY());
        bullet.turnTowards(croc.getX(), croc.getY());
    }

    }
}
