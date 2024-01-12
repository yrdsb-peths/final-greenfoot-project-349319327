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
    GreenfootImage[] idle = new GreenfootImage[2];
    /**
     * Act - do whatever the BossOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int shootingDelay = 60;
    private int laserDelay = 120;
    private int laserLife = 2;
    private int shootingTimer = 0;
    private int attackState = 0;
    int bossHp = 100;
    String facing = "left";
    SimpleTimer animationTimer = new SimpleTimer();
    public BossOne()
    {
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/bossOne_sprite/bossOne" + i +".png");
            int newWidth = idle[i].getWidth() * 2; 
            int newHeight = idle[i].getHeight() * 2; 
        
            idle[i].scale(newWidth, newHeight);
        }
        animationTimer.mark();
        setImage(idle[0]);
    }
    
    int imageIndex = 0;
    public void animateBoss()
    {
        if(animationTimer.millisElapsed() < 220)
        {
            return;
        }
        animationTimer.mark();
        if (facing.equals("left"))  
        {
            setImage(idle[imageIndex]);
            imageIndex = (imageIndex + 1) % idle.length;
        } 
        
    }
    
    public void act()
    {
        // Add your action code here.
        hit();
        die();
        bulletSpeed();
        laserSpeed();
        animateBoss();
    }
    
     

    
    public void bulletSpeed()
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
    
    public void laserSpeed()
    {
        if (shootingTimer <= 0) 
        {
            laser();
            shootingTimer = laserDelay;
        } 
        else 
        {
            shootingTimer--;
        }
    }
    
    public void laser()
    {
        List<Frog> frogs = getWorld().getObjects(Frog.class);
        if (getWorld().getObjects(Frog.class).size() > 0) 
        {
        // Access the first Frog (index 0) from the list
            Frog croc = frogs.get(0);
            
            // Create and shoot BossBulletOne towards the Frog
            Laser beam = new Laser();
            int laserWidth = getX()*3;
            getWorld().addObject(beam, getX(), getY());
            beam.turnTowards(croc.getX(), croc.getY());
            laserLife--;
            if (laserLife <= 0) 
            {   
                MyWorld world = (MyWorld) getWorld();
                world.removeObject(beam);
            
            } 
        }
        
    }
}
