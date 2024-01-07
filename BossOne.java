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
    private int attackState = 0;
    int bossHp = 100;
    public void act()
    {
        // Add your action code here.
        GreenfootImage bossImage = new GreenfootImage("images/bossOne_sprite/bossOne.png");
        int newWidth = bossImage.getWidth() * 2; 
        int newHeight = bossImage.getHeight() * 2; 
        bossImage.scale(newWidth, newHeight);
        setImage(bossImage);
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
        if (getWorld().getObjects(Frog.class).size() > 0) 
        {
        // Access the first Frog (index 0) from the list
        Frog croc = frogs.get(0);
        
        // Create and shoot BossBulletOne towards the Frog
        BossBulletOne bullet = new BossBulletOne();
        getWorld().addObject(bullet, getX(), getY());
        bullet.turnTowards(croc.getX(), croc.getY());
        }
    
    }
    
    public void pillarAtk()
    {
        
        for (int i = 0; i < 3; i++) 
        {
            pillar pillar = new pillar();
            // Adjust X and Y coordinates as needed for the pillars' positions
            getWorld().addObject(pillar, getX() + (i * 100), getY());
        }
    
    }
}
